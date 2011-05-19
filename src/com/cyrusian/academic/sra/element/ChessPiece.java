package com.cyrusian.academic.sra.element;


public interface ChessPiece {
	
	// Constant for piece identification;
	public static final short BISHOP = 0x01;
	public static final short KING = 0x02;
	public static final short KNIGHT = 0x03;
	public static final short PAWN = 0x04;
	public static final short QUEEN = 0x05;
	public static final short ROOK = 0x06;
	
	public short getPieceID();
	public String getPieceName();

}