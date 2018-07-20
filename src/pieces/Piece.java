package pieces;

public class Piece {
    private Color color;
    private char representation;
    private Type type;
    private static int whiteCount;
    private static int blackCount;
    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';

    public enum Color {BLACK, WHITE}

    public enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE}

    private Piece(Color color, Type type, char representation){
        this.color = color;
        this.type = type;
        this.representation = representation;
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
        return new Piece(Type.NO_PIECE, '.');
    }
}
