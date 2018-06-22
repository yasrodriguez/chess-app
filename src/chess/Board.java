package chess;

import pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private int numberOfPieces;
    private ArrayList<Pawn> secondRank;
    private ArrayList<Pawn> seventhRank;

    public Board(){
        numberOfPieces = 0;
        secondRank = new ArrayList<>();
        seventhRank = new ArrayList<>();
        initialize();
    }

    public int getNumberOfPieces(){
        return numberOfPieces;
    }

    public void initialize(){
       for(int i = 0; i < 8; i++) {
           secondRank.add(new Pawn("white", 'p'));
           numberOfPieces++;
           seventhRank.add(new Pawn("black", 'P'));
           numberOfPieces++;
       }
    }

    public String getSecondRank(){
        StringBuilder sb = new StringBuilder();
        for(Pawn p : secondRank) {
            sb.append(p.getIdentifier());
        }
        return sb.toString();
    }

    public String getSeventhRank(){
        StringBuilder sb = new StringBuilder();
        for(Pawn p : seventhRank) {
            sb.append(p.getIdentifier());
        }
        return sb.toString();
    }
}
