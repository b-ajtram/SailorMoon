package paooGame;

import javax.swing.*;

import GameEnums.Level;

import java.awt.*;

public class BackgroundLoader {
	    private final Image openBackground;
	    private final Image winBackground;
	    private final Image gameOverBackground;
	    private final Image lvl1Background;
	    private final Image lvl2Background;
	    private final Image lvl3Background;

    private static BackgroundLoader instance;

    public static BackgroundLoader getInstance(int width, int height){
        if( instance != null){
            return instance;
        }
        else{
            return new BackgroundLoader(width, height);
        }
    }

    private BackgroundLoader(int width, int height) {
        this.openBackground = loadImage("Images/backgrounds/openBack.jpg").getScaledInstance(width, height, 0);
        this.winBackground = loadImage("Images/backgrounds/winBack.png").getScaledInstance(width, height, 0);
        this.gameOverBackground = loadImage("Images/backgrounds/gameOver.png").getScaledInstance(width, height, 0);
        this.lvl1Background = loadImage("Images/backgrounds/level1.png").getScaledInstance(width, height, 0);
        this.lvl2Background = loadImage("Images/backgrounds/level2.jpg").getScaledInstance(width, height, 0);
        this.lvl3Background = loadImage("Images/backgrounds/level3.jpg").getScaledInstance(width, height, 0);
    }

    public Image loadImage(String imageAddress) {
        ImageIcon icon = new ImageIcon(imageAddress);
        return icon.getImage();
    }
    
    public Image getOpenBackground(){ return openBackground;}
    public Image getWinBackground(){ return winBackground;}
    public Image getGameOverBackground(){ return gameOverBackground;}
    
    public Image getLevelBackground(Level level) {
    	switch (level) {
		case LEVEL1:
			return lvl1Background;
		case LEVEL2:
			return lvl2Background;
		case LEVEL3:
			return lvl3Background;
		default:
			return null;
		}
    }

}
