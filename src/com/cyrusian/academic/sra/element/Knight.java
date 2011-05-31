package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Knight implements ChessPiece, Valuable {
	
	private ChessPiece.PieceColor color;
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth().moveNorth().moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveEast().moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth().moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth().moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest().moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest().moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth().moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth().moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.remove(null);

		Coordinate[] crdSet = new Coordinate[moves.size()];
		moves.toArray(crdSet);
		tmpCrd = null;
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public ChessPiece.PieceColor getPieceColor() {
		return color;
	}
	
	@Override
	public ChessPiece.PieceID getPieceID() {
		return ChessPiece.PieceID.KNIGHT;
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
