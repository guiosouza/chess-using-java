package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0 ,0);
		
		if(getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // se a posição existe e não existe peça na posição p
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// regra para o movimento inicial de 2 casas
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			// se a posição existe e não existe peça na posição p e também se o contador de movimentos for zero(testes para p1 e p2):
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) { 
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// posição de diagonal
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { // se a posição existe e não existe peça do oponente na posição
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// outra posição de diagonal
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { // se a posição existe e não existe peça do oponente na posição
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		else { // para as peças preta agora
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // se a posição existe e não existe peça na posição p
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// regra para o movimento inicial de 2 casas
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			// se a posição existe e não existe peça na posição p e também se o contador de movimentos for zero(testes para p1 e p2):
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) { 
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// posição de diagonal
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { // se a posição existe e não existe peça do oponente na posição
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// outra posição de diagonal
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { // se a posição existe e não existe peça do oponente na posição
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
	
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
