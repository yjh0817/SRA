package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class King extends Piece {
	
	public King(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) {
		HashSet<Integer> moves = new HashSet<Integer>();
		
		moves.add(where-9);
		moves.add(where-8);
		moves.add(where-7);
		moves.add(where-1);
		moves.add(where+1);
		moves.add(where+7);
		moves.add(where+8);
		moves.add(where+9);
		
		Integer[] crdSet = new Integer[moves.size()];
		moves.toArray(crdSet);
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public ChessPiece.Identifier getPieceID() {
		return ChessPiece.Identifier.KING;
	}
	
	@Override
	public int getValue() {
		return Integer.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return "King";
	}
	
}