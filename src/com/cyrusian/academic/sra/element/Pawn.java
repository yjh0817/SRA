package com.cyrusian.academic.sra.element;


public class Pawn implements ChessPiece, Valuable {
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		return null;
	}
	
	@Override
	public ChessPiece.PieceID getPieceID() {
		return ChessPiece.PieceID.PAWN;
	}
	
	@Override
	public short getValue() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Pawn";
	}
	
}
