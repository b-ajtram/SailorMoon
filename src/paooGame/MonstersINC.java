package paooGame;

import java.util.ArrayList;

import GameEnums.Level;
import GameItems.*;

public class MonstersINC {
	public static ArrayList<Enemy> enemies= new ArrayList<>();
	ImageLoader imageLoader = ImageLoader.getInstance();

	public ArrayList<Enemy> createEnemies(Level level) {
		killAndDismember();
		switch(level) {
		case LEVEL1:
			Enemy bat=new Bat(480, 45, imageLoader.getBatLeft(), imageLoader.getBatRight());
			Enemy bat1=new Bat(120, 150, imageLoader.getBatLeft(), imageLoader.getBatRight());
			Enemy bat2=new Bat(230, 300, imageLoader.getBatLeft(), imageLoader.getBatRight());
			enemies.add(bat);
			enemies.add(bat1);
			enemies.add(bat2);
			break;
		case LEVEL2:
			Enemy skull=new Skull(480, 45, imageLoader.getSkullLeft(), imageLoader.getSkullRight());
			Enemy skull1=new Skull(120, 150, imageLoader.getSkullLeft(), imageLoader.getSkullRight());
			Enemy skull2=new Skull(500, 250, imageLoader.getSkullLeft(), imageLoader.getSkullRight());
			Enemy skull3=new Skull(1000, 394, imageLoader.getSkullLeft(), imageLoader.getSkullRight());
			enemies.add(skull);
			enemies.add(skull1);
			enemies.add(skull2);
			enemies.add(skull3);
			break;
		case LEVEL3:
			Enemy ghost1=new Ghost(10, 192, imageLoader.getGhostLeft(), imageLoader.getGhostRight());
			Enemy ghost=new Ghost(300, 240, imageLoader.getGhostLeft(), imageLoader.getGhostRight());
			Enemy ghost2=new Ghost(100, 480, imageLoader.getGhostLeft(), imageLoader.getGhostRight());
			Enemy ghost3=new Ghost(500, 48, imageLoader.getGhostLeft(), imageLoader.getGhostRight());
			Enemy ghost4=new Ghost(800, 394, imageLoader.getGhostLeft(), imageLoader.getGhostRight());
			enemies.add(ghost);
			enemies.add(ghost1);
			enemies.add(ghost2);
			enemies.add(ghost3);
			enemies.add(ghost4);
			break;
		}
		return enemies;
	}
	
	public void killAndDismember() {
		for(Enemy en: enemies) {
			en=null;
		}
	}

}
