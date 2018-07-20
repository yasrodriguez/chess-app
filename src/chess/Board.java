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
           secondRank.add(Piece.createWhitePawn());
           numberOfPieces++;
           seventhRank.add(Piece.createBlackPawn());
           numberOfPieces++;
       }

        firstRank.add(Piece.createWhiteRook());
        firstRank.add(Piece.createWhiteKnight());
        firstRank.add(Piece.createWhiteBishop());
        firstRank.add(Piece.createWhiteQueen());
        firstRank.add(Piece.createWhiteKing());
        firstRank.add(Piece.createWhiteBishop());
        firstRank.add(Piece.createWhiteKnight());
        firstRank.add(Piece.createWhiteRook());
        numberOfPieces += 8;

        eightRank.add(Piece.createBlackRook());
        eightRank.add(Piece.createBlackKnight());
        eightRank.add(Piece.createBlackBishop());
        eightRank.add(Piece.createBlackQueen());
        eightRank.add(Piece.createBlackKing());
        eightRank.add(Piece.createBlackBishop());
        eightRank.add(Piece.createBlackKnight());
        eightRank.add(Piece.createBlackRook());
        numberOfPieces += 8;
    }

    public String getFirstRank(){
        return getRankRepresentation(firstRank);
    }

      public String getSecondRank(){
        return getRankRepresentation(secondRank);
    }

    public String getSeventhRank(){
       return getRankRepresentation(seventhRank);
    }

    public String getEightRank(){
        return getRankRepresentation(eightRank);
    }

    private String getRankRepresentation(ArrayList<Piece> rank) {
        StringBuilder sb = new StringBuilder();
        for(Piece p : rank) {
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

    public int getNumberOfPieces(Piece.Color color, char representation) {
        return countPieces(firstRank, color, representation) + countPieces(secondRank, color, representation) +
                countPieces(seventhRank, color, representation) + countPieces(eightRank, color, representation);
    }

    private int countPieces(ArrayList<Piece> rank, Piece.Color color, char representation) {
        int count = 0;
        for(Piece piece : rank){
            if(piece.getColor() == color && piece.getRepresentation() == representation) {
                count++;
            }
        }
        return count;
    }
}
