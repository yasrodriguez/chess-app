package chess;

import pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;

public class Board {
    private int numberOfPieces;
    private ArrayList<Piece> firstRank;
    private ArrayList<Piece> secondRank;
    private ArrayList<Piece> thirdRank;
    private ArrayList<Piece> fourthRank;
    private ArrayList<Piece> fifthRank;
    private ArrayList<Piece> sixthRank;
    private ArrayList<Piece> seventhRank;
    private ArrayList<Piece> eightRank;
    private boolean flipped;

    public Board(){
        numberOfPieces = 0;
        flipped = false;
        firstRank = new ArrayList<>();
        secondRank = new ArrayList<>();
        thirdRank = new ArrayList<>();
        fourthRank = new ArrayList<>();
        fifthRank = new ArrayList<>();
        sixthRank = new ArrayList<>();
        seventhRank = new ArrayList<>();
        eightRank = new ArrayList<>();
        createEmptyBoard();
    }

    public int pieceCount(){
        return numberOfPieces;
    }

    public void createEmptyBoard(){
        for(int i = 0; i < 8; i++) {
            firstRank.add(Piece.noPiece());
            secondRank.add(Piece.noPiece());
            thirdRank.add(Piece.noPiece());
            fourthRank.add(Piece.noPiece());
            fifthRank.add(Piece.noPiece());
            sixthRank.add(Piece.noPiece());
            seventhRank.add(Piece.noPiece());
            eightRank.add(Piece.noPiece());
        }
    }

    public void initialize(){
       for(int i = 0; i < 8; i++) {
           secondRank.set(i, Piece.createWhitePawn());
           numberOfPieces++;
           seventhRank.set(i, Piece.createBlackPawn());
           numberOfPieces++;
       }

        firstRank.set(0, Piece.createWhiteRook());
        firstRank.set(1, Piece.createWhiteKnight());
        firstRank.set(2, Piece.createWhiteBishop());
        firstRank.set(3, Piece.createWhiteQueen());
        firstRank.set(4, Piece.createWhiteKing());
        firstRank.set(5, Piece.createWhiteBishop());
        firstRank.set(6, Piece.createWhiteKnight());
        firstRank.set(7, Piece.createWhiteRook());
        numberOfPieces += 8;

        eightRank.set(0, Piece.createBlackRook());
        eightRank.set(1, Piece.createBlackKnight());
        eightRank.set(2, Piece.createBlackBishop());
        eightRank.set(3, Piece.createBlackQueen());
        eightRank.set(4, Piece.createBlackKing());
        eightRank.set(5, Piece.createBlackBishop());
        eightRank.set(6, Piece.createBlackKnight());
        eightRank.set(7, Piece.createBlackRook());
        numberOfPieces += 8;
    }

    public String getFirstRank(){
        return getRankRepresentation(firstRank);
    }

      public String getSecondRank(){
        return getRankRepresentation(secondRank);
    }

    public String getThirdRank(){
        return getRankRepresentation(thirdRank);
    }

    public String getFourthRank(){
        return getRankRepresentation(fourthRank);
    }

    public String getFifthRank(){
        return getRankRepresentation(fifthRank);
    }

    public String getSixthRank(){
        return getRankRepresentation(sixthRank);
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
        sb.append(StringUtil.appendNewLine(getSixthRank()));
        sb.append(StringUtil.appendNewLine(getFifthRank()));
        sb.append(StringUtil.appendNewLine(getFourthRank()));
        sb.append(StringUtil.appendNewLine(getThirdRank()));
        sb.append(StringUtil.appendNewLine(getSecondRank()));
        sb.append(StringUtil.appendNewLine(getFirstRank()));
        return sb.toString();
    }

    public int getNumberOfPiecesForType(Piece.Color color, char representation) {
        return countPieces(firstRank, color, representation) + countPieces(secondRank, color, representation) +
                countPieces(seventhRank, color, representation) + countPieces(eightRank, color, representation);
    }

    public Piece getPieceAtLocation(String pieceLocation){
        int rankNumber = getRankNumber(pieceLocation);
        ArrayList<Piece> rank = getRank(rankNumber);

        int fileNumber = getFileNumber(pieceLocation);
        return rank.get(fileNumber);
    }

    private int getRankNumber(String location) {
        return Integer.valueOf(location.substring(1));
    }

    private int getFileNumber(String location) {
        final int ASCII_OFFSET = Character.getNumericValue('a');
        int columnAscii = Character.getNumericValue(location.charAt(0));
        return columnAscii - ASCII_OFFSET;
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
            case 3:
                rank = thirdRank;
                break;
            case 4:
                rank = fourthRank;
                break;
            case 5:
                rank = fifthRank;
                break;
            case 6:
                rank = sixthRank;
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

    public void placePiece(Piece.Color color, Piece.Type type, String location) {
        int rankNumber = getRankNumber(location);
        ArrayList<Piece> rank = getRank(rankNumber);

        int fileNumber = getFileNumber(location);

        rank.set(fileNumber, Piece.create(color, type, Piece.getRepresentationForTypeAndColor(color, type)));
        numberOfPieces++;
    }

    public double calculateStrength(Piece.Color color) {
        double points = 0;
        points += calculateStrength(firstRank, color);
        points += calculateStrength(secondRank, color);
        points += calculateStrength(thirdRank, color);
        points += calculateStrength(fourthRank, color);
        points += calculateStrength(fifthRank, color);
        points += calculateStrength(sixthRank, color);
        points += calculateStrength(seventhRank, color);
        points += calculateStrength(eightRank, color);

        points += calculatePawnStrength("a", color);
        points += calculatePawnStrength("b", color);
        points += calculatePawnStrength("c", color);
        points += calculatePawnStrength("d", color);
        points += calculatePawnStrength("e", color);
        points += calculatePawnStrength("f", color);
        points += calculatePawnStrength("g", color);
        points += calculatePawnStrength("h", color);

        return points;
    }

    private double calculatePawnStrength(String file, Piece.Color color) {
        double pawnCount = 0;
        int fileNumber = getFileNumber(file);


        pawnCount += firstRank.get(fileNumber).getType() == Piece.Type.PAWN && firstRank.get(fileNumber).getColor() == color ? 1 : 0;
        pawnCount += secondRank.get(fileNumber).getType() == Piece.Type.PAWN && secondRank.get(fileNumber).getColor() == color ? 1 : 0;
        pawnCount += thirdRank.get(fileNumber).getType() == Piece.Type.PAWN && thirdRank.get(fileNumber).getColor() == color ? 1 : 0;
        pawnCount += fourthRank.get(fileNumber).getType() == Piece.Type.PAWN && fourthRank.get(fileNumber).getColor() == color ? 1 : 0;
        pawnCount += fifthRank.get(fileNumber).getType() == Piece.Type.PAWN && fifthRank.get(fileNumber).getColor() == color ? 1 : 0;
        pawnCount += sixthRank.get(fileNumber).getType() == Piece.Type.PAWN && sixthRank.get(fileNumber).getColor() == color ? 1 : 0;
        pawnCount += seventhRank.get(fileNumber).getType() == Piece.Type.PAWN && seventhRank.get(fileNumber).getColor() == color ? 1 : 0;
        pawnCount += eightRank.get(fileNumber).getType() == Piece.Type.PAWN && eightRank.get(fileNumber).getColor() == color ? 1 : 0;

        if(pawnCount == 1) {
            return 1;
        } else {
            return 0.5 * pawnCount;
        }
    }


    private double calculateStrength(ArrayList<Piece> rank, Piece.Color color) {
        double totalPoints = 0;
        for(Piece piece : rank) {
            double points = 0;
            if(piece.getColor() == color) {
                switch(piece.getType()) {
                    case QUEEN:
                        points = 9;
                        break;
                    case ROOK:
                        points = 5;
                        break;
                    case BISHOP:
                        points = 3;
                        break;
                    case KNIGHT:
                        points = 2.5;
                        break;
                }
                totalPoints += points;
                piece.setStrength(points);
            }
        }
        return totalPoints;
    }
}
