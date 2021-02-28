/** The ADTNode interface for both node classes.
 */
public interface PolyADTNode {
  /** Method to return node's power.
   * @return the power of a node.
   */
  int retPower();

  /** Method to return node's coefficient.
   * @return the coefficient of a node to a certain power.
   */
  int retCoefficient();

  /** Method to return the next node linked to the current node.
   * @return the next node in a link list.
   */
  PolyADTNode retNext();

  /** Method to add a new term or to an existing term.
   * @param coefficient int that adds to an existing term or is used in a new term.
   * @param power int that compares if a node with this power exists.
   * @return a new node with updated values or to be placed in the appropriate spot.
   */
  PolyADTNode addTerm(int coefficient, int power);

  /** Method to add wholes pre-made nodes to a linked list.
   * @param node a PolyADTNode used to be added to the linked list, or added to another term.
   * @return either a new updated node or a new node placed within the list.
   */
  PolyADTNode addTerm2(PolyADTNode node);

  /** Method to remove a node of a certain power from the list.
   * @param power int that is used to find the node of certain power.
   * @return a new updated list without the node of certain power.
   */
  PolyADTNode removeTerm(int power);

  /** Method to retrieve the coefficient of a node with a certain power.
   * @param power int that tells which power of node to search for.
   * @return int that is coefficient for a power, or 0 if that node doesn't exist.
   */
  int getCoefficient(int power);

  /** Method to evaluate a certain x in a polynomial.
   * @param number the value x will equal.
   * @return a double that is the value of the polynomial when x is replaced with number.
   */
  double evaluate(double number);

  /** Method to convert a polynomial linked list into a string.
   * @return a string of the polynomial linked list.
   */
  String toString();
}
