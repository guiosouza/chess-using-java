package boardgame;

// piece é abstrato para servir em qualquer peça
public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; // peça recém criada é null
	}

	protected Board getBoard() {
		return board;
	}
	
	// operação abstrata porque não sabemos qual peça ainda
	public abstract boolean[][] possibleMoves();
	
	// testar se pode mover
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	// verificar se a 
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat.length; j ++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
