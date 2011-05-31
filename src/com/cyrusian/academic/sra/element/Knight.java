package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Knight implements ChessPiece, Valuable {
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		// 이 지저분한 코드를 어떻게 간소화할 수 없을까?
		Coordinate tmpCrd = where.clone().moveNorth().moveNorth().moveEast();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.getCoordinate()) == true ? tmpCrd.clone() : null);
		tmpCrd.moveEast().moveSouth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.getCoordinate()) == true ? tmpCrd.clone() : null);
		tmpCrd.moveSouth().moveSouth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.getCoordinate()) == true ? tmpCrd.clone() : null);
		tmpCrd.moveSouth().moveWest();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.getCoordinate()) == true ? tmpCrd.clone() : null);
		tmpCrd.moveWest().moveWest();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.getCoordinate()) == true ? tmpCrd.clone() : null);
		tmpCrd.moveWest().moveNorth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.getCoordinate()) == true ? tmpCrd.clone() : null);
		tmpCrd.moveNorth().moveNorth();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.getCoordinate()) == true ? tmpCrd.clone() : null);
		tmpCrd.moveNorth().moveEast();
		moves.add(ChessPiece.Handyman.isInBound(tmpCrd.getCoordinate()) == true ? tmpCrd.clone() : null);
		moves.remove(null);

		Coordinate[] crdSet = new Coordinate[moves.size()];
		moves.toArray(crdSet);
		tmpCrd = null;
		moves = null;
		
		return crdSet;
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
