/** This is the Knight subclass.
 */
public class Knight implements ChessPiece {

  private Color color;
  private int initialRow;
  private int initialCol;

  /** Constructor for the knight subclass.
   * @param color is set to the pieces set color from enum colors.
   * @param row   is set to pieces starting row.
   * @param col   is set to pieces starting column.
   */
  public Knight(int row, int col, Color color) {
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
   * @param row row to move to.
   * @param col column to move to.
   * @return boolean if able to move.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (row < 0 || col < 0) {
      return false;
    }
    if (row == initialRow && col == initialCol) {
      return false;
    }
    if (row == initialRow + 2 || row == initialRow - 2) {
      return (col == initialCol + 1 || col == initialCol - 1);
    } else if (col == initialCol + 2 || col == initialCol - 2) {
      return (row == initialRow + 1 || row == initialRow - 1);
    }
    return false;
  }

  /** Method to see if a piece can move to another piece's tile,
   *     and then kill it if it's a different color.
   * @param piece other piece to be killed
   * @return boolean if it can kill
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (color != piece.getColor()) {
      if (canMove(piece.getRow(), piece.getColumn())) {
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