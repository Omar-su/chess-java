package pieces;

public class Mat {


    // 8x8 chessboard
    static Piece[][] mat = new Piece[8][8];

    static {
        // White pieces (top)
        mat[0][0] = new Piece(1,"White Rook",0,0, Color.WHITE);
        mat[0][1] = new Knight(2,"White Knight",0,1, Color.WHITE);
        mat[0][2] = new Piece(3,"White Bishop",0,2, Color.WHITE);
        mat[0][3] = new Piece(4,"White Queen",0,3, Color.WHITE);
        mat[0][4] = new King(5,"White King",0,4, Color.WHITE);
        mat[0][5] = new Piece(6,"White Bishop",0,5, Color.WHITE);
        mat[0][6] = new Knight(7,"White Knight",0,6, Color.WHITE);
        mat[0][7] = new Piece(8,"White Rook",0,7, Color.WHITE);

        for (int j = 0; j < 8; j++) {
            mat[1][j] = new Pawn(17,"White Pawn",1,j, Color.WHITE);
        }

        // Empty squares
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j < 8; j++) {
                mat[i][j] = new EmptyPlace(0,"Empty Place",i,j, Color.NONE);
            }
        }

        // Black pawns
        for (int j = 0; j < 8; j++) {
            mat[6][j] = new Pawn(18,"Black Pawn",6,j, Color.BLACK);
        }

        // Black pieces (bottom)
        mat[7][0] = new Piece(9,"Black Rook",7,0, Color.BLACK);
        mat[7][1] = new Knight(10,"Black Knight",7,1, Color.BLACK);
        mat[7][2] = new Piece(11,"Black Bishop",7,2, Color.BLACK);
        mat[7][3] = new Piece(12,"Black Queen",7,3, Color.BLACK);
        mat[7][4] = new King(13,"Black King",7,4, Color.BLACK);
        mat[7][5] = new Piece(14,"Black Bishop",7,5, Color.BLACK);
        mat[7][6] = new Knight(15,"Black Knight",7,6, Color.BLACK);
        mat[7][7] = new Piece(16,"Black Rook",7,7, Color.BLACK);
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

    public static void printPossibleMoves(int row, int col) {
        
        System.out.println("Possible moves for piece at (" + row + "," + col + "):");
        
    }

    public static Piece getPiece(int row, int col){
        return mat[row][col];
    }


}
