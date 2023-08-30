package tictaktoe;

import java.util.Scanner;


public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game(String playerXName, String playerOName) {
        board = new Board(3); 
        playerX = new Player(playerXName, CellState.X);
        playerO = new Player(playerOName, CellState.O);
        currentPlayer = playerX;
    }

    public void play(int row, int col) {
        try {
            if (board.isValidMove(row, col)) {
                board.makeMove(row, col, currentPlayer.getSymbol());

                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println(currentPlayer.getName() + " is the winner!");
                } else if (board.isFull()) {
                    System.out.println("It's a draw in this game");
                } else {
                    currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                }
            } else {
                System.out.println("Cell already occupied. Try again and select another cell.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid row or column input. Please try again.");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (!board.isFull() && !board.checkWin(playerX.getSymbol()) && !board.checkWin(playerO.getSymbol())) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + "'s turn");

            try {
                System.out.print("Enter row: ");
                int row = scanner.nextInt();

                System.out.print("Enter column: ");
                int col = scanner.nextInt();

                play(row, col);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid row and column.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        
    

    
    }

    

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public void setPlayerX(Player playerX) {
        this.playerX = playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public void setPlayerO(Player playerO) {
        this.playerO = playerO;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}