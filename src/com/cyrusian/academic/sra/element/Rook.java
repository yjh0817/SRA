package com.cyrusian.academic.sra.element;


public class Rook implements ChessPiece, Valuable {
	
	@Override
	public short getPieceID() {
		return ChessPiece.ROOK;
	}
	
	@Override
	public String getPieceName() {
		return "Rook";
	}
	
	@Override
	public short getValue() {
		return 5;
	}
	
}
