package GameItems;

import javax.swing.*;
import java.awt.*;

public class Item {
    public int x;
    public int y;
    private int width;
    private int height;
    public boolean vis;
    public Image image;
    public Item(int x, int y, Image image) {
    	this.image=image;
        this.x = x;
        this.y = y;
        vis = true;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }

    public int getWidth() {
    	return this.width;
    }
    
    public int getHeight() {
    	return this.height;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
