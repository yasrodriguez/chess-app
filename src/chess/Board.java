package chess;

import pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private int numberOfPieces;
    private ArrayList<Pawn> pieces;

    public Board(){
        numberOfPieces = 0;
        pieces = new ArrayList<>();
    }

    public int getNumberOfPieces(){
        return numberOfPieces;
    }

    public void add(Pawn pawn){
        pieces.add(pawn);
        numberOfPieces++;
    }

    public Pawn getPieces(int index) {
        return pieces.get(index);
    }
}
