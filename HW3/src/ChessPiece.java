
/** The interface for the ChessPiece class, where the subclasses implement.
 */
public interface ChessPiece {

  /** Method for returning the row.
   * @return current row.
   */
  int getRow();

  /** Method for returning the column.
   * @return current column.
   */
  int getColumn();

  /** Method to return the color.
   * @return piece's color
   */
  Color getColor();

  /** Method to check if a piece can move.
   * @param row row to be moved to.
   * @param col column to be moved to.
   * @return boolean if piece can move.
   */
  boolean canMove(int row, int col);

  /** Method if piece can kill a piece by moving to its space.
   * @param piece other piece to be killed.
   * @return boolean if kill is successful.
   */
  boolean canKill(ChessPiece piece);

}