package com.cyrusian.academic.sra.element;


public class ChessBoard implements Cloneable {
	
	private Bishop[] bishops;
	private King[] kings;
	private Knight[] knights;
	private Pawn[] pawns;
	private Queen[] queens;
	private Rook[] rooks;
	private char[] allocs;
	
	public ChessBoard() {
		bishops=new Bishop[] {new Bishop(ChessPiece.Color.WHITE), new Bishop(ChessPiece.Color.BLACK)};
		kings=new King[] {new King(ChessPiece.Color.WHITE), new King(ChessPiece.Color.BLACK)};
		knights=new Knight[] {new Knight(ChessPiece.Color.WHITE), new Knight(ChessPiece.Color.BLACK)};
		pawns=new Pawn[] {new Pawn(ChessPiece.Color.WHITE), new Pawn(ChessPiece.Color.BLACK)};
		queens=new Queen[] {new Queen(ChessPiece.Color.WHITE), new Queen(ChessPiece.Color.BLACK)};
		rooks=new Rook[] {new Rook(ChessPiece.Color.WHITE), new Rook(ChessPiece.Color.BLACK)};
		allocs=new char[] {
			'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r',
			'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p',
			'.', '.', '.', '.', '.', '.', '.', '.',
			'.', '.', '.', '.', '.', '.', '.', '.',
			'.', '.', '.', '.', '.', '.', '.', '.',
			'.', '.', '.', '.', '.', '.', '.', '.',
			'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P',
			'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'
		};
	}
	
	public char[] getAllocation() {
		return allocs;
	}
	
	public ChessPiece getPiece(char type, ChessPiece.Color c) {
		switch(type) {
			case 'B':
			case 'b':
				if(c==ChessPiece.Color.WHITE)
					return bishops[0];
				else
					return bishops[1];
			case 'K':
			case 'k':
				if(c==ChessPiece.Color.WHITE)
					return kings[0];
				else
					return kings[1];
			case 'N':
			case 'n':
				if(c==ChessPiece.Color.WHITE)
					return knights[0];
				else
					return knights[1];
			case 'P':
			case 'p':
				if(c==ChessPiece.Color.WHITE)
					return pawns[0];
				else
					return pawns[1];
			case 'Q':
			case 'q':
				if(c==ChessPiece.Color.WHITE)
					return queens[0];
				else
					return queens[1];
			case 'R':
			case 'r':
				if(c==ChessPiece.Color.WHITE)
					return rooks[0];
				else
					return rooks[1];
			default:
				return null;
		}
	}
	
	public void move(int from, int to) {
		allocs[to]=allocs[from];
		allocs[from]='.';
	}
	
	/*@Override
	public ChessBoard clone() {
		return new ChessBoard(theGrid.clone());
	}
	
	public ChessPiece getPieceAtCoord(int coord) {
		if(ChessPiece.Handyman.isInBound(coord)==true)
			return theGrid[coord];
		
		return null;
	}
	
	public ChessPiece getPieceAtCoord(Coordinate coord) {
		return getPieceAtCoord(coord.getCoordinate());
	}
	
	public void setPieceAtCoord(int where, ChessPiece newPiece) {
		if(ChessPiece.Handyman.isInBound(where)==true)
			theGrid[where]=newPiece;
	}*/
	
}