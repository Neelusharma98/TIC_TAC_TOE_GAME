package tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tictaktoe.Board;
import tictaktoe.CellState;
import tictaktoe.Game;

class TestGame {
	private Board board;

    @BeforeEach
    public void init() {
        board = new Board(3);
    }
    
    @Test
    public void testIsFullAfterMarked() {
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                board.makeMove(row, col, CellState.X);
            }
        }
        assertTrue(board.isFull());
    }
    
    @Test
    public void testMarkedCellMarked() {
        board.makeMove(1, 2, CellState.O);
        assertEquals(CellState.O, board.getCellState(1, 2));
    }
    
    @Test
    public void testValidMove() {
        Game game = new Game("PlayerX", "PlayerO");
        game.play(0, 0);
        assertEquals(CellState.X, game.getBoard().getCellState(0, 0));
    }

    @Test
    public void testInvalidMove() {
        Game game = new Game("PlayerX", "PlayerO");
        game.play(0, 0);
        game.play(0, 0); 
        assertEquals(CellState.X, game.getBoard().getCellState(0, 0));
    }

    @Test
    public void testWin() {
        Game game = new Game("PlayerX", "PlayerO");
        game.play(0, 0); 
        game.play(1, 0); 
        game.play(0, 1); 
        game.play(1, 1); 
        game.play(0, 2); 
        assertTrue(game.getBoard().checkWin(CellState.X));
    }

    @Test
    public void testDraw() {
        Game game = new Game("PlayerX", "PlayerO");
        game.play(0, 0); 
        game.play(0, 1); 
        game.play(0, 2); 
        game.play(1, 0); 
        game.play(1, 1); 
        game.play(1, 2); 
        game.play(2, 0); 
        game.play(2, 1); 
        game.play(2, 2); 
        assertTrue(game.getBoard().isFull());
    }

	

}
