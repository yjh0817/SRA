package com.cyrusian.academic.sra.element;


public class Bishop implements ChessPiece, Valuable {
	
	@Override
	public short getPieceID() {
		return ChessPiece.BISHOP;
	}
	
	@Override
	public String getPieceName() {
		return "Bishop";
	}
	
	@Override
	public short getValue() {
		return 3;
	}
	
}
