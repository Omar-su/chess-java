package pieces;


public class Piece {

    int id;
    String name;
    int row;
    int col;
    Color color;

    Piece(int id, String name, int row, int col, Color color) {
        this.id = id;
        this.name = name;
        this.row = row;
        this.col = col;
        this.color = color;
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


    public void printPossibleMoves() {}

    @Override
    public String toString() {
        // if (id == 0) return "."; // empty square
        return id + ":" + name + "(" + row + "," + col + ")";
    }
}