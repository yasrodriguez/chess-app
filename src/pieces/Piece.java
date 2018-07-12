package pieces;

public class Piece {
    private Color color;
    private char representation;
    private Type type;
    private static int whiteCount;
    private static int blackCount;
    private static final char PAWN_REPRESENTATION = 'p';
    private static final char ROOK_REPRESENTATION = 'r';
    private static final char KNIGHT_REPRESENTATION = 'n';
    private static final char BISHOP_REPRESENTATION = 'b';
    private static final char QUEEN_REPRESENTATION = 'q';
    private static final char KING_REPRESENTATION = 'k';

    public enum Color {BLACK, WHITE}

    public enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING}

    private Piece(Color color, Type type, char representation){
        this.color = color;
        this.type = type;
        this.representation = representation;
        updateCount();
    }

    private void updateCount() {
        if(isWhite()) {
            whiteCount++;
        } else {
            blackCount++;
        }
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation(){
        return representation;
    }

    public static int getWhiteCount(){
        return whiteCount;
    }

    public static int getBlackCount(){
        return blackCount;
    }

    private static char calculateRepresentation(Color color, Piece.Type type) {
        char representation = ' ';
        switch (type) {
            case PAWN:
                representation = PAWN_REPRESENTATION;
                break;
            case ROOK:
                representation = ROOK_REPRESENTATION;
                break;
            case KNIGHT:
                representation = KNIGHT_REPRESENTATION;
                break;
            case BISHOP:
                representation = BISHOP_REPRESENTATION;
                break;
            case QUEEN:
                representation = QUEEN_REPRESENTATION;
                break;
            case KING:
                representation = KING_REPRESENTATION;
                break;
        }
        if(color == Color.BLACK) {
            return Character.toUpperCase(representation);
        }
        return representation;
    }


    public static Piece create(Color color, Piece.Type type) {
        return new Piece(color, type, Piece.calculateRepresentation(color, type));
    }

    public boolean isWhite() {
        return color == Piece.Color.WHITE;
    }

    public boolean isBlack() {
        return color == Piece.Color.BLACK;
    }
}
