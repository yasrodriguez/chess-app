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
    private boolean flipped;

    public Board(){
        numberOfPieces = 0;
        flipped = false;
        firstRank = new ArrayList<>();
        secondRank = new ArrayList<>();
        seventhRank = new ArrayList<>();
        eightRank = new ArrayList<>();
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

    public Piece getPiece(String pieceLocation){
        final int ASCII_OFFSET = Character.getNumericValue('a');
        int columnAscii = Character.getNumericValue(pieceLocation.charAt(0));
        int index = columnAscii - ASCII_OFFSET;

        int rankNumber = Integer.valueOf(pieceLocation.substring(1));
        ArrayList<Piece> rank = getRank(rankNumber);

        return rank.get(index);
    }

    private ArrayList<Piece> getRank(int rankNumber){
        int actualRankNumber = rankNumber;
        if(isFlipped()) {
            actualRankNumber = Math.abs(actualRankNumber - 8) + 1;
        }

        ArrayList<Piece> rank = new ArrayList<>();
        switch(actualRankNumber) {
            case 1:
                rank = firstRank;
                break;
            case 2:
                rank = secondRank;
                break;
            case 7:
                rank = seventhRank;
                break;
            case 8:
                rank = eightRank;
                break;
        }
        return rank;
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

    public void flip(){
        flipped = true;
    }

    private boolean isFlipped(){
        return flipped;
    }
}
