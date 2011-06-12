package com.cyrusian.academic.sra;

import java.util.HashSet;
import com.cyrusian.academic.sra.element.ChessBoard;
import com.cyrusian.academic.sra.element.ChessPiece;


public final class ChessEngine {
	
	private ChessBoard mainBoard;
	private GUIManager delegate;
	private Difficulty difficulty;
	private boolean isWhitesTurn;
	
	public ChessEngine(GUIManager deleg, Difficulty diff) { // specialized on singleplayer
		delegate = deleg;
		difficulty = diff;
		mainBoard = new ChessBoard();
		isWhitesTurn=true;
		//delegate.updateBoard(mainBoard);
	}
	
	private void calculateBestMove() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Integer[] nomanees=null;
			}
			
		}).start();
	}
	
	private Integer[] recursivelyCalculateBestMove() {
		HashSet<Integer> moves = new HashSet<Integer>();
		
		
		
		Integer[] movSet = new Integer[moves.size()];
		moves.toArray(movSet);
		moves = null;
		
		return movSet;
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
		if(isWhitesTurn==false)
			return;
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
		//isWhitesTurn=false;
		
		//calculateBestMove();
	}
	
	public ChessBoard getBoard() {
		return mainBoard;
	}
	
	public enum Difficulty {
		BASIC, ADVANCED, EXTREME;
		
		public int getSimulationLevel() {
			switch(this) {
				case ADVANCED:
					return 2;
				case EXTREME:
					return 3;
				case BASIC:
				default:
					return 1;
			}
		}
	}
	
}