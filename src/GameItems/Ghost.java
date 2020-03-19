package GameItems;

import java.awt.Image;
import java.util.ArrayList;

public class Ghost extends Enemy {

	public Ghost(int x, int y, ArrayList<Image> left, ArrayList<Image> right) {
		super(x, y, left, right);
		setHealth(300);
		setDamage(500);
		setVelocity(2);
		// TODO Auto-generated constructor stub
	}

}
