package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Pawn extends Piece {
	
	public Pawn(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) {
		HashSet<Integer> moves = new HashSet<Integer>();
		char[] alloc=aBoard.getAllocation();
		
		Integer[] crdSet = new Integer[moves.size()];
		moves.toArray(crdSet);
		moves = null;
		
		return crdSet;
	}
	
	@Override
	public ChessPiece.Identifier getPieceID() {
		return ChessPiece.Identifier.PAWN;
	}
	
	@Override
	public int getValue() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Pawn";
	}
	
}