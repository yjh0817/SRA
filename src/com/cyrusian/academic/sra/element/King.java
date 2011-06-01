package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class King extends Piece {
	
	public King(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) {
		HashSet<Integer> moves = new HashSet<Integer>();
		char[] alloc=aBoard.getAllocation();
		
		if(color==ChessPiece.Color.BLACK) {
			moves.add(ChessPiece.Handyman.isInBound(where-9)==true && alloc[where-9]>=65 && alloc[where-9]<=90 ?where-17:null);
			moves.add(ChessPiece.Handyman.isInBound(where-8)==true && alloc[where-8]>=65 && alloc[where-8]<=90?where-15:null);
			moves.add(ChessPiece.Handyman.isInBound(where-7)==true && alloc[where-7]>=65 && alloc[where-7]<=90?where-10:null);
			moves.add(ChessPiece.Handyman.isInBound(where-1)==true && alloc[where-1]>=65 && alloc[where-1]<=90?where-6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+1)==true && alloc[where+1]>=65 && alloc[where+1]<=90?where+6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+7)==true && alloc[where+7]>=65 && alloc[where+7]<=90?where+10:null);
			moves.add(ChessPiece.Handyman.isInBound(where+8)==true && alloc[where+8]>=65 && alloc[where+8]<=90?where+15:null);
			moves.add(ChessPiece.Handyman.isInBound(where+9)==true && alloc[where+9]>=65 && alloc[where+9]<=90?where+17:null);
		} else {
			moves.add(ChessPiece.Handyman.isInBound(where-9)==true && alloc[where-9]>=97 && alloc[where-9]<=122 ?where-17:null);
			moves.add(ChessPiece.Handyman.isInBound(where-8)==true && alloc[where-8]>=97 && alloc[where-8]<=122?where-15:null);
			moves.add(ChessPiece.Handyman.isInBound(where-7)==true && alloc[where-7]>=97 && alloc[where-7]<=122?where-10:null);
			moves.add(ChessPiece.Handyman.isInBound(where-1)==true && alloc[where-1]>=97 && alloc[where-1]<=122?where-6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+1)==true && alloc[where+1]>=97 && alloc[where+1]<=122?where+6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+7)==true && alloc[where+7]>=97 && alloc[where+7]<=122?where+10:null);
			moves.add(ChessPiece.Handyman.isInBound(where+8)==true && alloc[where+8]>=97 && alloc[where+8]<=122?where+15:null);
			moves.add(ChessPiece.Handyman.isInBound(where+9)==true && alloc[where+9]>=97 && alloc[where+9]<=122?where+17:null);
		}
		moves.remove(null);
		
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