package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class King extends Piece {
	
	public King(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getOppositeColor() == color ? tmpCrd.clone() : null);
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
	public short getValue() {
		return Short.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return "King";
	}
	
}