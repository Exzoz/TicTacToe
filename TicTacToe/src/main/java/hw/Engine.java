package hw;

import java.util.Scanner;

public class Engine {
    private Square[][] board;   //Board representation
    private Graphics graphics;  // Graphics module
    private String player1;     //Player 1 name
    private String player2;     //Player 2 name
    private GameStatus gameStatus; //PLAYING, X_WON, O_WON, DRAW
    private int currentPlayer;    // 1 or 2
    private int cRow, cColumn;      // current row and column

    public static Scanner input = new Scanner(System.in); // input Scanner

    public Engine() {
        board = new Square[3][3];
        graphics = new Graphics();
    }

    public void initGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = Square.EMPTY; // all squares empty
            }
        }
        gameStatus = GameStatus.PLAYING;
        currentPlayer = 1;
    }

    public void start() {
        graphics.help();
        System.out.println("Please enter first player name (X):");
        player1 = input.nextLine();
        System.out.println("Please enter second player name (O):");
        player2 = input.nextLine();
        initGame();
        // Play the game
        do {
            playerToMove(currentPlayer); // update currentRow and currentCol
            updateGame(currentPlayer, cRow, cColumn); // update currentState
            graphics.printBoard(board);
            //Print message if the game is over
            if (gameStatus == GameStatus.X_WON) {
                System.out.println(player1 + " " + "Won! Thanks for playing!");
            } else if (gameStatus == GameStatus.O_WON) {
                System.out.println(player2 + " " + "Won! Thanks for playing!");
            } else if (gameStatus == GameStatus.DRAW) {
                System.out.println("Draw!");
            }
            // Switch Player
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        } while (gameStatus == GameStatus.PLAYING); //repeat until game status is not playing
        checkForRematch();
        }

        public void checkForRematch() {
        System.out.println("Do you want to play again? Y/N");
        String answer = input.next();
        if ("Y" .equalsIgnoreCase(answer)) {
            start();
        } else {
            System.out.println("Thank you for playing! ");
        }
    }
    /**
     * Update the games current state
     */

    public void updateGame(int currentPlayer, int currentRow, int currentCol) {
        if (isWinningPlay(currentPlayer == 1 ? Square.X : Square.O, currentRow, currentCol)) { //Checks if a person won
            gameStatus = currentPlayer == 1 ? GameStatus.X_WON : GameStatus.O_WON;
        } else if (isDraw()) { //Checks if it is a draw
            gameStatus = GameStatus.DRAW;
        }
        //There is no change, game status still playing
    }

    public void playerToMove(int player) {
        boolean validInput = false; // This is for input validation
        do {
            if (player == 1) {
                System.out.println(player1 + " " + "Please enter your move (row[1-3] column[1-3]): ");
            } else {
                System.out.println(player2 + " " + "Please enter your move (row[1-3] column[1-3]): ");
            }
            int row = input.nextInt() - 1;
            int col = input.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == Square.EMPTY) {
                cRow = row;
                cColumn = col;
                board[cRow][cColumn] = player == 1 ? Square.X : Square.O;
                validInput = true; // exit while loop
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Please try again...");
            }
        } while (!validInput); // This will repeat until input is valid
    }


    /** Check if there are no more empty squares */
    public boolean isDraw() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board[row][column] == Square.EMPTY) {
                    return false; // There is an empty square, so not a draw yet
                }
            }
        }
        return true; // No empty squares, so this is a draw
    }

    public boolean isWinningPlay(Square square, int currentRow, int currentColumn) {
        return (
                board[currentRow][0] == square && board[currentRow][1] == square && board[currentRow][2] == square // Three in a row
                || board[0][currentColumn] == square && board[1][currentColumn] == square && board[2][currentColumn] == square // Three in a column
                || board[0][0] == square && board[1][1] == square && board[2][2] == square && currentRow == currentColumn // Three in diagonal
                || board[0][2] == square && board[1][1] == square && board[2][0] == square && currentRow + currentColumn == 2); //Three in diagonal



    }
}








