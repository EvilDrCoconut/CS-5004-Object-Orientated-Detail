package cs5004.marblesolitaire.model;


/**
 * Class for the MarbleSolitaireModelImpl.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  private int armThickness;
  private String[][] board;
  int startingRow;
  int startingCol;

  /**
   * Constructor for standard board.
   */
  public MarbleSolitaireModelImpl() {
    this.armThickness = 3;
    this.board = new String[armThickness * 2 + 1][armThickness * 2 + 1];
    this.startingRow = 3;
    this.startingCol = 3;

    for (int i = 0; i < 2; i++) {
      int k;
      for (k = 0; k < board.length; k++) {
        if (k < 2 || k > 1 + armThickness) {
          board[i][k] = " ";
        } else {
          board[i][k] = "O";
        }
      }
    }
    for (int i = 2; i < 2 + armThickness; i++) {
      int k;
      for (k = 0; k < board.length; k++) {
        board[i][k] = "O";
      }
    }
    for (int i = 2 + armThickness; i < armThickness + 4; i++) {
      int k;
      for (k = 0; k < board.length; k++) {
        if (k < 2 || k > 1 + armThickness) {
          board[i][k] = " ";
        } else {
          board[i][k] = "O";
        }
      }
    }
    board[startingRow][startingCol] = "_";
  }

  /**
   * Constructor for standard size board with custom starting point.
   *
   * @param sRow row of starting position.
   * @param sCol column of starting position.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this.armThickness = 3;
    this.board = new String[2 * armThickness + 1][armThickness * 2 + 1];
    this.startingRow = sRow;
    this.startingCol = sCol;

    for (int i = 0; i < 2; i++) {
      int k;
      for (k = 0; k < board.length; k++) {
        if (k < 2 || k > 1 + armThickness) {
          board[i][k] = " ";
        } else {
          board[i][k] = "O";
        }
      }
    }
    for (int i = 2; i < 2 + armThickness; i++) {
      int k;
      for (k = 0; k < board.length; k++) {
        board[i][k] = "O";
      }
    }
    for (int i = 2 + armThickness; i < armThickness + 4; i++) {
      int k;
      for (k = 0; k < board.length; k++) {
        if (k < 2 || k > 1 + armThickness) {
          board[i][k] = " ";
        } else {
          board[i][k] = "O";
        }
      }
    }
    if (!board[startingRow][startingCol].equals("O")) {
      throw new IllegalArgumentException("Starting point must be a position on the board.");
    }
    board[startingRow][startingCol] = "_";

  }

  /**
   * Constructor for custom size board, with start in center.
   *
   * @param armThick int for size of board.
   */
  public MarbleSolitaireModelImpl(int armThick) {
    if (armThick < 0 || (armThick % 2) == 0) {
      throw new IllegalArgumentException("Arm thickness must be a positive, odd number.");
    }
    this.armThickness = armThick;
    this.board = new String[armThickness * 3 - 2][armThickness * 3 - 2];
    int helperInt = (int) Math.ceil(armThickness / 2);
    this.startingRow = armThickness - 1 + helperInt;
    this.startingCol = armThickness - 1 + helperInt;

    for (int i = 0; i < board.length; i++) {
      if (i < armThickness - 1 || i > board.length - armThickness) {
        for (int k = 0; k < board.length; k++) {
          if (k < armThickness - 1 || k > board.length - armThickness) {
            board[i][k] = " ";
          } else {
            board[i][k] = "O";
          }
        }
      } else {
        for (int k = 0; k < board.length; k++) {
          board[i][k] = "O";
        }
      }
    }

    board[startingRow][startingCol] = "_";

  }

  /**
   * Constructor for board of custom size and starting position.
   *
   * @param armThick int of size of arms on board.
   * @param sRow     int of the row for starting position.
   * @param sCol     int of the column for starting position.
   */
  public MarbleSolitaireModelImpl(int armThick, int sRow, int sCol) {
    if (armThick < 0 || (armThick % 2) == 0) {
      throw new IllegalArgumentException("Arm thickness must be a positive, odd number.");
    }
    this.armThickness = armThick;
    this.board = new String[armThickness * 3 - 2][armThickness * 3 - 2];
    this.startingRow = sRow;
    this.startingCol = sCol;

    for (int i = 0; i < board.length; i++) {
      if (i < armThickness - 1 || i > board.length - armThickness) {
        for (int k = 0; k < board.length; k++) {
          if (k < armThickness - 1 || k > board.length - armThickness) {
            board[i][k] = " ";
          } else {
            board[i][k] = "O";
          }
        }
      } else {
        for (int k = 0; k < board.length; k++) {
          board[i][k] = "O";
        }
      }
    }
    if (!board[startingRow][startingCol].equals("O")) {
      throw new IllegalArgumentException("Starting point must be a position on the board.");
    }
    board[startingRow][startingCol] = "_";

  }

  /**
   * Method for player to move marble piece.
   *
   * @param fromRow the row number of the position to be moved from. (starts at 0)
   * @param fromCol the column number of the position to be moved from. (starts at 0)
   * @param toRow   the row number of the position to be moved to. (starts at 0)
   * @param toCol   the column number of the position to be moved to. (starts at 0)
   * @throws IllegalArgumentException if move is invalid.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (toRow > board.length - 1 || toRow < 0 || toCol > board.length - 1 || toCol < 0) {
      throw new IllegalArgumentException("Not a valid move.");
    }
    if (!board[fromRow][fromCol].equals("O") || !board[toRow][toCol].equals("_")) {
      throw new IllegalArgumentException("Not a valid move.");
    } else if ((Math.abs(fromRow - toRow) == 2 && fromCol - toCol == 0) && (board[fromRow
            + ((toRow - fromRow) / 2)][toCol].equals("O"))) {
      board[fromRow][fromCol] = "_";
      board[fromRow + ((toRow - fromRow) / 2)][toCol] = "_";
      board[toRow][toCol] = "O";
    } else if ((Math.abs(fromCol - toCol) == 2 && fromRow - toRow == 0) && (board[toRow][fromCol
            + ((toCol - fromCol) / 2)].equals("O"))) {
      board[fromRow][fromCol] = "_";
      board[toRow][fromCol + ((toCol - fromCol) / 2)] = "_";
      board[toRow][toCol] = "O";
    } else {
      throw new IllegalArgumentException("Not a valid move.");
    }
    if (isGameOver()) {
      System.out.println(("Game Over! Score: ") + getScore() + "\n");
    }
  }

  /**
   * Method to check if any moves are left on board.
   *
   * @return boolean if moves are left.
   */
  @Override
  public boolean isGameOver() {
    if (getScore() == 1) {
      return true;
    }
    for (int i = 0; i < board.length - 1; i++) {
      int k;
      if (i < 2) {
        for (k = 0; k < board.length - 1; k++) {
          if (k < 2) {
            if ((board[i + 1][k].equals("O") && board[i + 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i][k + 1].equals("O")
                    && board[i][k + 2].equals("_") && board[i][k].equals("O"))) {
              return false;
            }
          } else if (k >= board.length - 1) {
            if ((board[i + 1][k].equals("O") && board[i + 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i][k - 1].equals("O")
                    && board[i][k - 2].equals("_") && board[i][k].equals("O"))) {
              return false;
            }
          } else {
            if ((board[i + 1][k].equals("O") && board[i + 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i][k + 1].equals("O")
                    && board[i][k + 2].equals("_") && board[i][k].equals("O"))
                    || (board[i][k - 1].equals("O") && board[i][k - 2].equals("_")
                    && board[i][k].equals("O"))) {
              return false;
            }
          }
        }
      } else if (i > board.length - 3) {
        for (k = 0; k < board.length - 1; k++) {
          if (k < 2) {
            if ((board[i - 1][k].equals("O") && board[i - 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i][k + 1].equals("O")
                    && board[i][k + 2].equals("_") && board[i][k].equals("O"))) {
              return false;
            }
          } else if (k >= board.length - 1) {
            if ((board[i - 1][k].equals("O") && board[i - 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i][k - 1].equals("O")
                    && board[i][k - 2].equals("_") && board[i][k].equals("O"))) {
              return false;
            }
          } else {
            if ((board[i - 1][k].equals("O") && board[i - 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i][k + 1].equals("O")
                    && board[i][k + 2].equals("_") && board[i][k].equals("O"))
                    || (board[i][k - 1].equals("O") && board[i][k - 2].equals("_")
                    && board[i][k].equals("O"))) {
              return false;
            }
          }
        }
      } else {

        for (k = 0; k < board.length - 1; k++) {
          if (k < 2) {
            if ((board[i + 1][k].equals("O") && board[i + 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i - 1][k].equals("O")
                    && board[i - 2][k].equals("_") && board[i][k].equals("O"))
                    || (board[i][k + 1].equals("O") && board[i][k + 2].equals("_"))
                    && board[i][k].equals("O")) {
              return false;
            }
          } else if (k > board.length - 3) {
            if ((board[i + 1][k].equals("O") && board[i + 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i - 1][k].equals("O")
                    && board[i - 2][k].equals("_") && board[i][k].equals("O"))
                    || (board[i][k - 1].equals("O") && board[i][k - 2].equals("_")
                    && board[i][k].equals("O"))) {
              return false;
            }
          } else {
            if ((board[i + 1][k].equals("O") && board[i + 2][k].equals("_")
                    && board[i][k].equals("O")) || (board[i - 1][k].equals("O")
                    && board[i - 2][k].equals("_") && board[i][k].equals("O"))
                    || (board[i][k + 1].equals("O") && board[i][k + 2].equals("_")
                    && board[i][k].equals("O")) || (board[i][k - 1].equals("O")
                    && board[i][k - 2].equals("_") && board[i][k].equals("O"))) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * Method to give a string of the current game.
   *
   * @return String of the current game matrix.
   */
  @Override
  public String getGameState() {
    StringBuilder newBoard = new StringBuilder();
    StringBuilder helper;
    for (int i = 0; i <= board.length - 1; i++) {
      helper = new StringBuilder();
      if (i > armThickness - 2 && i < armThickness - 1 + armThickness) {
        for (int k = 0; k <= board.length - 1; k++) {
          if (k == board.length - 1) {
            helper.append(board[i][k]).append("\n");
          } else {
            helper.append(board[i][k]).append(" ");
          }
        }
      } else {
        for (int k = 0; k <= armThickness - 1 + armThickness; k++) {
          if (k == armThickness - 1 + armThickness) {
            helper.append(board[i][k]).append("\n");
            k = board.length;
          } else {
            helper.append(board[i][k]).append(" ");
          }
        }
      }
      if (i == board.length - 1) {
        newBoard.append(helper.toString().stripTrailing());
      } else {
        newBoard.append(helper.toString().stripTrailing()).append("\n");
      }
    }

    return newBoard.toString();
  }

  /**
   * Method to return number of marbles still on the board.
   *
   * @return int of marbles left.
   */
  @Override
  public int getScore() {
    int score = 0;

    for (int i = 0; i < board.length; i++) {
      int k;
      for (k = 0; k < board.length; k++) {
        if (board[i][k].equals("O")) {
          score++;
        }
      }
    }
    return score;
  }
}
