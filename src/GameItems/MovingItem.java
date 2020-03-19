package GameItems;

import GameEnums.*;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import paooGame.Map;

public abstract class MovingItem extends Item {

	Directions direction;
	private int velocity;
	private int indexImage;

	private ArrayList<Image> leftImage = new ArrayList<>();
	private ArrayList<Image> rightImage = new ArrayList<>();

	public MovingItem(int x, int y, ArrayList<Image> left, ArrayList<Image> right) {
		super(x, y, right.get(0));
		this.leftImage = left;
		this.rightImage = right;
		this.direction = Directions.RIGHT;
		this.indexImage = 0;
		
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	public int getVelocity() {
		return velocity;
	}

	public Directions getDirection() {
		return direction;
	}
	
	public void moveLeft() {
		if (direction != Directions.LEFT) {
			resetIndex();
		}
		if (this.x > 0) {
			this.x -= velocity;
			setNextIndex();
		}
		direction = Directions.LEFT;
		int index=getImageIndex();
		image = leftImage.get(index);
	}

	public void moveRight() {
		if (direction != Directions.RIGHT) {
			resetIndex();
		}
		if (this.x < Map.BOARD_WIDTH-this.getWidth()) {
			this.x += velocity;
			setNextIndex();
		}
		direction = Directions .RIGHT;
		int index=getImageIndex();
		image = rightImage.get(index);
	}
	
	
	public void resetIndex() {
		this.indexImage=0;
	}
	
	public int getImageIndex() {
		return indexImage;
	}
	
	public void setNextIndex() {
		if (indexImage < leftImage.size()-1)
			indexImage++;
		else
			indexImage = 0;
	}
}
