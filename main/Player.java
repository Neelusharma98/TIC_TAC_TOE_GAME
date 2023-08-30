package tictaktoe;



public class Player {
	private String name;
    private CellState symbol;

    public Player(String name, CellState symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public CellState getSymbol() {
        return symbol;
    }
}
