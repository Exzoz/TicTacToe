# Tic Tac Toe
*by Team FT*

Welcome to Team FT's Tic Tac Toe game/project for COMP-330.

## Tools and Languages used
- Game software written in Java (with alternate demo branch built in Processing)
- GitHub used for version control

## Functional Requirements
### Requirements for Minimum Viable Product
- Each bullet point contains a **Requirement** in bold, followed by an explanation of *How the software fulfills the requirement* in italics:

- **Allow 2 concurrent players simultaneously (take turns)** *Controlled by the currentPlayer variable, which toggles between first player (X) and second player (O) each time a valid player move is completed. The playerToMove method then takes this as an argument in order to prompt that player to take their turn*
- **Collect and display usernames for each player** *Immediately upon starting the game, engine.start() prompts the first, then second player for their name, which the users type into the console, these are saved as player1 and player2 variables*
- **Display a game board** *This is performed by the graphics.printBoard method, which draws a tic-tac-toe game board to the console using vertical pipe (|) and dash (-) characters, then displaying each square as filled with either a blank space, an X or an O (kept track of in the Sqare enum (EMPTY, X, O))*
- **Players take turns marking the game board with their token "x" or "o"** *The engine.playerToMove method takes the current player (1:X or 2:O) as an argument, then prompts that player to enter a column or row. The user enters their desired row and column of play, and updates the Square[][] board, which represents the board and each of its squares. By modifying the Square[][] board, we also modify the way the graphics.printBoard method draws the game board for the player, filling in the Xs and Os that have already been played*
- **Detect when one player or another reaches a victory condition as defined by the [rules of Tic Tac Toe] (https://www.exploratorium.edu/brain_explorer/tictactoe.html)** *Players taking their turn causes the updateGame method to be called, which in turn checks the boolean isWinningPlay method to determine whether the just-played token triggered a win condition. If so, the GameStatus enum is changed to X_WON or O_WON, as appropriate. By only checking the current play (by passing the currentRow and currentColumn ints from the play into the isWinningPlay method), we avoid constantly having to check the whole board for every win condition possible*
- **Detect when game board is full, without a winner declared** *Players taking their turn causes the updateGame method to be called, which in turn checks the isDraw boolean method, which performs a simple check to see if ANY game board squares are empty. If so, it returns "false," and play continues. If no more empty squares remain, the method returns "true" and the GameStatus enum is changed to DRAW*
- **Display the game status to the user at all times: whose turn it is, a scoreboard to keep track of wins, and messages letting players know about illegal moves or victories** *The console shows a constantly updated game board, prompts for the player whose turn it is to move, and console messages if players attempt an illegal move or when the game has ended (and who has won). It then asks if players wish to play again (a rematch)*
- **Board should be cleared after each game so that another game can be started** *If a player chooses to play again (rematch), the initGame method is called, which sets every square in the game board array to EMPTY*
- **User interface and game logic should be separate to the extent that one can be changed without impacting the other** *Engine and Graphics are built in totally separate classes and one could be radically changed without any need to change the other*

### Stretch / Optional Requirements
- Allow user to customize their color and token (instead of X or O player could choose their own character or image to play) *not implemented*
- Help system easily accessible from any part of the program *not implemented, although constant user move prompts and messages like "this move is not valid" should go a long way toward obviating any need for a help system*
- Detect when a game is no longer winnable, even before the game board is full (9 plays) *not implemented*

## Non-functional Requirements
- Use GitHub for source control and issue / bug tracking
