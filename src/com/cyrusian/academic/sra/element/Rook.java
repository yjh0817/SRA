package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Rook extends Piece {
	
	public Rook(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) {
		HashSet<Integer> moves = new HashSet<Integer>();
		char[] alloc=aBoard.getAllocation();
		
		int cursor=where;
		do {
			cursor-=8;
			if(ChessPiece.Handyman.isInBound(cursor)==true) {
				if(color==ChessPiece.Color.BLACK) {
					if(alloc[cursor]=='.' || Character.isUpperCase(alloc[cursor])==true)
						moves.add(cursor);
					else
						break;
				} else {
					if(alloc[cursor]=='.' || Character.isLowerCase(alloc[cursor])==true)
						moves.add(cursor);
					else
						break;
				}
				
				if(cursor%8==0 || cursor<=7)
					break;
			} else
				break;
		} while(true);
		
		cursor=where;
		do {
			cursor+=8;
			if(ChessPiece.Handyman.isInBound(cursor)==true) {
				if(color==ChessPiece.Color.BLACK) {
					if(alloc[cursor]=='.' || Character.isUpperCase(alloc[cursor])==true)
						moves.add(cursor);
					else
						break;
				} else {
					if(alloc[cursor]=='.' || Character.isLowerCase(alloc[cursor])==true)
						moves.add(cursor);
					else
						break;
				}
				
				if(cursor%7==0 || cursor>=56)
					break;
			} else
				break;
		} while(true);
		
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