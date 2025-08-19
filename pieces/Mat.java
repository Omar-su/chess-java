package pieces;

public class Mat {

    // Class for each board cell
    static class Piece {
        int id;
        String name;
        int row;
        int col;

        Piece(int id, String name, int row, int col) {
            this.id = id;
            this.name = name;
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            // if (id == 0) return "."; // empty square
            return id + ":" + name + "(" + row + "," + col + ")";
        }
    }

    // 8x8 chessboard
    static Piece[][] mat = new Piece[8][8];

    static {
        // White pieces (top)
        mat[0][0] = new Piece(1,"White Rook",0,0);
        mat[0][1] = new Piece(2,"White Knight",0,1);
        mat[0][2] = new Piece(3,"White Bishop",0,2);
        mat[0][3] = new Piece(4,"White Queen",0,3);
        mat[0][4] = new Piece(5,"White King",0,4);
        mat[0][5] = new Piece(3,"White Bishop",0,5);
        mat[0][6] = new Piece(2,"White Knight",0,6);
        mat[0][7] = new Piece(1,"White Rook",0,7);

        for (int j = 0; j < 8; j++) {
            mat[1][j] = new Piece(6,"White Pawn",1,j);
        }

        // Empty squares
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j < 8; j++) {
                mat[i][j] = new Piece(0,"Empty Place",i,j);
            }
        }

        // Black pawns
        for (int j = 0; j < 8; j++) {
            mat[6][j] = new Piece(12,"Black Pawn",6,j);
        }

        // Black pieces (bottom)
        mat[7][0] = new Piece(7,"Black Rook",7,0);
        mat[7][1] = new Piece(8,"Black Knight",7,1);
        mat[7][2] = new Piece(9,"Black Bishop",7,2);
        mat[7][3] = new Piece(10,"Black Queen",7,3);
        mat[7][4] = new Piece(11,"Black King",7,4);
        mat[7][5] = new Piece(9,"Black Bishop",7,5);
        mat[7][6] = new Piece(8,"Black Knight",7,6);
        mat[7][7] = new Piece(7,"Black Rook",7,7);
    }

    // Print method
    public static void printMat() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
