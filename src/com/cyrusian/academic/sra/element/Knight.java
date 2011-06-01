package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Knight extends Piece {
	
	public Knight(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) {
		HashSet<Integer> moves = new HashSet<Integer>();
		
		
		
		moves.add(ChessPiece.Handyman.isInBound(where-17)==true?where-17:null);
		moves.add(ChessPiece.Handyman.isInBound(where-15)==true?where-15:null);
		moves.add(ChessPiece.Handyman.isInBound(where-10)==true?where-10:null);
		moves.add(ChessPiece.Handyman.isInBound(where-6)==true?where-6:null);
		moves.add(ChessPiece.Handyman.isInBound(where+6)==true?where+6:null);
		moves.add(ChessPiece.Handyman.isInBound(where+10)==true?where+10:null);
		moves.add(ChessPiece.Handyman.isInBound(where+15)==true?where+15:null);
		moves.add(ChessPiece.Handyman.isInBound(where+17)==true?where+17:null);
		moves.remove(null);
		
		Integer[] crdSet = new Integer[moves.size()];
		moves.toArray(crdSet);
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public ChessPiece.Identifier getPieceID() {
		return ChessPiece.Identifier.KNIGHT;
	}
	
	@Override
	public int getValue() {
		return 3;
	}
	
	@Override
	public String toString() {
		return "Knight";
	}
	
}