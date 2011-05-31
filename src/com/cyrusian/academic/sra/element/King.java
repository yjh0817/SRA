package com.cyrusian.academic.sra.element;


public class King implements ChessPiece, Valuable {
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		return null;
	}
	
	@Override
	public ChessPiece.PieceID getPieceID() {
		return ChessPiece.PieceID.KING;
	}
	
	@Override
	public short getValue() {
		return Short.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return "King";
	}
	
}
