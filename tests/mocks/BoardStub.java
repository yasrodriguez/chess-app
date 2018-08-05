package mocks;

import chess.Board;
import pieces.Piece;

public class BoardStub extends Board {

    public Board getSampleBoard(){
        this.placePiece(Piece.Color.BLACK, Piece.Type.KING, "b8");
        this.placePiece(Piece.Color.BLACK, Piece.Type.ROOK, "c8");
        this.placePiece(Piece.Color.BLACK, Piece.Type.PAWN, "a7");
        this.placePiece(Piece.Color.BLACK, Piece.Type.PAWN, "c7");
        this.placePiece(Piece.Color.BLACK, Piece.Type.BISHOP, "d7");
        this.placePiece(Piece.Color.BLACK, Piece.Type.PAWN, "b6");
        this.placePiece(Piece.Color.BLACK, Piece.Type.QUEEN, "e6");

        this.placePiece(Piece.Color.WHITE, Piece.Type.KNIGHT, "f4");
        this.placePiece(Piece.Color.WHITE, Piece.Type.QUEEN, "g4");
        this.placePiece(Piece.Color.WHITE, Piece.Type.PAWN, "f3");
        this.placePiece(Piece.Color.WHITE, Piece.Type.PAWN, "h3");
        this.placePiece(Piece.Color.WHITE, Piece.Type.PAWN, "f2");
        this.placePiece(Piece.Color.WHITE, Piece.Type.PAWN, "g2");
        this.placePiece(Piece.Color.WHITE, Piece.Type.ROOK, "e1");
        this.placePiece(Piece.Color.WHITE, Piece.Type.KING, "f1");




        return this;
    }
}
