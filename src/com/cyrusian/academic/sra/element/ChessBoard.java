package com.cyrusian.academic.sra.element;


public class ChessBoard {
	
	private ChessPiece[] theGrid;
	
	public ChessBoard(ChessPiece[] aGrid) {
		theGrid = aGrid.clone();
	}
	
	public ChessPiece getPieceAtCoord(int coord) {
		return getPieceAtCoord(new Coordinate(coord));
	}
	
	public ChessPiece getPieceAtCoord(Coordinate coord) {
		if(ChessPiece.Handyman.isInBound(coord)==true)
			return theGrid[coord.getCoordinate()];
		
		return null;
	}
	
}