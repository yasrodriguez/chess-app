package pieces;

public class Pawn {
    private String color;
    public static String WHITE = "white";
    public static String BLACK = "black";
    private char identifier;

    public Pawn(){
        this.color = WHITE;
        this.identifier = 'p';
    }

    public Pawn(String color, Character identifier){
        this.color = color;
        this.identifier = identifier;
    }

    public String getColor() {
        return color;
    }

    public char getIdentifier(){
        return identifier;
    }

}
