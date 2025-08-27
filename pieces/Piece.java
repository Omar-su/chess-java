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

    public void moveTo(int newRow, int newCol, Piece newPos) {
        // TODO make sure move is valid
        
        // Move the piece to a new position
        if (newPos.color == Color.NONE) {
            // if empty space then put empty space in position of piece
            Mat.ChangePos(this.row, this.col, newPos);
            Mat.ChangePos(newRow, newCol, this);
        }else {
            // if enemy then change position of the piece and put an empty position in its place
            EmptyPlace ep = new EmptyPlace(0,"Empty Place",this.row ,this.col , Color.NONE);
            Mat.ChangePos(this.row, this.col, ep);
            Mat.ChangePos(newRow, newCol, this);
        }
        
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