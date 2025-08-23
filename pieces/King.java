package pieces;

public class King extends Piece implements Move {

    King(int id, String name, int row, int col, Color color) {
        super(id, name, row, col, color);
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
    }

        @Override
    public void printPossibleMoves() {
        System.out.println("Possible moves for " + name + " at (" + row + "," + col + "):");
        int size = Mat.mat.length;

        // Knight moves: (row offset, col offset)
        int[][] moves = {
            { 1,  1}, { -1, -1},
            { 1,  0}, { 0, 1},
            {-1, 0}, {-1,  1},
            {1, -1}, {0, -1}
        };

        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (isInside(newRow, newCol, size) && (Mat.getPiece(newRow, newCol).color != this.color)) {
                System.out.println("  -> Row: " + newRow + ", Col: " + newCol);
            }
        }

        //TODO When checkmated

    }


    private boolean isInside(int r, int c, int size) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }
    
}
