package GameItems;

import java.awt.Image;
import java.util.ArrayList;

import paooGame.Map;

public class Enemy extends MovingItem {
	private int damageInflicted;
	private int health;
	private boolean isAlive;

	public Enemy(int x, int y, ArrayList<Image> left, ArrayList<Image> right) {
		super(x, y, left, right);
		isAlive = true;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void killAndDismember() {
		if (health == 0) {
			isAlive = false;
			setVisible(false);
			damageInflicted = 0;
		}
	}

	public void setDamage(int damage) {
		this.damageInflicted = damage;
	}

	public int getDamageInflicted() {
		return damageInflicted;
	}

	public void move() {
		if (isAlive) {
			if (getX() < Map.BOARD_WIDTH-this.getWidth()-10)
				moveRight();
			else
				this.x=0;
		}

	}
}