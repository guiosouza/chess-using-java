package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color; // cor da peça da jogada
	private int moveCount; // contador de jogadas

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	// acrescentar contador
	public void increaseMoveCount() {
		moveCount++; 
	}
	
	public void decreaseMoveCount() {
		moveCount--; 
	}
	
	public int getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}

	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}
