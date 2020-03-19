package paooGame;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import GameItems.*;
import GameEnums.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Board class of the game
 */
public class Board extends JPanel implements ActionListener, KeyListener {

	private ArrayList<Item> backgroundItems = new ArrayList<>();
	private ArrayList<Item> collidableItems = new ArrayList<>();
	private ArrayList<Item> collectableItems = new ArrayList<>();
	private ArrayList<Enemy> enemies;
	private static final int playerInitialX = 0;
	private static final int playerInitialY = 394;
	private final int catInitialX=0;
	private final int catInitialY=60;
	Database db=new Database();
	Map map;
	MonstersINC monsters;

	BackgroundLoader backgroundLoader = BackgroundLoader.getInstance(Map.BOARD_WIDTH, Map.BOARD_HEIGHT);
	ImageLoader imageLoader = ImageLoader.getInstance();
	private Player player=new GetPlayer().returnPlayer(OpenView.characterName, playerInitialX, playerInitialY);
	private Cat cat= new Cat(catInitialX, catInitialY,
			imageLoader.getCatLeft(), imageLoader.getCatRight(), imageLoader.getCatBack());
	Door door=new Door(1140, 394,imageLoader.getClosedDoor(), imageLoader.getOpenDoor());
	private Timer timer = new Timer(10, this);
	private Level level;

	public Board(Level level){
		this.level = level;
		initBoard();
		timer.start();
	}

	/**
	 * Initialize the board.
	 */
	private void initBoard() {
		int lvl=level.getValue();
		String pathBackground=db.getBackgroundPath(lvl);
		String pathForeground=db.getForegroundPath(lvl);
		String pathCollectable=db.getCollectablePath(lvl);
		map=new Map(pathForeground, pathBackground, pathCollectable);
		addKeyListener(this);
		setFocusable(true);
		setPreferredSize(new Dimension(Map.BOARD_WIDTH, Map.BOARD_HEIGHT));
		initBlocks();
		monsters=new MonstersINC();
		enemies = monsters.createEnemies(level);
	}

	/**
	 * Initialize blocks according to the map.
	 */

	void initBlocks() {
		addBlocks(Map.background, this.backgroundItems);
		addBlocks(Map.foreground, this.collidableItems);
		addBlocks(Map.collectable, this.collectableItems);
	}

	void addBlocks(int map[][], ArrayList<Item> items) {
		int type;
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				type = map[x][y];
				BlockType bType = BlockType.getTypeFromInt(type);
				items.add((new TileFactory()).CreateTile(level, bType, y * 48, x * 48));
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawObjects(g);
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Draw objects on the board.
	 */
	private void drawObjects(Graphics g) {
		g.drawImage(backgroundLoader.getLevelBackground(level), 0, 0, this);
		for (Item a : backgroundItems) {
			if (a.isVisible()) {
				g.drawImage(a.getImage(), a.getX(), a.getY(), this);
			}
		}
		for (Item a : collidableItems) {
			if (a.isVisible()) {
				g.drawImage(a.getImage(), a.getX(), a.getY(), this);
			}
		}
		for (Item c : collectableItems) {
			if (c.isVisible()) {
				g.drawImage(c.getImage(), c.getX(), c.getY(), this);
			}
		}
		for (Enemy a : enemies) {
			if (a.isVisible()) {
				g.drawImage(a.getImage(), a.getX(), a.getY(), this);
			}
		}
		g.drawImage(door.getImage(), door.getX(), door.getY(), this);
		g.drawImage(cat.getImage(), cat.getX(), cat.getY(), this);
		g.drawImage(player.getImage(), player.getX(), player.getY(), this);
	}

	public void update() {
		for (Enemy a : enemies) {
			if (a.isVisible()) {
				a.move();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		update();
		checkCollisions();
	}

	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (player.isOnLand()) {
			if (code == KeyEvent.VK_LEFT) {
				player.moveLeft();
				if(cat.isPicked())
					cat.moveLeft();
			}
			if (code == KeyEvent.VK_RIGHT) {
				player.moveRight();
				if(cat.isPicked())
					cat.moveRight();
			}
		}
		if (player.isOnLadder()) {
			if (code == KeyEvent.VK_UP) {
				player.moveUp();
				if(cat.isPicked())
					cat.moveUp();
			}
			if (code == KeyEvent.VK_DOWN) {
				player.moveDown();
				if(cat.isPicked())
					cat.moveDown();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public void checkCollisions() {
		if(player.walkingCollisions(collidableItems)) {
			player.setOnLand(true);
			player.setOnLadder(false);
		}
		if(cat.getBounds().intersects(player.getBounds())&& (!cat.isPicked())){
			player.increasePoints(100*level.getValue());
			cat.pickCat();
		}
		if(player.collectableCollisions(collectableItems)){
			door.openDoor();
		}
		if(player.getBounds().intersects(door.getBounds())&& player.playerHasKey()){
			nextLevel();
		}
		player.monsterCollisions(enemies);
	}

	public void resetArray(){

		for (Item a : backgroundItems) {
			if (a.isVisible()) {
				a.setVisible(false);
			}
		}
		for (Item a : collidableItems) {
			if (a.isVisible()) {
				a.setVisible(false);
			}
		}
		for (Item c : collectableItems) {
			c.setVisible(false);
		}
	}
	
	public void nextLevel() {
		if(level.getValue()<3) {
			db.saveLevel(level.getValue(), player.getPoints(), player.getHealth(), player.getName());
			Level newLevel = Level.getTypeFromInt(level.getValue() + 1);
			level=newLevel;
			int lvl=level.getValue();
			String pathBackground=db.getBackgroundPath(lvl);
			String pathForeground=db.getForegroundPath(lvl);
			String pathCollectable=db.getCollectablePath(lvl);
			resetArray();
			map.updateMap(pathForeground, pathBackground, pathCollectable);
			initBlocks();
			player.replacePlayer(playerInitialX, playerInitialY);
			cat.replaceCat(catInitialX, catInitialY);
			monsters.createEnemies(level);
		}
		else{
			System.exit(0);
		}
	}
}
