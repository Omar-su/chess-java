package pieces;

public class WhitePawn extends Piece implements Move {

    WhitePawn(int id, String name, int row, int col) {
        super(id, name, row, col);
    }

    @Override
    public void move() {
        
    }

    @Override
    public void printPossibleMoves() {
        System.out.println("Possible moves for " + name + " at (" + row + "," + col + "):");

        int size = Mat.mat.length;

        // Forward move (1 square)
        if (isInside(row + 1, col, size) && Mat.getPiece(row + 1, col).name.equals("Empty Place")) {
            printMove(row + 1, col);
        }

        // Double forward move (only if pawn is at starting row and square in front is empty)
        if (row == 1 
                && isInside(row + 2, col, size) 
                && Mat.getPiece(row + 1, col).name.equals("Empty Place") 
                && Mat.getPiece(row + 2, col).name.equals("Empty Place")) {
            printMove(row + 2, col);
        }

        // Capture right
        if (isInside(row + 1, col + 1, size) && Mat.getPiece(row + 1, col + 1).name.startsWith("Black")) {
            printMove(row + 1, col + 1);
        }

        // Capture left
        if (isInside(row + 1, col - 1, size) && Mat.getPiece(row + 1, col - 1).name.startsWith("Black")) {
            printMove(row + 1, col - 1);
        }
    }

    // Helper: check if inside board
    private boolean isInside(int r, int c, int size) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }

    // Helper: print move
    private void printMove(int r, int c) {
        System.out.println("  -> Row: " + r + ", Col: " + c);
    }

    
}
