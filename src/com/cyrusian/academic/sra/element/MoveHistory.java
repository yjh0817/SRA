package com.cyrusian.academic.sra.element;


public class MoveHistory {
	
	private int from;
	private int score;
	private int to;
	
	public MoveHistory(int f, int s, int t) {
		from=f;
		score=s;
		to=t;
	}
	
	public int getFrom() {
		return from;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getTo() {
		return to;
	}
	
}