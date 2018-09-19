import hw.GameStatus;

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
        System.out.println("Please enter second payer name (O):");
        player2 = input.nextLine();
        initGame();
        // Play the game
        do {
            playerToMove(currentPlayer); // update currentRow and currentCol
            updateGame(currentPlayer, cRow, cColumn); // update currentState
            graphics.printBoard(board);
            //Print message if the game is over
            if (gameStatus == GameStatus.X_WON) {
                System.out.println(player1 + "Won!");
            } else if (gameStatus == GameStatus.O_WON) {
                System.out.println(player2 + "Won!");
            } else if (gameStatus == GameStatus.DRAW) {
                System.out.println("Draw!");
            }
            // Switch Player
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        } while (gameStatus == GameStatus.PLAYING); //repeat until
        }
    }








