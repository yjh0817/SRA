package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Bishop extends Piece {
	
	public Bishop(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone();
		do {
			tmpCrd.moveNorth().moveWest();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color) {
					moves.add(tmpCrd.clone());
					break;
				} else if(aBoard.getPieceAtCoord(tmpCrd).getColor() == color)
					break;
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveWest().moveSouth();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color) {
					moves.add(tmpCrd.clone());
					break;
				} else if(aBoard.getPieceAtCoord(tmpCrd).getColor() == color)
					break;
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveSouth().moveEast();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color) {
					moves.add(tmpCrd.clone());
					break;
				} else if(aBoard.getPieceAtCoord(tmpCrd).getColor() == color)
					break;
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveEast().moveNorth();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color) {
					moves.add(tmpCrd.clone());
					break;
				} else if(aBoard.getPieceAtCoord(tmpCrd).getColor() == color)
					break;
			} else
				break;
		} while(true);
		
		Coordinate[] crdSet = new Coordinate[moves.size()];
		moves.toArray(crdSet);
		tmpCrd = null;
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public ChessPiece.Identifier getPieceID() {
		return ChessPiece.Identifier.BISHOP;
	}
	
	@Override
	public int getValue() {
		return 3;
	}
	
	@Override
	public String toString() {
		return "Bishop";
	}
	
}