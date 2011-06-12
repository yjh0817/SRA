package com.cyrusian.academic.sra;

import java.util.Stack;
import com.cyrusian.academic.sra.element.ChessBoard;
import com.cyrusian.academic.sra.element.ChessPiece;


public final class ChessEngine {
	
	private ChessBoard mainBoard;
	private GUIManager delegate;
	private Difficulty difficulty;
	
	public ChessEngine(GUIManager deleg, Difficulty diff) { // specialized on singleplayer
		delegate = deleg;
		difficulty = diff;
		mainBoard = new ChessBoard();
		delegate.updateBoard(mainBoard);
	}
	
	private void calculateBestMove() {//(int levelLimit, int nowLevel) {
		//
	}
	
	public boolean isWhite(int crd) {
		char[] alloc=mainBoard.getAllocation();
		
		if(alloc[crd]>=65 && alloc[crd]<=90)
			return true;
		
		return false;
	}
	
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(Difficulty d) {
		difficulty=d;
	}
	
	public void runEngieRun(int from, int to) {
		System.out.println(from+"/"+to); //dbg
		char[] alloc=mainBoard.getAllocation();
		Integer[] allows;
		boolean found=false;
		
		allows=mainBoard.getPiece(alloc[from], ChessPiece.Color.WHITE).getAllAvailableMoves(mainBoard, from);
		for(int allow:allows) {
			if(allow==to) {
				found=true;
				break;
			}
		}
		if(found==false)
			return;
		
		mainBoard.move(from, to);
		delegate.updateBoard(mainBoard);
		
		//calculateBestMove();
	}
	
	public enum Difficulty {
		BASIC, ADVANCED, EXTREME;
		
		public int getSimulationLevel() {
			switch(this) {
				case BASIC:
					return 3;
				case ADVANCED:
					return 4;
				case EXTREME:
					return 5;
				default:
					return 1;
			}
		}
	}
	
}