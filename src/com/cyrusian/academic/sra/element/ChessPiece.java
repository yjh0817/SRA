package com.cyrusian.academic.sra.element;


public interface ChessPiece {
	
	// Constants for piece identification
	public static final short BISHOP = 0x01;
	public static final short KING = 0x02;
	public static final short KNIGHT = 0x03;
	public static final short PAWN = 0x04;
	public static final short QUEEN = 0x05;
	public static final short ROOK = 0x06;
	
	public short getPieceID();
	public String getPieceName();
/*
	public enum ChessPieces implements Valuable {
		Bishop(3), King(Short.MAX_VALUE), Knight(3), Pawn(1), Queen(9), Rook(5);
		
		private short value;
		
		ChessPieces(int value) {
			this.value = (short)value;
		}
		
		@Override
		public short getValue() {
			return this.value;
		}
	}*/
}
