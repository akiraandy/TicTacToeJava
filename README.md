# Tic Tac Toe
##### A library for creating and playing a game of Tic Tac Toe in Java.

### Setup

Download or clone repo. Build project using ```/src``` as your source folder. Import the ```tictactoe.jar``` and import classes as needed.

### Library structure:
There are 5 main classes that are used to play a game of Tic Tac Toe
### Marker
The ```Marker``` class represents the symbolic representation of a marker on a Tic Tac Toe board (i.e. "X" or "O" in a traditional game of Tic Tac Toe).

```Marker``` is an enum with three values:
```PLAYER1```
```PLAYER2```
```EMPTY```
The first two are assigned to ```Player``` objects. The 3rd is assigned to ```Space``` objects on default. For example, when a ```Board``` object is created, all ```Space``` objects will be created with a default ```EMPTY``` marker assigned to them.

#### Space
The ```Space``` class represents a cell or spot in the game board.
```Space``` has three properties, an integer that represents the space's row, an integer that represents the space's column and a marker.

```public int row, col```
```public Marker marker```

```Space``` has two construction methods:

```Space space = new Space(int row, int col);```
This creates a space with a row and column position with an empty marker as default.

```Space space = new Space(int row, int col, Player player)```
This creates a space with a row and column position and takes a Player object and assigns the player's marker to ```space```'s marker.

Space has 5 public methods:
```public Space fill(Marker marker)```
Accepts a marker i.e. ```space.fill(player1.marker)``` and assigns the foreign marker to it's own marker.

```public void Space reset()```
Sets the current space's marker to an empty marker.

```public boolean Space isEmpty()```
Returns ```true``` if space is empty, else returns ```false```.

```public boolean Space isFilled()```
Returns ```true``` if space is filled with a player marker, else returns ```false```.

```public boolean isSame(Space space)```
Compares another ```Space``` object's col and row against its own col and row to determine whether they represent the same coordinate space. Returns ```true``` if col and row match that of foreign ```space```, else returns ```false```.
#### Board
The ```Board``` class represents a board in a game of Tic Tac Toe.
```Board``` has three public properties:
```public Space[][] spaces```
```spaces``` is a 2D array of ```Space``` objects.

```public int boardSize, rowSize```
```boardSize``` represents the total number of spaces on the board (i.e. 9 on a traditional Tic Tac Toe board).
```rowSize``` represents the number of spaces in a row on the board (i.e. 3 on a traditional Tic Tac Toe board).

The following is ```Board```'s constructor:
```Board board = new Board(int boardSize)```
```Board``` can be instantiated with any size greater than 2. If any value less than 3 is used an ```InvalidBoardSizeException``` will be thrown.

```Board``` has 7 public methods:

```public void fillSapce(Space space)```
Accepts a ```Space``` fills the board with that space's marker if it is a valid space on the board (i.e. there isn't already a player marker in that spot on the board). If ```Space```'s coordinates are not within the scope of the board, it will throw a ```SpaceDoesNotExistException```.

```public void resetSpace(Space space)```
Accepts a ```Space``` object that sets the corresponding ```Space```'s marker on the board to an empty marker. If ```Space```'s coordinates are not within the scope of the board, it will throw a ```SpaceDoesNotExistException```.

```public boolean isFull()```
Returns ```true``` if all the current board's spaces are filled with player markers. Else returns ```false```.

```public boolean isEmpty()```
Returns ```true``` if all the current board's spaces are filled with ```EMPTY``` player markers. Else returns ```false```.

```public List<Space> availableSpaces()```
Returns a list of spaces on the board that are filled with ```EMPTY``` player markers.

```public Space center()```
Returns the center ```Space``` object of the board. If the total board size is not odd numbered, this method will return null.

```public List<Space> corners()```
Returns a list of the board's corner ```Spaces```.

#### Player
Player represents a player in a Tic Tac Toe game.
The following is how to construct a player:
```Player player1 = new Player(int playerNum)```
```playerNum``` can be either ```1``` or ```2```. If any other number or symbol is used a ```InvalidPlayerNumberException``` will be thrown.
```1``` will set the player's marker to ```PLAYER1``` marker enum. ```2``` will set the player's marker to ```PLAYER2``` marker enum.

```Player``` has two public methods:

```public Space takeTurn(int row, int col)```
Accepts a row and column integer. Will return a ```Space``` object with the coordinates provided and filled with the player's marker.

```public Space getBestMove(Board board)```
Accepts a ```Board``` object and returns the best move for the player given the current state of the board. If there are no available spaces on the ```Board``` the method will throw a ```SpaceDoesNotExistException```.

#### Rules
Rules represents the logic and knowledge of how and if the terminal conditions of the game are achieved.

Construction:
```Rules rules = new Rules()```

Rules has 4 public methods:

```public boolean winner(Board board)```
Returns ```true``` if there is a winner on the ```Board``` (i.e. one player's markers have filled an entire row/column/diagonal). Returns ```false``` otherwise.

```public boolean tied(Board board)```
Returns ```true``` if there is a tie on the ```Board```. (i.e. all spaces on the board have been filled but no one player has filled an entire row/colun/diagonal with their respective marker). Returns ```false``` otherwise.

```public boolean over(Board board)```
Returns ```true``` if the game is over (there is a winner or there is a tie). Returns ```false``` otherwise.

```public Marker getWinner(Board board)```
Returns the ```Marker``` of the player who has won if there is a winner on the ```Board```. If there is no winner on the ```Board``` a ```NoWinnerException``` will be thrown.

# Example

```java
Rules rules = new Rules();
Player player1 = new Player(1);
Player player2 = new Player(2);
Board board = new Board(3);

Space space = player1.takeTurn(1, 1);
board.fillSpace(space);
space = player2.takeTurn(0, 1);
board.fillSpace(space);
rules.winner(board) # false
board.fillSpace(player1.takeTurn(0, 0));
board.fillSpace(player2.takeTurn(1, 2));
board.fillSpace(player1.takeTurn(2, 2));
rules.winner(board) # true
rules.getWinner(board) # PLAYER1
```
