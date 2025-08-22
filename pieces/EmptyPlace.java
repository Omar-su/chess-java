package pieces;

public class EmptyPlace extends Piece implements Move {

    EmptyPlace(int id, String name, int row, int col, Color color) {
        super(id, name, row, col, color);
    }

    @Override
    public void move() {
    }

}
