package paooGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageLoader {
//PLAYER
	private final ArrayList<Image> sailorMoonLeft = new ArrayList<>();
	private final ArrayList<Image> sailorMoonRight = new ArrayList<>();
	private final ArrayList<Image> sailorMoonBack = new ArrayList<>();

	private final ArrayList<Image> sailorMarsLeft = new ArrayList<>();
	private final ArrayList<Image> sailorMarsRight = new ArrayList<>();
	private final ArrayList<Image> sailorMarsBack = new ArrayList<>();
	
	private final ArrayList<Image> sailorJupiterLeft = new ArrayList<>();
	private final ArrayList<Image> sailorJupiterRight = new ArrayList<>();
	private final ArrayList<Image> sailorJupiterBack = new ArrayList<>();
	
	private final ArrayList<Image> sailorVenusLeft = new ArrayList<>();
	private final ArrayList<Image> sailorVenusRight = new ArrayList<>();
	private final ArrayList<Image> sailorVenusBack = new ArrayList<>();
	
	private final ArrayList<Image> sailorMercuryLeft = new ArrayList<>();
	private final ArrayList<Image> sailorMercuryRight = new ArrayList<>();
	private final ArrayList<Image> sailorMercuryBack = new ArrayList<>();

//ENEMY
	private final ArrayList<Image> ghostLeft = new ArrayList<>();
	private final ArrayList<Image> ghostRight = new ArrayList<>();

	private final ArrayList<Image> batLeft = new ArrayList<>();
	private final ArrayList<Image> batRight = new ArrayList<>();

	private final ArrayList<Image> skullLeft = new ArrayList<>();
	private final ArrayList<Image> skullRight = new ArrayList<>();

//ANIMALS
	private final ArrayList<Image> catLeft = new ArrayList<>();
	private final ArrayList<Image> catRight = new ArrayList<>();
	private final ArrayList<Image> catBack = new ArrayList<>();

//TILES
	private final ArrayList<Image> tilesLevel1 = new ArrayList<>();
	private final ArrayList<Image> tilesLevel2 = new ArrayList<>();
	private final ArrayList<Image> tilesLevel3 = new ArrayList<>();

//MISC	
	private final Image closedDoor;
	private final Image openDoor;
	private final Image ladder;
	private final Image invisibleLadder;
	
//COLLECTABLE
	private final Image potion;
	private final Image key;
	private final Image attackBoost;
	
//ATTACK
	private final Image coin;
	
//singleton:	
	private final Image emptyImage;
	private final Image restrictionImage;

	private static ImageLoader instance;

	public static ImageLoader getInstance() {
		if (instance != null) {
			return instance;
		} else {
			return new ImageLoader();
		}
	}

//TILE LOADER	
	public void TileLoader(String path, ArrayList<Image> Level, int width, int height) {
		BufferedImage fullImage = null;
		try {
			fullImage = ImageIO.read(new File(path));
			for (int i = 0; i < fullImage.getWidth(); i += width) {
				Image img = fullImage.getSubimage(i, 0, width, height);
				Level.add(img);

			}
		} catch (IOException e) {
			System.out.println("Read Image Error");
			// END HERE
		}
	}

//SPRITE LOADER
	private void SpriteLoader(String path, ArrayList<Image> Left, ArrayList<Image> Right, int width, int height) {
		BufferedImage fullImage = null;
		try {
			fullImage = ImageIO.read(new File(path));
			for (int i = 0; i < fullImage.getWidth(); i += width) {
				Image img = fullImage.getSubimage(i, height, width, height);
				Left.add(img);
				img = fullImage.getSubimage(i, 2 * height, width, height);
				Right.add(img);
			}
		} catch (IOException e) {
			System.out.println("Read Image Error");
			System.exit(0);
		}
	}

	public void SpriteLoader(String path, ArrayList<Image> Left, ArrayList<Image> Right, ArrayList<Image> Back,
			int width, int height) {
		SpriteLoader(path, Left, Right, width, height);
		BufferedImage fullImage = null;
		try {
			fullImage = ImageIO.read(new File(path));
			for (int i = 0; i < fullImage.getWidth(); i += width) {
				Image img = fullImage.getSubimage(i, 3 * height, width, height);
				Back.add(img);
			}
		} catch (IOException e) {
			System.out.println("Read Image Error back");
			System.exit(0);
		}

	}

	private ImageLoader() {
		SpriteLoader("Images/characters/sailorMoon.png", this.sailorMoonLeft, this.sailorMoonRight,
				this.sailorMoonBack, 32, 48);
		SpriteLoader("Images/characters/sailorMars.png", this.sailorMarsLeft, this.sailorMarsRight, this.sailorMarsBack, 32,
				48);
		SpriteLoader("Images/characters/sailorJupiter.png", this.sailorJupiterLeft, this.sailorJupiterRight,
				this.sailorJupiterBack, 32, 48);
		SpriteLoader("Images/characters/sailorVenus.png", this.sailorVenusLeft, this.sailorVenusRight,
				this.sailorVenusBack, 32, 48);
		SpriteLoader("Images/characters/sailorMercury.png", this.sailorMercuryLeft, this.sailorMercuryRight,
				this.sailorMercuryBack, 32, 48);
		
		
		SpriteLoader("Images/enemies/ghost.png", this.ghostLeft, this.ghostRight, 32, 48);
		SpriteLoader("Images/enemies/bat.png", this.batLeft, this.batRight, 32, 48);
		SpriteLoader("Images/enemies/skull.png", this.skullLeft, this.skullRight, 56, 56);
		SpriteLoader("Images/collectable/cat.png", this.catLeft, this.catRight, this.catBack, 32, 32);

		TileLoader("Images/tiles/level1.png", this.tilesLevel1, 48,48);
		TileLoader("Images/tiles/level2.png", this.tilesLevel2, 48,48);
		TileLoader("Images/tiles/level3.png", this.tilesLevel3, 48,48);
		
		
		this.openDoor = loadImage("Images/tiles.openDoor.png");
		this.closedDoor = loadImage("Images/tiles/closedDoor.png");
		this.ladder = loadImage("Images/tiles/ladder.png");
		this.invisibleLadder=loadImage("Images/tiles/invisibleLadder.png");
		
		this.attackBoost=loadImage("Images/collectable/attack.png");
		this.potion=loadImage("Images/collectable/potion.png");
		this.key=loadImage("Images/collectable/key.png");
		
		this.coin=loadImage("Images/collectable/coin.png");

		this.emptyImage = loadImage("Images/tiles/Empty.png").getScaledInstance(48, 48, 0);
		this.restrictionImage=loadImage("Images/tiles/restrictionTile.png");
	}

	public Image loadImage(String imageAddress) {
		ImageIcon icon = new ImageIcon(imageAddress);
		return icon.getImage();
	}

	public ArrayList<Image> getSailorMoonLeft() {
		return sailorMoonLeft;
	}

	public ArrayList<Image> getSailorMoonRight() {
		return sailorMoonRight;
	}

	public ArrayList<Image> getSailorMoonBack() {
		return sailorMoonBack;
	}

	public ArrayList<Image> getCatLeft() {
		return catLeft;
	}

	public ArrayList<Image> getCatRight() {
		return catRight;
	}

	public ArrayList<Image> getCatBack() {
		return catBack;
	}

	public ArrayList<Image> getSailorMarsLeft() {
		return sailorMarsLeft;
	}

	public ArrayList<Image> getSailorMarsRight() {
		return sailorMarsRight;
	}

	public ArrayList<Image> getSailorMarsBack() {
		return sailorMarsBack;
	}

	public ArrayList<Image> getSailorJupiterLeft() {
		return sailorJupiterLeft;
	}

	public ArrayList<Image> getSailorJupiterRight() {
		return sailorJupiterRight;
	}

	public ArrayList<Image> getSailorJupiterBack() {
		return sailorJupiterBack;
	}
	
	public ArrayList<Image> getSailorVenusLeft() {
		return sailorVenusLeft;
	}

	public ArrayList<Image> getSailorVenusRight() {
		return sailorVenusRight;
	}

	public ArrayList<Image> getSailorVenusBack() {
		return sailorVenusBack;
	}
	
	public ArrayList<Image> getSailorMercuryLeft() {
		return sailorMercuryLeft;
	}

	public ArrayList<Image> getSailorMercuryRight() {
		return sailorMercuryRight;
	}

	public ArrayList<Image> getSailorMercuryBack() {
		return sailorMercuryBack;
	}
	////////////////////////////////////////////////////////////////
	
	public ArrayList<Image> getGhostLeft() {
		return ghostLeft;
	}

	public ArrayList<Image> getGhostRight() {
		return ghostRight;
	}

	public ArrayList<Image> getBatLeft() {
		return batLeft;
	}

	public ArrayList<Image> getBatRight() {
		return batRight;
	}

	public ArrayList<Image> getSkullLeft() {
		return skullLeft;
	}

	public ArrayList<Image> getSkullRight() {
		return skullRight;
	}
	
	public ArrayList<Image> getLevel1(){
		return tilesLevel1;
	}
	
	public ArrayList<Image> getLevel2(){
		return tilesLevel2;
	}
	
	public ArrayList<Image> getLevel3(){
		return tilesLevel3;
	}

	public Image getOpenDoor() {
		return openDoor;
	}

	
	public Image getClosedDoor() {
		return closedDoor;
	}

	public Image getLadder() {
		return ladder;
	}
	
	public Image getInvisibleLadder() {
		return invisibleLadder;
	}

	public Image getPotion() {
		return potion;
	}
	
	public Image getAttackBoost() {
		return attackBoost;
	}
	
	public Image getKey() {
		return key;
	}
	
	public Image getCoin() {
		return coin;
	}
	
	public Image getRestriction() {
		return restrictionImage;
	}
	
	public Image getEmpty() {
		return emptyImage;
	}

}
