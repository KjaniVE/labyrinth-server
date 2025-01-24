package game.logic;

import java.util.Objects;

public class Location {

    private int row;
    private int col;

    public Location(int row, int col) {
        setCol(col);
        setRow(row);
    }

    public void setRow(int row) {
        if(row < 0 || row > 6) {
            throw new IllegalArgumentException("Row must be between 0 and 6");
        }
        this.row = row;
    }

    public void setCol(int col) {
        if (col < 0 || col > 6) {
            throw new IllegalArgumentException("Col must be between 0 and 6");
        }
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "(row: " + row + ", col: " + col + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return row == location.row && col == location.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
