package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class King extends Piece {
	
	public King(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone().moveNorth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveEast();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveSouth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveSouth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveWest();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveWest();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveNorth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveNorth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		moves.remove(null);
		
		Coordinate[] crdSet = new Coordinate[moves.size()];
		moves.toArray(crdSet);
		tmpCrd = null;
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public ChessPiece.Identifier getPieceID() {
		return ChessPiece.Identifier.KING;
	}
	
	@Override
	public int getValue() {
		return Integer.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return "King";
	}
	
}