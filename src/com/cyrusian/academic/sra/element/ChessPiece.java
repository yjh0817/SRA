package com.cyrusian.academic.sra.element;


public interface ChessPiece {
	
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where); // Note: this method does not deal with Check. At least now.
	public PieceColor getPieceColor();
	public PieceID getPieceID();
	
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
		
	}
	
	public enum PieceColor {
		WHITE, BLACK;
	}
	
	public enum PieceID {
		NONE, PAWN, BISHOP, KNIGHT, ROOK, QUEEN, KING;
	}
	
}