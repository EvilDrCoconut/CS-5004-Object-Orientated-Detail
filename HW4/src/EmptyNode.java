/** The EmptyNode class for base case.
 */
public class EmptyNode implements PolyADTNode {

  private int coefficient;
  private int power;

  /** The EmptyNode constructor with no parameters.
   */
  public EmptyNode() {
    this.coefficient = 0;
    this.power = -1;
    PolyADTNode next = null;
  }

  /** Method to return node's power.
   * @return the power of a node.
   */
  @Override
  public int retPower() {
    return power;
  }

  /** Method to return node's coefficient.
   * @return the coefficient of a node to a certain power.
   */
  @Override
  public int retCoefficient() {
    return coefficient;
  }

  /** Method to return the next node linked to the current node.
   * @return the next node in a link list.
   */
  public PolyADTNode retNext() {
    return null;
  }

  /** Method to add a new term or to an existing term.
   * @param coefficient int that adds to an existing term or is used in a new term.
   * @param power int that compares if a node with this power exists.
   * @return a new node with updated values or to be placed in the appropriate spot.
   */
  @Override
  public PolyADTNode addTerm(int coefficient, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power can't be less than zero");
    }
    return new PolyNode(coefficient, power, this);
  }

  /** Method to add wholes pre-made nodes to a linked list.
   * @param node a PolyADTNode used to be added to the linked list, or added to another term.
   * @return either a new updated node or a new node placed within the list.
   */
  @Override
  public PolyADTNode addTerm2(PolyADTNode node) {
    return new PolyNode(node.retCoefficient(), node.retPower(), new EmptyNode());
  }

  /** Method to remove a node of a certain power from the list.
   * @param power int that is used to find the node of certain power.
   * @return a new updated list without the node of certain power.
   */
  @Override
  public PolyADTNode removeTerm(int power) {
    return this;
  }

  /** Method to retrieve the coefficient of a node with a certain power.
   * @param power int that tells which power of node to search for.
   * @return int that is coefficient for a power, or 0 if that node doesn't exist.
   */
  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  /** Method to evaluate a certain x in a polynomial.
   * @param number the value x will equal.
   * @return a double that is the value of the polynomial when x is replaced with number.
   */
  @Override
  public double evaluate(double number) {
    return 0;
  }

  /** Method to convert a polynomial linked list into a string.
   * @return a string of the polynomial linked list.
   */
  @Override
  public String toString() {
    return "";
  }

}