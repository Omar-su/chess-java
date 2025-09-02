package pieces;

import java.util.Optional;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Welcome to Omars chess game: ");
        

        boolean gameIsDone = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameIsDone) {
            System.out.println("Here is the mat, your pieces are shown as numbers: ");
            System.out.println("""
                White pieces (top two rows):
                Rook   = 1
                Knight = 2
                Bishop = 3
                Queen  = 4
                King   = 5
                Pawn   = 6

                Black pieces (bottom two rows):
                Rook   = 7
                Knight = 8
                Bishop = 9
                Queen  = 10
                King   = 11
                Pawn   = 12
            """);

            Mat.printMat();

            System.out.println("Write which piece you want to move and I will show you which moves are possible");


            System.out.print("Enter the row of the piece you want to move: ");
            int row = scanner.nextInt();  // Reads a line of text
            System.out.print("Enter the column of the piece you want to move: ");
            int col = scanner.nextInt();  // Reads a line of text
            System.out.println("You entered: " + row + " " + col);

            Piece p = Mat.getPiece(row, col);
            if (p.color == Color.NONE) {
                System.err.println("No piece to move there!!");
                continue;
            }
            
            Optional<String> pm = p.printPossibleMoves();
            if (pm.isEmpty()) {
                System.err.println("This peace is not able to move anywhere");
                continue; 
            }

            System.out.println(pm.get());

            System.out.println("To confirm the movement write con and to change the piece selection write cha");

            String input = scanner.next();
            System.out.println("input : " + input);
            if (input.toLowerCase().equals("con")) {
                System.out.println("You decided to continue. Please choose the row and column.");
                System.out.println("Enter the row:");
                int newrow = scanner.nextInt();
                System.out.println("Enter the column:");
                int newcol = scanner.nextInt();

                if (isInside(newrow, newcol, Mat.mat.length)) {
                    Piece newPos = Mat.getPiece(newrow, newcol);
                    p.moveTo(newrow, newcol, newPos);
                }else {
                    System.err.println("Invalid move");
                }

            }

            // gameIsDone = true;

        }
        
        scanner.close();

    }

    public static boolean isInside(int r, int c, int size) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }
    
}
