package pieces;

public class Pawn {
    private String color;
    public static String WHITE = "white";
    public static String BLACK = "black";

    public Pawn(){
        this.color = WHITE;
    }

    public Pawn(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
