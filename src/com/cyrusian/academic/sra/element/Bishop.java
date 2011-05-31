package com.cyrusian.academic.sra.element;


public class Bishop implements ChessPiece, Valuable {
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		return null;
	}
	
	@Override
	public ChessPiece.PieceID getPieceID() {
		return ChessPiece.PieceID.BISHOP;
	}
	
	@Override
	public short getValue() {
		return 3;
	}
	
	@Override
	public String toString() {
		return "Bishop";
	}
	
}
