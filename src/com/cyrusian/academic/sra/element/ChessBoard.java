package com.cyrusian.academic.sra.element;


public class ChessBoard implements Cloneable {
	
	private ChessPiece[] theGrid;
	
	public ChessBoard(ChessPiece[] aGrid) {
		theGrid = aGrid.clone();
	}
	
	@Override
	public ChessBoard clone() {
		return new ChessBoard(theGrid.clone());
	}
	
	public ChessPiece getPieceAtCoord(int coord) {
		if(ChessPiece.Handyman.isInBound(coord)==true)
			return theGrid[coord];
		
		return null;
	}
	
	public ChessPiece getPieceAtCoord(Coordinate coord) {
		return getPieceAtCoord(coord.getCoordinate());
	}
	
	public void setPieceAtCoord(int where, ChessPiece newPiece) {
		if(ChessPiece.Handyman.isInBound(where)==true)
			theGrid[where]=newPiece;
	}
	
}