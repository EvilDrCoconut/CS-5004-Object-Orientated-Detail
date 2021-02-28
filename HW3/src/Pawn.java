/** This is the Pawn subclass.
 */
public class Pawn implements ChessPiece {

  private Color color;
  private int initialRow;
  private int initialCol;

  /** This is the constructor for pawns.
   * @param color enum color given to piece.
   * @param row   initial row given to piece.
   * @param col   initial column given to piece.
   */
  public Pawn(int row, int col, Color color) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException();
    }
    this.color = color;
    this.initialCol = col;
    this.initialRow = row;
  }

  /** Method to returns a piece's current row.
   * @return row.
   */
  @Override
  public int getRow() {
    return initialRow;
  }

  /** Method to returns a piece's current column.
   * @return column.
   */
  @Override
  public int getColumn() {
    return initialCol;
  }

  /** Method to return piece's color.
   * @return color.
   */
  @Override
  public Color getColor() {
    return color;
  }

  /** Method to see if a piece can move, then moves the piece to the position if allowed.
   * @param row row to be moved to.
   * @param col column to be moved to.
   * @return boolean if the piece can be moved.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (row < 0 || col < 0) {
      return false;
    } else if (col != initialCol) {
      return false;
    } else if (row == initialRow && col == initialCol) {
      return false;
    }
    return ((row == initialRow + 1 && Color.WHITE == color)
            || (row == initialRow - 1 && Color.BLACK == color));
  }

  /**
   * Method to see if a piece can move to another piece's tile,
   *     and then kill it if it's a different color.
   * @param piece to be killed.
   * @return boolean if piece can be killed.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (color != piece.getColor()) {
      if ((piece.getColumn() == initialCol + 1 && canMove(piece.getRow(), (piece.getColumn() - 1)))
              || (piece.getColumn() == initialCol - 1
              && canMove(piece.getRow(), (piece.getColumn() + 1)))) {
        canMove(piece.getRow(), piece.getColumn());
        piece = null;
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}

