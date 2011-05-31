package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Knight extends Piece {
	
	public Knight(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone().moveNorth().moveNorth().moveWest();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveEast().moveEast();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveEast().moveSouth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveSouth().moveSouth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveSouth().moveWest();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveWest().moveWest();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveWest().moveNorth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		tmpCrd.moveNorth().moveNorth();
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
		return ChessPiece.Identifier.KNIGHT;
	}
	
	@Override
	public int getValue() {
		return 3;
	}
	
	@Override
	public String toString() {
		return "Knight";
	}
	
}