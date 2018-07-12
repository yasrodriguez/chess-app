package chess;

import pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;

public class Board {
    private int numberOfPieces;
    private ArrayList<Piece> firstRank;
    private ArrayList<Piece> secondRank;
    private ArrayList<Piece> seventhRank;
    private ArrayList<Piece> eightRank;

    public Board(){
        numberOfPieces = 0;
        firstRank = new ArrayList<>();
        secondRank = new ArrayList<>();
        seventhRank = new ArrayList<>();
        eightRank = new ArrayList<>();
        initialize();
    }

    public int pieceCount(){
        return numberOfPieces;
    }

    public void initialize(){
       for(int i = 0; i < 8; i++) {
           secondRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.PAWN));
           numberOfPieces++;
           seventhRank.add(Piece.create(Piece.Color.BLACK, Piece.Type.PAWN));
           numberOfPieces++;
       }

        firstRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.ROOK));
        firstRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.KNIGHT));
        firstRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.BISHOP));
        firstRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.QUEEN));
        firstRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.KING));
        firstRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.BISHOP));
        firstRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.KNIGHT));
        firstRank.add(Piece.create(Piece.Color.WHITE, Piece.Type.ROOK));
        numberOfPieces += 8;

        eightRank.add(Piece.create(Piece.Color.BLACK, Piece.Type.ROOK));
        eightRank.add(Piece.create(Piece.Color.BLACK,  Piece.Type.KNIGHT));
        eightRank.add(Piece.create(Piece.Color.BLACK, Piece.Type.BISHOP));
        eightRank.add(Piece.create(Piece.Color.BLACK, Piece.Type.QUEEN));
        eightRank.add(Piece.create(Piece.Color.BLACK, Piece.Type.KING));
        eightRank.add(Piece.create(Piece.Color.BLACK, Piece.Type.BISHOP));
        eightRank.add(Piece.create(Piece.Color.BLACK, Piece.Type.KNIGHT));
        eightRank.add(Piece.create(Piece.Color.BLACK, Piece.Type.ROOK));
        numberOfPieces += 8;
    }

    public String getFirstRank(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : firstRank) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    public String getSecondRank(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : secondRank) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    public String getSeventhRank(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : seventhRank) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    public String getEightRank(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : eightRank) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    public String getEmptyRank(){
        return StringUtil.appendNewLine("........");
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.appendNewLine(getEightRank()));
        sb.append(StringUtil.appendNewLine(getSeventhRank()));
        sb.append(getEmptyRank());
        sb.append(getEmptyRank());
        sb.append(getEmptyRank());
        sb.append(getEmptyRank());
        sb.append(StringUtil.appendNewLine(getSecondRank()));
        sb.append(StringUtil.appendNewLine(getFirstRank()));
        return sb.toString();
    }
}
