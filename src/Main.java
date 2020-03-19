import paooGame.Database;
import paooGame.GameView;
import paooGame.Board;
import GameEnums.Level;

import GameEnums.*;
import paooGame.*;

public class Main {
	public static boolean isRunning = true;

	public static void main(String[] args) {
		GameView theView = new GameView();
		if(!isRunning) {
			OpenView menu = new OpenView();
			menu.repaint();
			theView.getPanel().add(menu);
			menu.requestFocusInWindow();
			theView.setVisible(true);
		}

		if (isRunning == true) {
			Board panel = new Board(OpenView.level);
			panel.revalidate();
			panel.repaint();

			theView.getPanel().add(panel);
			panel.requestFocusInWindow();
			theView.setVisible(true);
		}
	}
}