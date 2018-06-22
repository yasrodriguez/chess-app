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
           secondRank.add(Piece.create(Piece.WHITE, "pawn"));
           numberOfPieces++;
           seventhRank.add(Piece.create(Piece.BLACK, "pawn"));
           numberOfPieces++;
       }

        firstRank.add(Piece.create(Piece.WHITE, "rook"));
        firstRank.add(Piece.create(Piece.WHITE, "knight"));
        firstRank.add(Piece.create(Piece.WHITE, "bishop"));
        firstRank.add(Piece.create(Piece.WHITE, "queen"));
        firstRank.add(Piece.create(Piece.WHITE, "king"));
        firstRank.add(Piece.create(Piece.WHITE, "bishop"));
        firstRank.add(Piece.create(Piece.WHITE, "knight"));
        firstRank.add(Piece.create(Piece.WHITE, "rook"));
        numberOfPieces += 8;

        eightRank.add(Piece.create(Piece.BLACK, "rook"));
        eightRank.add(Piece.create(Piece.BLACK, "knight"));
        eightRank.add(Piece.create(Piece.BLACK, "bishop"));
        eightRank.add(Piece.create(Piece.BLACK, "queen"));
        eightRank.add(Piece.create(Piece.BLACK, "king"));
        eightRank.add(Piece.create(Piece.BLACK, "bishop"));
        eightRank.add(Piece.create(Piece.BLACK, "knight"));
        eightRank.add(Piece.create(Piece.BLACK, "rook"));
        numberOfPieces += 8;
    }

    public String getFirstRank(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : firstRank) {
            sb.append(p.getIdentifier());
        }
        return sb.toString();
    }

    public String getSecondRank(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : secondRank) {
            sb.append(p.getIdentifier());
        }
        return sb.toString();
    }

    public String getSeventhRank(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : seventhRank) {
            sb.append(p.getIdentifier());
        }
        return sb.toString();
    }

    public String getEightRank(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : eightRank) {
            sb.append(p.getIdentifier());
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
