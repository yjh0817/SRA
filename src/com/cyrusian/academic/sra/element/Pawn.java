package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Pawn extends Piece {
	
	public Pawn(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		Coordinate tmpCrd = where.clone();
		if(color == ChessPiece.Color.WHITE) {
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE ? tmpCrd.clone() : null);
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveEast().moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
			moves.add(where.getCoordinate() >= 48 && where.getCoordinate() <= 55 && aBoard.getPieceAtCoord(tmpCrd.moveNorth().moveWest()).getPieceID() == ChessPiece.Identifier.NONE ? tmpCrd.clone() : null);
		} else {
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.Identifier.NONE ? tmpCrd.clone() : null);
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveEast().moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
			moves.add(where.getCoordinate() >= 8 && where.getCoordinate() <= 15 && aBoard.getPieceAtCoord(tmpCrd.moveSouth().moveWest()).getPieceID() == ChessPiece.Identifier.NONE ? tmpCrd.clone() : null);
		}
		moves.remove(null);
		
		Coordinate[] crdSet = new Coordinate[moves.size()];
		moves.toArray(crdSet);
		tmpCrd = null;
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public ChessPiece.Identifier getPieceID() {
		return ChessPiece.Identifier.PAWN;
	}
	
	@Override
	public int getValue() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Pawn";
	}
	
}