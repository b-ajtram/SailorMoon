package GameItems;

import java.awt.Image;

public class Key extends Collectable {
	boolean isPicked;

	public Key(int x, int y, Image image) {
		super(x, y, image);
		isPicked=false;
		// TODO Auto-generated constructor stub
	}
	
	public void pickKey() {
		isPicked=true;
		setVisible(false);
	}

}
