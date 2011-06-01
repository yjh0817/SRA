package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Queen extends Piece {
	
	public Queen(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) {
		HashSet<Integer> moves = new HashSet<Integer>();
		
		Integer[] crdSet = new Integer[moves.size()];
		moves.toArray(crdSet);
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public ChessPiece.Identifier getPieceID() {
		return ChessPiece.Identifier.QUEEN;
	}
	
	@Override
	public int getValue() {
		return 9;
	}
	
	@Override
	public String toString() {
		return "Queen";
	}
	
}