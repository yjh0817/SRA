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
		
		int cursor=where;
		if(ChessPiece.Color.BLACK==color){
			if(8<=where && where<=15)
				if(alloc[cursor+16]=='.')	moves.add(cursor+16);
			if(alloc[cursor+8]=='.')		moves.add(cursor+8);
			if(Character.isUpperCase(alloc[cursor+7]))	moves.add(cursor+7);
			if(Character.isUpperCase(alloc[cursor+9]))	moves.add(cursor+9);
		}else{
			if(48<=where && where<=55)
				if(alloc[cursor-16]=='.')	moves.add(cursor-16);
			if(alloc[cursor-8]=='.')		moves.add(cursor-8);
			if(Character.isLowerCase(alloc[cursor-9]))	moves.add(cursor-9);
			if(Character.isLowerCase(alloc[cursor-7]))	moves.add(cursor-7);
		}
		
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