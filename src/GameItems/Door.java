package GameItems;

import java.awt.Image;

public class Door extends Tile {
	Image imageOpenedDoor;
	boolean isOpen;

	public Door(int x, int y, Image imageClosed, Image imageOpened) {
		super(x, y, imageClosed);
		imageOpenedDoor=imageOpened;
	}
	
	public void openDoor() {
		this.image=imageOpenedDoor;
		isOpen=true;
	}
	
	boolean isOpen() {
		return isOpen;
	}
}
