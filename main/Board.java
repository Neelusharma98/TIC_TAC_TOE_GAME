package tictaktoe;



public class Board {
	private CellState[][] cells;
    private int size;

    public Board(int size) {
        this.size = size;
        cells = new CellState[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = CellState.S;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j] + "  |  ");
                
            }
            System.out.println();
            System.out.println("----------------");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] == CellState.S) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && cells[row][col] == CellState.S;
    }

    public void makeMove(int row, int col, CellState player) {
        cells[row][col] = player;
    }

    public boolean checkWin(CellState player) {
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWin = true;

            for (int j = 0; j < size; j++) {
                if (cells[i][j] != player) {
                    rowWin = false;
                }
                if (cells[j][i] != player) {
                    colWin = false;
                }
            }

            if (rowWin || colWin) {
                return true;
            }
        }

       
        boolean mainDiagonalWin = true;
        boolean antiDiagonalWin = true;

        for (int i = 0; i < size; i++) {
            if (cells[i][i] != player) {
                mainDiagonalWin = false;
            }
            if (cells[i][size - i - 1] != player) {
                antiDiagonalWin = false;
            }
        }

        return mainDiagonalWin || antiDiagonalWin;
        
       
    }

    
    public int getSize() {
        return size;
    }

    
    public CellState getCellState(int row, int col) {
        return cells[row][col];
    }

    
    public void setCellState(int row, int col, CellState state) {
        cells[row][col] = state;
    }

}
