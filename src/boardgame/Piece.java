package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; // peça recém criada é null
	}

	protected Board getBoard() {
		return board;
	}
	
}
