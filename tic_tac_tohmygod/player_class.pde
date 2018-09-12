class Player {
  int victories = 0;
  String playerName;
  boolean isHuman;
  color playerColor;
  int playerToken;
  
  Player(boolean human_){
    isHuman = human_;
    playerName = "playername";
    playerToken = 1;
  }
  
  void takeTurn(){ //start keeping track of and drawing which square the player has selected. listen for SPACE to confirm player square choice
     gameBoard.squareSelector();
     this.turnPreviewer();
  }
    
    //shows a semi-transparent token to preview which square the player has selected
  void turnPreviewer(){
    fill(255,150);
    rectMode(CENTER);
    int tempnum = gameBoard.getHighlightedSquare();
    rect(width*gameBoard.squareXXs[tempnum],height*gameBoard.squareYYs[tempnum], width*.2, height*.2);
    println(tempnum+", "+gameBoard.squareXXs[tempnum]+", "+gameBoard.squareYYs[tempnum]);
  } //end turnpreviewer
    
  
  void setPlayerName(String name_){
    playerName = name_;
  } //end set player name 
  
  void setPlayerColor (color col_){
    playerColor = col_;
  } // end set player color
  
  void setPlayerToken (int token_){
    playerToken = token_;
  } //end set player token
} //end Player class