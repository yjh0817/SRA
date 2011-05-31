package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Rook extends Piece {
	
	public Rook(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone();
		do {
			tmpCrd.moveNorth();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getColor() != color) {
					moves.add(tmpCrd.clone());
					break;
				}
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveWest();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getColor() != color) {
					moves.add(tmpCrd.clone());
					break;
				}
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveSouth();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getColor() != color) {
					moves.add(tmpCrd.clone());
					break;
				}
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveEast();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getColor() != color) {
					moves.add(tmpCrd.clone());
					break;
				}
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
		return ChessPiece.Identifier.ROOK;
	}
	
	@Override
	public short getValue() {
		return 5;
	}
	
	@Override
	public String toString() {
		return "Rook";
	}
	
}