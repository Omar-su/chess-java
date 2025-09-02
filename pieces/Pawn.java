package pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    List<IntPair> possibleMoves = new ArrayList<>();


    Pawn(int id, String name, int row, int col, Color color) {
        super(id, name, row, col, color);
    }

    @Override
    public List<IntPair> getPossibleMoves() {
        List<IntPair> moves = new ArrayList<>();
        int size = Mat.mat.length;

        int dir = 0;
        int startRow = 0;

        if (this.color == Color.BLACK) {
            dir = -1;
            startRow = 6;
        } else if (this.color == Color.WHITE) {
            dir = 1;
            startRow = 1;
        }

        // Forward move (1 square)
        if (isInside(row + dir, col, size) && Mat.getPiece(row + dir, col).name.equals("Empty Place")) {
            moves.add(new IntPair(row + dir, col));
        }

        // Double move (if at starting row)
        if (row == startRow 
                && this.isInside(row + 2 * dir, col, size) 
                && Mat.getPiece(row + dir, col).name.equals("Empty Place") 
                && Mat.getPiece(row + 2 * dir, col).name.equals("Empty Place")) {
            moves.add(new IntPair(row + 2 * dir, col));
        }

        // Capture diagonals
        if (isInside(row + dir, col + 1, size) && Mat.getPiece(row + dir, col + 1).color != Color.NONE) {
            moves.add(new IntPair(row + dir, col + 1));
        }
        if (isInside(row + dir, col - 1, size) && Mat.getPiece(row + dir, col - 1).color != Color.NONE) {
            moves.add(new IntPair(row + dir, col - 1));
        }

        return moves;
    }



}
