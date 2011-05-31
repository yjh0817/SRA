package com.cyrusian.academic.sra;

import com.cyrusian.academic.sra.element.ChessBoard;
import com.cyrusian.academic.sra.element.ChessPiece;
import com.cyrusian.academic.sra.element.Coordinate;
import com.cyrusian.academic.sra.element.Bishop;
import com.cyrusian.academic.sra.element.King;
import com.cyrusian.academic.sra.element.Knight;
import com.cyrusian.academic.sra.element.NullPiece;
import com.cyrusian.academic.sra.element.Pawn;
import com.cyrusian.academic.sra.element.Queen;
import com.cyrusian.academic.sra.element.Rook;


public final class ChessEngine {
	
	private ChessBoard mainBoard;
	private GUIManager delegate;
	private Difficulty difficulty;
	
	public ChessEngine(GUIManager deleg, Difficulty diff) { // specialized on singleplayer
		delegate = deleg;
		difficulty = diff;
		mainBoard = new ChessBoard(new ChessPiece[] {
			new Rook(ChessPiece.Color.BLACK), new Knight(ChessPiece.Color.BLACK), new Bishop(ChessPiece.Color.BLACK), new Queen(ChessPiece.Color.BLACK), new King(ChessPiece.Color.BLACK), new Bishop(ChessPiece.Color.BLACK), new Knight(ChessPiece.Color.BLACK), new Rook(ChessPiece.Color.BLACK),
			new Pawn(ChessPiece.Color.BLACK), new Pawn(ChessPiece.Color.BLACK), new Pawn(ChessPiece.Color.BLACK), new Pawn(ChessPiece.Color.BLACK), new Pawn(ChessPiece.Color.BLACK), new Pawn(ChessPiece.Color.BLACK), new Pawn(ChessPiece.Color.BLACK), new Pawn(ChessPiece.Color.BLACK),
			new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(),
			new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(),
			new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(),
			new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(), new NullPiece(),
			new Pawn(ChessPiece.Color.WHITE), new Pawn(ChessPiece.Color.WHITE), new Pawn(ChessPiece.Color.WHITE), new Pawn(ChessPiece.Color.WHITE), new Pawn(ChessPiece.Color.WHITE), new Pawn(ChessPiece.Color.WHITE), new Pawn(ChessPiece.Color.WHITE), new Pawn(ChessPiece.Color.WHITE),
			new Rook(ChessPiece.Color.WHITE), new Knight(ChessPiece.Color.WHITE), new Bishop(ChessPiece.Color.WHITE), new King(ChessPiece.Color.WHITE), new Queen(ChessPiece.Color.WHITE), new Bishop(ChessPiece.Color.WHITE), new Knight(ChessPiece.Color.WHITE), new Rook(ChessPiece.Color.WHITE)
		});
		updateBoard();
	}
	
	private int[] calculateBestMove(ChessBoard chessBoard, int calcLimit, int nowCalc, int scoreSoFar) {
		int realLarge=-1;
		int realFrom=-1;
		int realTo=-1;
		for(int lp=0; lp<64; ++lp) {
			ChessPiece ap=chessBoard.getPieceAtCoord(lp);
			if(ap.getPieceID()==ChessPiece.Identifier.NONE)
				continue;
			if(nowCalc%2==1 && ap.getColor()==ChessPiece.Color.BLACK) {
				Coordinate[] avails=ap.getAllAvailableMoves(chessBoard, new Coordinate(lp));
				if(nowCalc==calcLimit) {
					if(avails.length==0)
						continue;
					int largest=-1;
					int largeInd=-1;
					for(int lps=0; lps<avails.length; ++lps) {
						if(largest<chessBoard.getPieceAtCoord(avails[lps]).getValue()) {
							largest=chessBoard.getPieceAtCoord(avails[lps]).getValue();
							largeInd=lps;
						}
					}
					if(largest!=-1 && realLarge<largest) {
						realLarge=largest;
						realFrom=lp;
						realTo=avails[largeInd].getCoordinate();
					}
				} else {
					if(avails.length==0)
						continue;
					int largest=-1;
					int largeInd=-1;
					for(int lps=0; lps<avails.length; ++lps) {
						ChessBoard cln=chessBoard.clone();
						cln.setPieceAtCoord(avails[lps].getCoordinate(), chessBoard.getPieceAtCoord(lp));
						cln.setPieceAtCoord(lp, new NullPiece());
						
						int[] move=calculateBestMove(cln, calcLimit, nowCalc+1, chessBoard.getPieceAtCoord(avails[lps]).getValue()+scoreSoFar);
						if(move==null)
							continue;
						if(largest<move[2]) {
							largest=move[2];
							largeInd=lps;
						}
					}
					if(largest!=-1 && realLarge<largest) {
						realLarge=largest;
						realFrom=lp;
						realTo=avails[largeInd].getCoordinate();
					}
				}
			}
			if(nowCalc%2==0 && ap.getColor()==ChessPiece.Color.WHITE) {
				Coordinate[] avails=ap.getAllAvailableMoves(chessBoard, new Coordinate(lp));
				if(nowCalc==calcLimit) {
					if(avails.length==0)
						continue;
					int largest=-1;
					int largeInd=-1;
					for(int lps=0; lps<avails.length; ++lps) {
						if(largest<chessBoard.getPieceAtCoord(avails[lps]).getValue()) {
							largest=chessBoard.getPieceAtCoord(avails[lps]).getValue();
							largeInd=lps;
						}
					}
					if(largest!=-1 && realLarge<largest) {
						realLarge=largest;
						realFrom=lp;
						realTo=avails[largeInd].getCoordinate();
					}
				} else {
					if(avails.length==0)
						continue;
					int largest=-1;
					int largeInd=-1;
					for(int lps=0; lps<avails.length; ++lps) {
						ChessBoard cln=chessBoard.clone();
						cln.setPieceAtCoord(avails[lps].getCoordinate(), chessBoard.getPieceAtCoord(lp));
						cln.setPieceAtCoord(lp, new NullPiece());
						
						int[] move=calculateBestMove(cln, calcLimit, nowCalc+1, chessBoard.getPieceAtCoord(avails[lps]).getValue()+scoreSoFar);
						if(move==null)
							continue;
						if(largest<move[2]) {
							largest=move[2];
							largeInd=lps;
						}
					}
					if(largest!=-1 && realLarge<largest) {
						realLarge=largest;
						realFrom=lp;
						realTo=avails[largeInd].getCoordinate();
					}
				}
			}
		}
		
		if(realLarge==-1)
			return null;
		else
			return new int[] {realFrom, realTo, realLarge};
	}
	
	public void runEngieRun(int from, int to) {
		// check validity
		if(isValid(from)==false)
			return;
		
		Coordinate[] avails = mainBoard.getPieceAtCoord(from).getAllAvailableMoves(mainBoard, new Coordinate(from));
		boolean exists=false;
		for(Coordinate each:avails) {
			if(each.getCoordinate() == to) {
				exists=true;
				break;
			}
		}
		if(exists == false)
			return;
		
		mainBoard.setPieceAtCoord(to, mainBoard.getPieceAtCoord(from));
		mainBoard.setPieceAtCoord(from, new NullPiece());
		
		updateBoard();
		
		int[] move = calculateBestMove(mainBoard.clone(), difficulty.getValue(), 1, 0);
		if(move==null)
			System.out.println("n/a");
		else {
			System.out.println("moved "+move[0]+" to "+move[1]);
			mainBoard.setPieceAtCoord(move[1], mainBoard.getPieceAtCoord(move[0]));
			mainBoard.setPieceAtCoord(move[0], new NullPiece());
			updateBoard();
		}
	}
	
	public boolean isValid(int coord) {
		ChessPiece theOne = mainBoard.getPieceAtCoord(coord);
		if(theOne.getPieceID() == ChessPiece.Identifier.NONE || theOne.getColor() != ChessPiece.Color.WHITE)
			return false;
		
		return true;
	}
	
	public void updateBoard() {
		for(int i=0; i<64; ++i) {
			String pieceName = mainBoard.getPieceAtCoord(i).toString();
			if(pieceName==null)
				delegate.getButtonAt(i).setIcon(null);
			else
				delegate.getButtonAt(i).setIcon(delegate.getPieceImages().get(pieceName+"-"+mainBoard.getPieceAtCoord(i).getColor().toString()));
		}
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