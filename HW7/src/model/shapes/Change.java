package model.shapes;

/** enum for state changes.
 */
public enum Change {
  move("move"),
  resize("%s changes width from %.1f to %.1f from %d to %d\n"),
  changeColor("change Color");


  private final String statement;

  /** String for what the change is.
   * @param statement
   */
  Change(String statement) {
    this.statement = statement;
  }

  /** Method to return the change.
   * @return String of the change made.
   */
  String getStatement() {
    return this.statement;
  }
}
