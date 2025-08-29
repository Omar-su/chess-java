package pieces;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    List<IntPair> possibleMoves = new ArrayList<>();

    Queen(int id, String name, int row, int col, Color color) {
        super(id, name, row, col, color);
    }
    
    @Override
    public List<IntPair> getPossibleMoves() {
        int size = Mat.mat.length;

        // 4 directions: up, down, right, left
        int[][] directions = {
            {-1, 0}, // up
            { 1, 0}, // down
            { 0, 1}, // right
            { 0,-1}, // left
            {-1, -1}, // up left
            { 1, 1}, // down right
            { -1, 1}, // up right
            { 1,-1}  // down left
        };

        List<IntPair> ls = new ArrayList<>();

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
                    ls.add(new IntPair(r, c));
                } else {
                    // Enemy piece (different color) can be captured
                    if (target.color != this.color) {
                        ls.add(new IntPair(r, c));
                    }
                    // Stop 
                    break;
                }
            }
        }
        return ls;
    }


    // Movement of Bishop and Rook
    @Override
    public void printPossibleMoves(){
        System.out.println("Possible moves for " + name + " at (" + row + "," + col + "):");

        possibleMoves = getPossibleMoves();
        for (var p : possibleMoves) {
            System.out.println("  -> Row: " + p.getFirst() + ", Col: " + p.getSecond());
        }

    }

    private boolean isInside(int r, int c, int size) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }
    
}
