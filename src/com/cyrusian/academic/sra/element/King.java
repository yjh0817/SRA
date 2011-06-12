package com.cyrusian.academic.sra.element;

import java.util.HashSet;


public class King extends Piece {
	
	public King(ChessPiece.Color c) {
		color = c;
	}
	
	@Override
	public Integer[] getAllAvailableMoves(ChessBoard aBoard, int where) { // checked
		HashSet<Integer> moves = new HashSet<Integer>();
		char[] alloc=aBoard.getAllocation();
		
		if(color==ChessPiece.Color.BLACK) {
			moves.add(ChessPiece.Handyman.isInBound(where-9)==true && (alloc[where-9]=='.' || Character.isUpperCase(alloc[where-9])==true)?where-17:null);
			moves.add(ChessPiece.Handyman.isInBound(where-8)==true && (alloc[where-9]=='.' || Character.isUpperCase(alloc[where-8])==true)?where-15:null);
			moves.add(ChessPiece.Handyman.isInBound(where-7)==true && (alloc[where-9]=='.' || Character.isUpperCase(alloc[where-7])==true)?where-10:null);
			moves.add(ChessPiece.Handyman.isInBound(where-1)==true && (alloc[where-9]=='.' || Character.isUpperCase(alloc[where-1])==true)?where-6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+1)==true && (alloc[where-9]=='.' || Character.isUpperCase(alloc[where+1])==true)?where+6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+7)==true && (alloc[where-9]=='.' || Character.isUpperCase(alloc[where+7])==true)?where+10:null);
			moves.add(ChessPiece.Handyman.isInBound(where+8)==true && (alloc[where-9]=='.' || Character.isUpperCase(alloc[where+8])==true)?where+15:null);
			moves.add(ChessPiece.Handyman.isInBound(where+9)==true && (alloc[where-9]=='.' || Character.isUpperCase(alloc[where+9])==true)?where+17:null);
		} else {
			moves.add(ChessPiece.Handyman.isInBound(where-9)==true && (alloc[where-9]=='.' || Character.isLowerCase(alloc[where-9])==true)?where-17:null);
			moves.add(ChessPiece.Handyman.isInBound(where-8)==true && (alloc[where-9]=='.' || Character.isLowerCase(alloc[where-8])==true)?where-15:null);
			moves.add(ChessPiece.Handyman.isInBound(where-7)==true && (alloc[where-9]=='.' || Character.isLowerCase(alloc[where-7])==true)?where-10:null);
			moves.add(ChessPiece.Handyman.isInBound(where-1)==true && (alloc[where-9]=='.' || Character.isLowerCase(alloc[where-1])==true)?where-6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+1)==true && (alloc[where-9]=='.' || Character.isLowerCase(alloc[where+1])==true)?where+6:null);
			moves.add(ChessPiece.Handyman.isInBound(where+7)==true && (alloc[where-9]=='.' || Character.isLowerCase(alloc[where+7])==true)?where+10:null);
			moves.add(ChessPiece.Handyman.isInBound(where+8)==true && (alloc[where-9]=='.' || Character.isLowerCase(alloc[where+8])==true)?where+15:null);
			moves.add(ChessPiece.Handyman.isInBound(where+9)==true && (alloc[where-9]=='.' || Character.isLowerCase(alloc[where+9])==true)?where+17:null);
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
		return 10;
	}
	
	@Override
	public String toString() {
		return "King";
	}
	
}