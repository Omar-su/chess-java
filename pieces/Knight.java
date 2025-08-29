package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    List<IntPair> possibleMoves = new ArrayList<>();

    Knight(int id, String name, int row, int col, Color color) {
        super(id, name, row, col, color);
    }


    @Override
    public List<IntPair> getPossibleMoves() {
     
        int size = Mat.mat.length;

        // Knight moves: (row offset, col offset)
        int[][] moves = {
            { 2,  1}, { 2, -1},
            { 1,  2}, { 1, -2},
            {-2, -1}, {-2,  1},
            {-1, -2}, {-1,  2}
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

    @Override
    public void printPossibleMoves() {
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
