package com.cyrusian.academic.sra;

import java.util.Stack;
import com.cyrusian.academic.sra.element.ChessBoard;
import com.cyrusian.academic.sra.element.ChessPiece;
import com.cyrusian.academic.sra.element.Coordinate;
import com.cyrusian.academic.sra.element.Bishop;
import com.cyrusian.academic.sra.element.King;
import com.cyrusian.academic.sra.element.Knight;
import com.cyrusian.academic.sra.element.MoveHistory;
import com.cyrusian.academic.sra.element.NullPiece;
import com.cyrusian.academic.sra.element.Pawn;
import com.cyrusian.academic.sra.element.Queen;
import com.cyrusian.academic.sra.element.Rook;


public final class ChessEngine {
	
	private ChessBoard mainBoard;
	private GUIManager delegate;
	private Difficulty difficulty;
	private Stack<MoveHistory> traceable;
	
	public ChessEngine(GUIManager deleg, Difficulty diff) { // specialized on singleplayer
		delegate = deleg;
		difficulty = diff;
		mainBoard = new ChessBoard();
		delegate.updateBoard(mainBoard);
		traceable=new Stack<MoveHistory>();
	}
	
	private int calculateBestMove(int levelLimit, int nowLevel) {
		/*
		if(nowLevel%2==1) { // BLACK
			
			if(levelLimit==nowLevel) {
				int 
			}
		}
		//*/
		
		return 0;
	}
	
	public boolean isValid(int crd) {
		char[] alloc=mainBoard.getAllocation();
		
		if(alloc[crd]>=65 && alloc[crd]<=90)
			return true;
		
		return false;
	}
	
	public void runEngieRun(int from, int to) {
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
		
		
	}
	
	public enum Difficulty {
		BASIC, ADVANCED, EXTREME;
		
		public int getValue() {
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