package com.cyrusian.academic.sra.element;


public interface ChessPiece {
	
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where); // Note: this method does not deal with Check. At least now.
	public Color getColor();
	public Color getOppositeColor();
	public Identifier getPieceID();
	public int getValue();
	
	public class Handyman {
		
		private Handyman() {
			// Prevent from instantiation
		}
		
		public static boolean isInBound(int coord) {
			if(coord >= 0 && coord <= 63)
				return true;
			
			return false;
		}
		
		public static boolean isInBound(Coordinate coord) {
			return isInBound(coord.getCoordinate());
		}
		
		public static boolean isColorWhite(char p) {
			if(Character.isUpperCase(p)==true)
				return true;
			else
				return false;
		}
		
	}
	
	public enum Color {
		NONE, WHITE, BLACK;
		
		@Override
		public String toString() {
			switch(this) {
				case WHITE:
					return "White";
				case BLACK:
					return "Black";
				default:
					return "";
			}
		}
	}
	
	public enum Identifier {
		NONE, PAWN, BISHOP, KNIGHT, ROOK, QUEEN, KING;
	}
	
}