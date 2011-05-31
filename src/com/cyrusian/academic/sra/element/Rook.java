package com.cyrusian.academic.sra.element;


public class Rook implements ChessPiece, Valuable {
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		return null;
	}
	
	@Override
	public ChessPiece.PieceID getPieceID() {
		return ChessPiece.PieceID.ROOK;
	}
	
	@Override
	public short getValue() {
		return 5;
	}
	
	@Override
	public String toString() {
		return "Rook";
	}
	
}
