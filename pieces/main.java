package pieces;

public class main {
    public static void main(String[] args) {
        System.out.println("Welcome to Omars chess game: ");
        

        boolean gameIsDone = false;

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
            gameIsDone = true;

        }
        

    }
}
