package com.cyrusian.academic.sra.element;


public abstract class Piece implements ChessPiece {
	
	protected ChessPiece.Color color;
	
	@Override
	public Color getColor() {
		return color;
	}
	
	@Override
	public Color getOppositeColor() {
		if(color == ChessPiece.Color.BLACK)
			return ChessPiece.Color.WHITE;
		else if(color == ChessPiece.Color.WHITE)
			return ChessPiece.Color.BLACK;
		
		return ChessPiece.Color.NONE;
	}
	
}