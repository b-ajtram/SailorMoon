package GameEnums;

public enum Level {
	LEVEL1(0), LEVEL2(1), LEVEL3(2);

   private final int value;

   private Level(int value) {
       this.value = value;
   }

   public int getValue() {
       return value;
   }
  
   public static Level getTypeFromInt(int value) {
       return Level.values()[value];
   }
}
