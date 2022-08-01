package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		// ao criar um tabuleiro as linhas e colunas tem que ser maior que 1!
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	/* ATENÇÃO
	 * Para rows e columns não temos os métodos sets
	 * Isso porque depois de criado o tabuleiro
	 * Não queremos que sejam feitas alterações nele
	 */

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	// retornar peça dada uma linha e coluna
	
	public Piece piece (int row, int column) {
		// retornar matriz pieces com linha e coluna
		if(!positionExists(row, column)) {
			throw new BoardException("Position, not on the board");
		}
		return pieces[row][column];
	}
	
	// sobrecarga de piece
	public Piece piece (Position position) {
		// retornar matriz pieces com linha e coluna
		if(!positionExists(position)) {
			throw new BoardException("Position, not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// método para colocar peça no tabuleiro
	public void placePiece(Piece piece, Position position) {
		
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		// na matriz de peças, atribuir a peça que veio como argumento desse método
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	// terá horas que será mais fácil testar pela linha e coluna do que posição
	// classe auxiliar
	private boolean positionExists(int row, int column) {
		
		// quando que uma posição em uma dada linha e coluna existe? quando a posição está
		// dentro do tabuleiro
		return row >= 0 && row < rows && column >= 0 && column < columns; 
	}
	
	// puxa do método acima
	public boolean positionExists (Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// testar se tem uma peça em dada posição
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
