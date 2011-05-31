package com.cyrusian.academic.sra.element;


public class ChessBoard {
	
	private ChessPiece.PieceID[] theGrid;
	
	public ChessBoard(ChessPiece.PieceID[] aGrid) {
		theGrid = aGrid.clone();
	}
	
	public ChessPiece.PieceID getPieceAtCoord(int coord) {
		if(coord>=0 && coord<=63)
			return theGrid[coord];
		
		return null;
	}
	
	public ChessPiece.PieceID getPieceAtCoord(int row, int column) {
		return getPieceAtCoord(((row-1)*8)+(column-1));
	}
	
}