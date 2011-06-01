package com.cyrusian.academic.sra.element;


public class NullPiece implements ChessPiece {
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) {
		return new Integer[0];
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
	public int getValue() {
		return 0;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
}