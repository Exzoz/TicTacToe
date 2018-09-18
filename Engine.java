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







}