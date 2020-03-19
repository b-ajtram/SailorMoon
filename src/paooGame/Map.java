package paooGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Map {
	public static final int BOARD_WIDTH = 48 * 25;
	public static final int BOARD_HEIGHT = 48 * 13;
	static int[][] foreground;
	static int[][] background; 
	static int[][] collectable;
	
	Map(String pathForeground, String pathBackground, String pathCollectable) {
		foreground=readMap(pathForeground);
		background=readMap(pathBackground);
		collectable=readMap(pathCollectable);
	}
	

	private int[][] readMap(String path){
		int [][] _map= new int[13][25];
		Scanner scanner = null;
		try {
			int columns = BOARD_WIDTH / 48;
			int rows = BOARD_HEIGHT / 48;
			scanner = new Scanner(new BufferedReader(new FileReader(path)));
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if (scanner.hasNextInt()) {
						_map[i][j] = scanner.nextInt();
					}
				}
			}
			scanner.close();
			return _map;
		} catch (Exception e) {
			System.out.println("Reading Map Error");
			System.exit(0);
			return null;
		} finally {
			if (scanner != null)
				scanner.close();
		}
		
	 }

	 public void updateMap(String pathForeground, String pathBackground, String pathCollectable) {
		 foreground = readMap(pathForeground);
		 background = readMap(pathBackground);
		 collectable = readMap(pathCollectable);
	 }
}
