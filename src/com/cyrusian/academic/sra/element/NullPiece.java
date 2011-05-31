package com.cyrusian.academic.sra.element;


public class NullPiece implements ChessPiece, Valuable {
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		return new Coordinate[0];
	}
	
	@Override
	public Color getColor() {
		return ChessPiece.Color.NONE;
	}
	
	@Override
	public Color getOppositeColor() {
		return ChessPiece.Color.NONE;
	}
	
	@Override
	public ChessPiece.Identifier getPieceID() {
		return ChessPiece.Identifier.NONE;
	}
	
	@Override
	public short getValue() {
		return 0;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
}