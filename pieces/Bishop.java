package pieces;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    List<IntPair> possibleMoves = new ArrayList<>();

    Bishop(int id, String name, int row, int col, Color color) {
        super(id, name, row, col, color);
    }

    @Override
    public List<IntPair> getPossibleMoves() {
        int size = Mat.mat.length;

        // 4 directions: up, down, right, left
        int[][] directions = {
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
                    // System.out.println("  -> Row: " + r + ", Col: " + c);
                } else {
                    // Enemy piece (different color) can be captured
                    if (target.color != this.color) {
                        // System.out.println("  -> Row: " + r + ", Col: " + c + " (capture " + target.name + ")");
                        ls.add(new IntPair(r, c));
                    }
                    // Stop 
                    break;
                }
            }
        }
        return ls;
    }

}
