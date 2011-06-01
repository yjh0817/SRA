package com.cyrusian.academic.sra.element;


public class MoveHistory {
	
	private ChessPiece piece;
	private int from;
	private int to;
	
	public MoveHistory(ChessPiece p, int f, int t) {
		piece=p;
		from=f;
		to=t;
	}
	
	public int getFrom() {
		return from;
	}
	
	public ChessPiece getPiece() {
		return piece;
	}
	
	public int getTo() {
		return to;
	}
	
}