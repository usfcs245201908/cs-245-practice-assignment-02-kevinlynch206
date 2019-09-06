public class NQueens {
	
	int n;
	int[][] board;
	
	public NQueens(int n) {
		this.n = n;
		this.board = new int[n][n];	
	}
	
	
	boolean placeNQueens(int row) {
		if (row == n) {
			return true;
		}
		
		if (n == 2 || n == 3 ) {
			return false;
		}
		
		for (int col = 0; col < n; col++) {
			if (!isAttacked(row, col)) {
				board[row][col] = 1;
				if (placeNQueens(row + 1)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	
	boolean placeNQueens() throws Exception {
		if(n <= 0){
			throw new Exception();
		}
		return placeNQueens(0);
	}


	
	boolean isAttacked(int row, int col) {

		//checks row
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return true;
			}
		}
		
		//diag and up
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return true;
			}
		}

		// check lower diagonal
		for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		// safe to place
		return false;
	}
	
	
	
	public void printToConsole() {
		try{
		placeNQueens();	
		
		 for (int i = 0; i < n; i++) { 
				for (int j = 0; j < n; j++) 
					System.out.print(" " + board[i][j] 
									 + " "); 
				System.out.println(); 
			}
		}
		catch(Exception e){
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}