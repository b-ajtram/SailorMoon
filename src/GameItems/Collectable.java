package GameItems;

import java.awt.Image;

public class Collectable extends Tile {
	boolean isCollected;

	public Collectable(int x, int y, Image image) {
		super(x, y, image);
		isCollected=false;
	}

	
	public void pickItem() {
		isCollected=true;
		setVisible(false);
	}
}
