package com.cyrusian.academic.sra.element;


public interface ChessPiece {
	
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where);
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
		
	}
	
	public enum PieceID {
		NONE, PAWN, BISHOP, KNIGHT, ROOK, QUEEN, KING;
	}
	
}