package com.cyrusian.academic.sra.element;


public class Queen implements ChessPiece, Valuable {
	
	private ChessPiece.PieceColor color;
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		return null;
	}
	
	@Override
	public PieceColor getPieceColor() {
		return color;
	}
	
	@Override
	public ChessPiece.PieceID getPieceID() {
		return ChessPiece.PieceID.QUEEN;
	}
	
	@Override
	public short getValue() {
		return 9;
	}
	
	@Override
	public String toString() {
		return "Queen";
	}
	
}
