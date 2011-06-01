package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Rook extends Piece {
	
	public Rook(ChessPiece.Color c) {
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
		return ChessPiece.Identifier.ROOK;
	}
	
	@Override
	public int getValue() {
		return 5;
	}
	
	@Override
	public String toString() {
		return "Rook";
	}
	
}