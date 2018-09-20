package hw;

public class Graphics {
    public void help() {
        System.out.println("Welcome to TicTacToe");
        System.out.println("Rules of the game: https://www.exploratorium.edu/brain_explorer/tictactoe.html");
        System.out.println("Player plays his move by typing row and column of play");
    }

    /** Print the game board */
    public void printBoard(Square[][] board) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                printSquare(board[row][col]); //Prints squares
                if (col != 2) {
                    System.out.print("|"); // Prints vertical lines
                }
            }
            System.out.println();
            if (row != 2) {
                System.out.println("-----------"); // Prints horizontal lines
            }
        }
        System.out.println();
    }


    /** Print single square content */
    public void printSquare(Square square) {
        switch (square) {
            case EMPTY:
                System.out.print("  ");
                break;
            case X:
                System.out.print(" X ");
                break;
            case O:
                System.out.print(" O ");
                break;
        }
    }

}
