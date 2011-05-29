package com.cyrusian.academic.sra.element;


public class King implements ChessPiece, Valuable {
	
	@Override
	public short getPieceID() {
		return ChessPiece.KING;
	}
	
	@Override
	public String getPieceName() {
		return "King";
	}
	
	@Override
	public short getValue() {
		return Short.MAX_VALUE; // Actually, game ends when you capture king! XD
	}
	
}
