package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class King implements ChessPiece, Valuable {
	
	private ChessPiece.PieceColor color;
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveEast()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveSouth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveWest()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.moveNorth()) == true && aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color ? tmpCrd.clone() : null);
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
		return ChessPiece.PieceID.KING;
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
