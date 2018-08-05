package pieces;

public class Piece {
    private Color color;
    private char representation;
    private Type type;
    private double strength;
    private static int whiteCount;
    private static int blackCount;
    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';
    public static final char NO_PIECE_REPRESENTATION = '.';
    public static final double ROOK_STRENGTH = 5;
    public static final double QUEEN_STRENGTH = 9;
    public static final double KING_STRENGTH = 0;
    public static final double BISHOP_STRENGTH = 3;
    public static final double KNIGHT_STRENGTH = 2.5;
    public static final double LONE_PAWN_STRENGTH = 1;
    public static final double MULTIPLE_PAWN_STRENGTH = 0.5;

    public enum Color {BLACK, WHITE}

    public enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE}

    private Piece(Color color, Type type, char representation){
        this.color = color;
        this.type = type;
        this.representation = representation;
        this.strength = 0;
        updateCount();
    }

    private Piece(Type type, char representation){
        this.type = type;
        this.representation = representation;
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

    public static Piece create(Color color, Piece.Type type, char representation) {
        if(color == Color.BLACK) {
            return new Piece(color, type, Character.toUpperCase(representation));
        }
        return new Piece(color, type, representation);
    }

    public boolean isWhite() {
        return color == Piece.Color.WHITE;
    }

    public boolean isBlack() {
        return color == Piece.Color.BLACK;
    }

    public static Piece createWhitePawn(){
        return create(Color.WHITE, Type.PAWN, PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn(){
        return create(Color.BLACK, Type.PAWN, PAWN_REPRESENTATION);
    }

    public static Piece createWhiteRook(){
        return create(Color.WHITE, Type.ROOK, ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return create(Color.BLACK, Type.ROOK, ROOK_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return create(Color.WHITE, Type.QUEEN, QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen(){
        return create(Color.BLACK, Type.QUEEN, QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return create(Color.WHITE, Type.KNIGHT, KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return create(Color.BLACK, Type.KNIGHT, KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return create(Color.WHITE, Type.BISHOP, BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return create(Color.BLACK, Type.BISHOP, BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return create(Color.WHITE, Type.KING, KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return create(Color.BLACK, Type.KING, KING_REPRESENTATION);
    }

    public Type getType(){
        return type;
    }

    public static Piece noPiece(){
        return new Piece(Type.NO_PIECE, NO_PIECE_REPRESENTATION);
    }

    public static char getRepresentationForTypeAndColor(Color color, Type type){
        char representation = ' ';
        switch(type) {
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
            representation = Character.toUpperCase(representation);
         }
        return representation;
        }

    public double getStrength() {
       return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}

