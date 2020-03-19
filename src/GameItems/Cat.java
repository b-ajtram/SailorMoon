package GameItems;

import GameEnums.Directions;

import java.awt.Image;
import java.util.ArrayList;

public class Cat extends MovingItem {
	private ArrayList<Image> backImage = new ArrayList<>();
	boolean isPicked;

	public Cat(int x, int y, ArrayList<Image> left, ArrayList<Image> right, ArrayList<Image> back) {
		super(x, y, left, right);
		isPicked=false;
		this.backImage=back;
	}

	public boolean isPicked(){
		return isPicked;
	}

	public void pickCat() {
		isPicked=true;
		setVelocity(6);
	}

	public void moveUp() {
		image = backImage.get(0);
		if (direction != Directions.UP) {
			resetIndex();
		}
		this.y -= getVelocity();
		setNextIndex();
		direction = Directions.UP;
		int index = getImageIndex();
		image = backImage.get(index);
	}

	public void moveDown() {
		image = backImage.get(0);
		if (direction != Directions.DOWN) {
			resetIndex();
		}
		this.y += getVelocity();
		setNextIndex();
		direction = Directions.DOWN;
		int index = getImageIndex();
		image = backImage.get(index);
	}

	public void replaceCat(int x, int y){
		isPicked=false;
		this.x=x;
		this.y=y;
	}
}
