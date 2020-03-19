package paooGame;

import GameEnums.BlockType;

import GameEnums.Level;
import GameItems.*;

public class TileFactory {
	ImageLoader imageLoader = ImageLoader.getInstance();

	public Tile CreateTile(Level level, BlockType type, int x, int y) {
		switch (level) {
		case LEVEL1:
			switch (type) {
			case TILE0:
			case TILE1:
			case TILE2:
			case TILE3:
			case TILE4:
			case TILE5:
			case TILE6:
			case TILE7:
			case TILE8:
				return new Tile(x, y, imageLoader.getLevel1().get(type.getValue()));
			case EMPTY:
				return new Tile(x, y, imageLoader.getEmpty());
			case LADDER:
				return new Tile(x, y, imageLoader.getLadder());
			case CLOSEDDOOR:
				return new Door(x, y, imageLoader.getClosedDoor(), imageLoader.getOpenDoor());
			case INVISIBLELADDER:
				return new Tile(x+16, y, imageLoader.getInvisibleLadder());
			case COIN:
				return new Coin(x, y, imageLoader.getCoin());
			case KEY:
				return new Key(x, y, imageLoader.getKey());
			case POTION:
				return new Potion(x, y, imageLoader.getPotion());
			case RESTRICTIONTILE:
				return new RestrictionTile(x, y, imageLoader.getRestriction());
			default:
				return new Tile(x, y, imageLoader.getEmpty());
			}
		case LEVEL2:
			switch (type) {
			case TILE0:
			case TILE1:
			case TILE2:
			case TILE3:
			case TILE4:
			case TILE5:
			case TILE6:
			case TILE7:
			case TILE8:
				return new Tile(x, y, imageLoader.getLevel2().get(type.getValue()));
			case EMPTY:
				return new Tile(x, y, imageLoader.getEmpty());
			case LADDER:
				return new Tile(x, y, imageLoader.getLadder());
			case CLOSEDDOOR:
				return new Door(x, y, imageLoader.getClosedDoor(), imageLoader.getOpenDoor());
			case INVISIBLELADDER:
				return new Tile(x+16, y-2, imageLoader.getInvisibleLadder());
			case COIN:
				return new Coin(x, y, imageLoader.getCoin());
			case KEY:
				return new Key(x, y, imageLoader.getKey());
			case POTION:
				return new Potion(x, y, imageLoader.getPotion());
			case RESTRICTIONTILE:
				return new RestrictionTile(x, y, imageLoader.getRestriction());
			default:
				return new Tile(x, y, imageLoader.getEmpty());
			}
		case LEVEL3:
			switch (type) {
			case TILE0:
			case TILE1:
			case TILE2:
			case TILE3:
			case TILE4:
			case TILE5:
			case TILE6:
			case TILE7:
			case TILE8:
				return new Tile(x, y, imageLoader.getLevel3().get(type.getValue()));
			case EMPTY:
				return new Tile(x, y, imageLoader.getEmpty());
			case LADDER:
				return new Tile(x, y, imageLoader.getLadder());
			case CLOSEDDOOR:
				return new Door(x, y, imageLoader.getClosedDoor(), imageLoader.getOpenDoor());
			case INVISIBLELADDER:
				return new Tile(x+16, y-2, imageLoader.getInvisibleLadder());
			case COIN:
				return new Coin(x, y, imageLoader.getCoin());
			case KEY:
				return new Key(x, y, imageLoader.getKey());
			case POTION:
				return new Potion(x, y, imageLoader.getPotion());
			case RESTRICTIONTILE:
				return new RestrictionTile(x, y, imageLoader.getRestriction());
			default:
				return new Tile(x, y, imageLoader.getEmpty());
			}
		default:
			return new Tile(x, y, imageLoader.getEmpty());
		}
	}
}