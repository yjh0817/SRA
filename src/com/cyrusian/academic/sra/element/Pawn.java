package com.cyrusian.academic.sra.element;


public class Pawn implements ChessPiece, Valuable {
	
	@Override
	public short getPieceID() {
		return ChessPiece.PAWN;
	}
	
	@Override
	public String getPieceName() {
		return "Pawn";
	}
	
	@Override
	public short getValue() {
		return 1;
	}
	
}
