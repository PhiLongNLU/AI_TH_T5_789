package Queen;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		if(row < Node.N - 1) {
			this.row++;
		}else {
			this.row = 0;
		}
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// Enter your code here
		if(this.row == q.row) return true;
		else if(Math.abs(this.row - q.row) - Math.abs(this.column) == 0) return true;
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
