package com.cyrusian.academic.sra.element;


public class Queen implements ChessPiece, Valuable {
	
	@Override
	public short getPieceID() {
		return ChessPiece.QUEEN;
	}
	
	@Override
	public String getPieceName() {
		return "Queen";
	}
	
	@Override
	public short getValue() {
		return 9;
	}
	
}
