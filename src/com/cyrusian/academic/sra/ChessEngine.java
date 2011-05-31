package com.cyrusian.academic.sra;

import com.cyrusian.academic.sra.element.ChessBoard;
import com.cyrusian.academic.sra.element.ChessPiece;
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
	
	public ChessEngine(GUIManager deleg) { // specialized on singleplayer
		delegate = deleg;
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
	
	public void runEngieRun(int from, int to) {
		//
	}
	
	public void updateBoard() {
		for(int i=0; i<64; ++i) {
			String pieceName = mainBoard.getPieceAtCoord(i).toString();
			if(pieceName==null)
				continue;
			delegate.getButtonAt(i).setIcon(delegate.getPieceImages().get(pieceName+"-"+mainBoard.getPieceAtCoord(i).getColor().toString()));
		}
	}
	
}