package GameItems;

import java.awt.Image;

public class Potion extends Collectable {
	boolean isPicked;

	public Potion(int x, int y, Image image) {
		super(x, y, image);
		isPicked=false;
	}
	
	public void pickPotion() {
		isPicked=true;
		setVisible(false);
	}

}
