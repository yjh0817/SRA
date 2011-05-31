package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Queen implements ChessPiece, Valuable {
	
	private ChessPiece.PieceColor color;
	
	@Override
	public Coordinate[] getAllAvailableMoves(ChessBoard aBoard, Coordinate where) {
		HashSet<Coordinate> moves = new HashSet<Coordinate>();
		
		Coordinate tmpCrd = where.clone();
		do {
			tmpCrd.moveNorth().moveWest();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color) {
					moves.add(tmpCrd.clone());
					break;
				}
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveWest().moveSouth();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color) {
					moves.add(tmpCrd.clone());
					break;
				}
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveSouth().moveEast();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color) {
					moves.add(tmpCrd.clone());
					break;
				}
			} else
				break;
		} while(true);
		
		tmpCrd = where.clone();
		do {
			tmpCrd.moveEast().moveNorth();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color) {
					moves.add(tmpCrd.clone());
					break;
				}
			} else
				break;
		} while(true);
		
		do {
			tmpCrd.moveNorth();
			if(ChessPiece.Handyman.isInBound(tmpCrd) == true) {
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color) {
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
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color) {
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
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color) {
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
				if(aBoard.getPieceAtCoord(tmpCrd).getPieceID() == ChessPiece.PieceID.NONE)
					moves.add(tmpCrd.clone());
				else if(aBoard.getPieceAtCoord(tmpCrd).getPieceColor() != color) {
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
	public PieceColor getPieceColor() {
		return color;
	}
	
	@Override
	public ChessPiece.PieceID getPieceID() {
		return ChessPiece.PieceID.QUEEN;
	}
	
	@Override
	public short getValue() {
		return 9;
	}
	
	@Override
	public String toString() {
		return "Queen";
	}
	
}
