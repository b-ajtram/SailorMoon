package GameItems;

import java.awt.Image;
import java.util.ArrayList;

public class Skull extends Enemy {

	public Skull(int x, int y, ArrayList<Image> left, ArrayList<Image> right) {
		super(x, y, left, right);
		setHealth(200);
		setDamage(100);
		setVelocity(1);
		// TODO Auto-generated constructor stub
	}

}
