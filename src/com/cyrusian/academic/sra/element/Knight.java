package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Knight extends Piece {
	
	public Knight(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth().moveNorth().moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveEast().moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth().moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth().moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest().moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest().moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth().moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth().moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getColor() != color ? tmpCrd.clone() : null);
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
	public short getValue() {
		return 3;
	}
	
	@Override
	public String toString() {
		return "Knight";
	}
	
}