package GameEnums;

public enum Directions {
	RIGHT(0), LEFT(1), UP(2), DOWN(3);

   private final int value;

   private Directions(int value) {
       this.value = value;
   }

   public int getValue() {
       return value;
   }

   public static Directions getTypeFromInt(int value) {
       return Directions.values()[value];
   }
}
