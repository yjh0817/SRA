package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Pawn implements ChessPiece, Valuable {
	
	private ChessPiece.PieceColor color;
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		Coordinate tmpCrd = where.clone();
		if(color == ChessPiece.PieceColor.WHITE) {
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE ? tmpCrd.clone() : null);
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveEast().moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
			moves.add(where.getCoordinate() >= 56 && where.getCoordinate() <= 63 && aBoard.getPieceAtCoord(tmpCrd.moveNorth().moveWest()).getPieceID() == ChessPiece.PieceID.NONE ? tmpCrd.clone() : null);
		} else {
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE ? tmpCrd.clone() : null);
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
			moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveEast().moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
			moves.add(where.getCoordinate() >= 8 && where.getCoordinate() <= 15 && aBoard.getPieceAtCoord(tmpCrd.moveSouth().moveWest()).getPieceID() == ChessPiece.PieceID.NONE ? tmpCrd.clone() : null);
		}
		moves.remove(null);
		
		Coordinate[] crdSet = new Coordinate[moves.size()];
		moves.toArray(crdSet);
		tmpCrd = null;
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public PieceColor getPieceColor() {
		return color;
	}
	
	@Override
	public ChessPiece.PieceID getPieceID() {
		return ChessPiece.PieceID.PAWN;
	}
	
	@Override
	public short getValue() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Pawn";
	}
	
}
