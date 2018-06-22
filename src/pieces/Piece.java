package pieces;

import util.StringUtil;

public class Piece {
    private String color;
    public static String WHITE = "white";
    public static String BLACK = "black";
    private char identifier;
    private String name;
    private static int whiteCount;
    private static int blackCount;

    private Piece(String color, String name, char identifier){
        this.color = color;
        this.name = name;
        this.identifier = identifier;
        updateCount();
    }

    private void updateCount() {
        if(isWhite()) {
            whiteCount++;
        } else {
            blackCount++;
        }
    }

    public String getColor() {
        return color;
    }

    public char getIdentifier(){
        return identifier;
    }

    public static int getWhiteCount(){
        return whiteCount;
    }

    public static int getBlackCount(){
        return blackCount;
    }

    private static char calculateIdentifier(String color, String name) {
        if (name.equals("knight")) {
            if (color.equals(Piece.WHITE)) {
                return 'n';
            } else {
                return 'N';
            }
        }

            if (color.equals(Piece.WHITE)) {
                return StringUtil.getFirstLetterInLowerCase(name);
            } else {
                return StringUtil.getFirstLetterInUpperCase(name);
            }
        }

    public static Piece create(String color, String name) {
        return new Piece(color, name, Piece.calculateIdentifier(color, name));
    }

    public boolean isWhite() {
        return color.equals(Piece.WHITE);
    }

    public boolean isBlack() {
        return color.equals(Piece.BLACK);
    }
}
