package paooGame;

import GameItems.Player;

public class GetPlayer {
    ImageLoader imageLoader = ImageLoader.getInstance();
    public Player returnPlayer(String str, int x, int y){
        if(str.equals("Sailor Moon")){
            return new Player(x, y, imageLoader.getSailorMoonLeft(), imageLoader.getSailorMoonRight(), imageLoader.getSailorMoonBack(), str);
        }
        if(str.equals("Sailor Venus")){
            return new Player(x, y, imageLoader.getSailorVenusLeft(), imageLoader.getSailorVenusRight(), imageLoader.getSailorVenusBack(), str );
        }
        if(str.equals("Sailor Mars")){
            return new Player(x, y, imageLoader.getSailorMarsLeft(), imageLoader.getSailorMarsRight(), imageLoader.getSailorMarsBack(), str );
        }
        if(str.equals("Sailor Jupiter")){
            return new Player(x, y, imageLoader.getSailorJupiterLeft(), imageLoader.getSailorJupiterRight(), imageLoader.getSailorJupiterBack(), str );
        }
        if(str.equals("Sailor Mercury")){
            return new Player(x, y, imageLoader.getSailorMercuryLeft(), imageLoader.getSailorMercuryRight(), imageLoader.getSailorMercuryBack(), str );
        }
        return null;
    }
}
