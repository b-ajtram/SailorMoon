
package GameEnums;

public enum BlockType {
     TILE0(0), TILE1(1), TILE2(2), TILE3(3), TILE4(4), TILE5(5), TILE6(6), TILE7(7), TILE8(8), 
     EMPTY(9),LADDER(10), CLOSEDDOOR(11), INVISIBLELADDER(12), KEY(13), POTION(14), COIN(15),
     RESTRICTIONTILE(16); 

    private final int value;

    private BlockType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BlockType getTypeFromInt(int value) {
        return BlockType.values()[value];
    }
}
