package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class Knight extends Piece {
	
	public Knight(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) {
		HashSet<Integer> moves = new HashSet<Integer>();
		char[] alloc=aBoard.getAllocation();
		
		moves.add(ChessPiece.Handyman.isInBound(where-17)==true ?where-17:null);
		moves.add(ChessPiece.Handyman.isInBound(where-15)==true ?where-15:null);
		moves.add(ChessPiece.Handyman.isInBound(where-10)==true ?where-10:null);
		moves.add(ChessPiece.Handyman.isInBound(where-6)==true ?where-6:null);
		moves.add(ChessPiece.Handyman.isInBound(where+6)==true ?where+6:null);
		moves.add(ChessPiece.Handyman.isInBound(where+10)==true ?where+10:null);
		moves.add(ChessPiece.Handyman.isInBound(where+15)==true ?where+15:null);
		moves.add(ChessPiece.Handyman.isInBound(where+17)==true ?where+17:null);
		
		/*if(color==ChessPiece.Color.BLACK) {
			moves.add(ChessPiece.Handyman.isInBound(where-17)==true && alloc[where-17]>=65 && alloc[where-17]<=90 ?where-17:null);
			moves.add(ChessPiece.Handyman.isInBound(where-15)==true && alloc[where-15]>=65 && alloc[where-15]<=90?where-15:null);
			moves.add(ChessPiece.Handyman.isInBound(where-10)==true && alloc[where-10]>=65 && alloc[where-10]<=90?where-10:null);
			moves.add(ChessPiece.Handyman.isInBound(where-6)==true && alloc[where-6]>=65 && alloc[where-6]<=90?where-6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+6)==true && alloc[where+6]>=65 && alloc[where+6]<=90?where+6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+10)==true && alloc[where+10]>=65 && alloc[where+10]<=90?where+10:null);
			moves.add(ChessPiece.Handyman.isInBound(where+15)==true && alloc[where+15]>=65 && alloc[where+15]<=90?where+15:null);
			moves.add(ChessPiece.Handyman.isInBound(where+17)==true && alloc[where+17]>=65 && alloc[where+17]<=90?where+17:null);
		/*} else {
			moves.add(ChessPiece.Handyman.isInBound(where-17)==true && alloc[where-17]>=97 && alloc[where-17]<=122 ?where-17:null);
			moves.add(ChessPiece.Handyman.isInBound(where-15)==true && alloc[where-15]>=97 && alloc[where-15]<=122?where-15:null);
			moves.add(ChessPiece.Handyman.isInBound(where-10)==true && alloc[where-10]>=97 && alloc[where-10]<=122?where-10:null);
			moves.add(ChessPiece.Handyman.isInBound(where-6)==true && alloc[where-6]>=97 && alloc[where-6]<=122?where-6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+6)==true && alloc[where+6]>=97 && alloc[where+6]<=122?where+6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+10)==true && alloc[where+10]>=97 && alloc[where+10]<=122?where+10:null);
			moves.add(ChessPiece.Handyman.isInBound(where+15)==true && alloc[where+15]>=97 && alloc[where+15]<=122?where+15:null);
			moves.add(ChessPiece.Handyman.isInBound(where+17)==true && alloc[where+17]>=97 && alloc[where+17]<=122?where+17:null);
		}*/
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