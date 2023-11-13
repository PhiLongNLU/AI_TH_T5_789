package student;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		// Enter your code here
		int value = row+1;
		if(value==Node.N) {
			row=0;
		}else {
			row++;
		}
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// Enter your code here
		if(row==q.row)return false;
		if(column==q.column)return false;
		if(Math.abs(row-q.row)==Math.abs(column-q.column))return false;
		return true;
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
