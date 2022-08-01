package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	// retornar peça dada uma linha e coluna
	
	public Piece piece (int row, int column) {
		// retornar matriz pieces com linha e coluna
		return pieces[row][column];
	}
	
	// sobrecarga de piece
	public Piece piece (Position position) {
		// retornar matriz pieces com linha e coluna
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// método para colocar peça no tabuleiro
	public void placePiece(Piece piece, Position position) {
		// na matriz de peças, atribuir a peça que veio como argumento desse método
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
}
