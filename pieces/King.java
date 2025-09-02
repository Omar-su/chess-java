package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    List<IntPair> possibleMoves = new ArrayList<>();

    King(int id, String name, int row, int col, Color color) {
        super(id, name, row, col, color);
    }

    @Override
    public List<IntPair> getPossibleMoves() {
        int size = Mat.mat.length;

        // Knight moves: (row offset, col offset)
        int[][] moves = {
            { 1,  1}, { -1, -1},
            { 1,  0}, { 0, 1},
            {-1, 0}, {-1,  1},
            {1, -1}, {0, -1}
        };

        List<IntPair> ls = new ArrayList<>();
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (isInside(newRow, newCol, size) && (Mat.getPiece(newRow, newCol).color != this.color)) {
                ls.add(new IntPair(newRow, newCol));
            }
        }

        return ls;
    }

}
