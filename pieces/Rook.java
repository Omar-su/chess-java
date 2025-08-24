package pieces;

public class Rook extends Piece implements Move {

    Rook(int id, String name, int row, int col, Color color) {
        super(id, name, row, col, color);
    }

    @Override
    public void move() {
    }

    @Override
    public void printPossibleMoves(){
        System.out.println("Possible moves for " + name + " at (" + row + "," + col + "):");
        int size = Mat.mat.length;

        // 4 directions: up, down, right, left
        int[][] directions = {
            {-1, 0}, // up
            { 1, 0}, // down
            { 0, 1}, // right
            { 0,-1}  // left
        };

        for (int[] dir : directions) {
            int r = row;
            int c = col;

            while (true) {
                r += dir[0];
                c += dir[1];

                if (!isInside(r, c, size)) break;

                Piece target = Mat.getPiece(r, c);

                if (target.color == Color.NONE) {
                    // Empty square
                    System.out.println("  -> Row: " + r + ", Col: " + c);
                } else {
                    // Enemy piece (different color) can be captured
                    if (target.color != this.color) {
                        System.out.println("  -> Row: " + r + ", Col: " + c + " (capture " + target.name + ")");
                    }
                    // Stop 
                    break;
                }
            }
        }
    }

    private boolean isInside(int r, int c, int size) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }
    
}