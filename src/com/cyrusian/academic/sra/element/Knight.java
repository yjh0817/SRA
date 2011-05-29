package com.cyrusian.academic.sra.element;


public class Knight implements ChessPiece, Valuable {
	
	@Override
	public short getPieceID() {
		return ChessPiece.KNIGHT;
	}
	
	@Override
	public String getPieceName() {
		return "Knight";
	}
	
	@Override
	public short getValue() {
		return 3;
	}
	
}
