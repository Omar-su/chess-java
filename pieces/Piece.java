package pieces;

public class Piece {

    int id;
    String name;
    int row;
    int col;

    Piece(int id, String name, int row, int col) {
        this.id = id;
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public void moveTo(int newRow, int newCol) {
        // Move the piece to a new position
        this.row = newRow;
        this.col = newCol;
        System.out.println("New position for " + name + " is (" + row + "," + col + ") with ID " + id + ":");
        
    }

    public void possibleMoves() {
        System.out.println("Possible moves for " + name + " at (" + row + "," + col + ") with ID " + id + ":");
    }
    

    @Override
    public String toString() {
        // if (id == 0) return "."; // empty square
        return id + ":" + name + "(" + row + "," + col + ")";
    }
}