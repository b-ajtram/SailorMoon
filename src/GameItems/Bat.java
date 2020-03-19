package GameItems;

import java.awt.Image;
import java.util.ArrayList;

public class Bat extends Enemy {
	
	public Bat(int x, int y, ArrayList<Image> left, ArrayList<Image> right) {
		super(x, y, left, right);
		setHealth(100);
		setDamage(50);
		setVelocity(1);
		// TODO Auto-generated constructor stub
	}

}
