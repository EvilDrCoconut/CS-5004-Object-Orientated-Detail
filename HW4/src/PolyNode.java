/** The PolyNode class that holds a power and coefficient.
 */
public class PolyNode implements PolyADTNode {

  private int coefficient;
  private int power;
  private PolyADTNode next;

  /** The PolyNode constructor.
   * @param coefficient int that is the nodes coefficient.
   * @param power int that is the nodes power.
   * @param next PolyADTNode that is a PolyADTNode linked to the node.
   */
  public PolyNode(int coefficient, int power, PolyADTNode next) {
    if (power < 0) {
      throw new IllegalArgumentException("Power can't be less than zero");
    }
    this.coefficient = coefficient;
    this.power = power;
    this.next = next;
  }

  /** Method to return node's power.
   * @return the power of a node.
   */
  @Override
  public int retPower() {
    return this.power;
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
    return this.next;
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
    if (power == this.power) {
      if (this.coefficient - coefficient == 0) {
        return this.next;
      }
      return new PolyNode(this.coefficient + coefficient, power, this.next);
    } else if (power > this.power) {
      return new PolyNode(coefficient, power, this);
    } else {
      return new PolyNode(this.coefficient, this.power, this.next.addTerm(coefficient, power));
    }
  }

  /** Method to add wholes pre-made nodes to a linked list.
   * @param node a PolyADTNode used to be added to the linked list, or added to another term.
   * @return either a new updated node or a new node placed within the list.
   */
  @Override
  public PolyADTNode addTerm2(PolyADTNode node) {

    if (node.retNext() instanceof EmptyNode) {
      if (node.retPower() == power) {
        if (coefficient - node.retCoefficient() == 0) {
          return this.next;
        }
        return new PolyNode(coefficient + node.retCoefficient(), power, next);
      }
    }
    if (node.retPower() == power) {
      if (coefficient - node.retCoefficient() == 0) {
        return this.next.addTerm2(node);
      }
      return new PolyNode(coefficient + node.retCoefficient(), power,
              this.next.addTerm2(node.retNext()));
    } else if (node.retPower() > power) {
      return new PolyNode(node.retCoefficient(), node.retPower(), this.addTerm2(node.retNext()));
    } else {
      return new PolyNode(this.coefficient, this.power, this.next.addTerm2(node));
    }
  }

  /** Method to remove a node of a certain power from the list.
   * @param power int that is used to find the node of certain power.
   * @return a new updated list without the node of certain power.
   */
  @Override
  public PolyADTNode removeTerm(int power) {
    if (this.power == power) {
      return this.next;
    } else {
      this.next = this.next.removeTerm(power);
      return this;
    }
  }

  /** Method to retrieve the coefficient of a node with a certain power.
   * @param power int that tells which power of node to search for.
   * @return int that is coefficient for a power, or 0 if that node doesn't exist.
   */
  @Override
  public int getCoefficient(int power) {
    if (this.power == power) {
      return this.coefficient;
    } else if (power > this.power) {
      return 0;
    } else {
      return this.next.getCoefficient(power);
    }
  }

  /** Method to evaluate a certain x in a polynomial.
   * @param number the value x will equal.
   * @return a double that is the value of the polynomial when x is replaced with number.
   */
  @Override
  public double evaluate(double number) {
    return (this.coefficient * Math.pow(number, this.power) + this.next.evaluate(number));
  }

  /** Method to convert a polynomial linked list into a string.
   * @return a string of the polynomial linked list.
   */
  @Override
  public String toString() {
    if (power == 0) {
      if (coefficient < 0) {
        return String.format("%d", this.coefficient);
      } else {
        return String.format("+%d", this.coefficient);
      }
    }
    if (next instanceof EmptyNode) {
      if (coefficient < 0) {
        return String.format("%dx^%d", this.coefficient, this.power) + this.next.toString();
      } else {
        return String.format("+%dx^%d", this.coefficient, this.power) + this.next.toString();
      }
    }
    if (coefficient < 0) {
      return String.format("%dx^%d", this.coefficient, this.power) + " " + this.next.toString();
    } else {
      return String.format("+%dx^%d", this.coefficient, this.power) + " " + this.next.toString();
    }
  }
}