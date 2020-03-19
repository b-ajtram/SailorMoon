package GameItems;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import GameEnums.Directions;
import paooGame.ImageLoader;
import paooGame.Map;

public class Player extends MovingItem {
	String characterName;
	private ArrayList<Image> backImage = new ArrayList<>();
	private int health;
	private int points;
	private boolean hasCat;
	private boolean hasKey;
	boolean isAlive;
	boolean isOnLadder;
	boolean isOnLand;

	public Player(int x, int y, ArrayList<Image> left, ArrayList<Image> right, ArrayList<Image> back, String name) {
		super(x, y, left, right);
		characterName=name;
		this.backImage = back;
		this.points = 0;
		this.isAlive = true;
		this.health = 1000;
		this.isOnLadder = false;
		this.isOnLand = true;
		this.hasCat = false;
		this.hasKey=false;
		setVelocity(6);
	}
	public String getName(){return characterName;}

	public boolean playerHasKey(){
		return hasKey;
	}

	public int getHealth() {
		return health;
	}

	public void increasePoints(int points) {
		this.points += points;
	}

	public int getPoints() {
		return points;
	}

	public void setOnLadder(boolean value) {
		this.isOnLadder = value;
	}

	public void setOnLand(boolean value) {
		this.isOnLand = value;
	}

	public boolean isOnLadder() {
		return this.isOnLadder;
	}

	public boolean isOnLand() {
		return this.isOnLand;
	}


	public void moveUp() {
		image = backImage.get(0);
		if (direction != Directions.UP) {
			resetIndex();
		}
		if (isOnLadder) {
			this.y -= getVelocity();
			setNextIndex();
		}
		direction = Directions.UP;
		int index = getImageIndex();
		image = backImage.get(index);
	}

	public void moveDown() {
		image = backImage.get(0);
		if (direction != Directions.DOWN) {
			resetIndex();
		}
		if (isOnLadder) {
			this.y += getVelocity();
			setNextIndex();
		}
		direction = Directions.DOWN;
		int index = getImageIndex();
		image = backImage.get(index);
	}

	public void replacePlayer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean walkingCollisions(ArrayList<Item> items) {
		for (Item a : items) {
			if (a.isVisible()) {
				if (getBounds().intersects(a.getBounds())) {
					setOnLand(false);
					setOnLadder(true);
					if (a instanceof RestrictionTile) {
						setOnLand(true);
						setOnLadder(true);
						return false;
					}
					return false;

				}
			}
		}
		return true;
	}

	public boolean collectableCollisions(ArrayList<Item> items) {
		for (Item a : items) {
			if (a.isVisible()) {
				if (getBounds().intersects(a.getBounds())) {
					if (a instanceof Coin) {
						points += 50;
						((Coin) a).pickItem();
					}
					if (a instanceof Key && hasCat) {
						((Key) a).pickKey();
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean monsterCollisions(ArrayList<Enemy> items) {
		for (Enemy a : items) {
			if (a.isVisible()) {
				if (getBounds().intersects(a.getBounds())) {
					health -= a.getDamageInflicted();
				}
			}
		}

		if (health > 0)
			return false;
		return true;
	}
}