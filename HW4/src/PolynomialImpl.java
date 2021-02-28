/** The PolynomialImpl class used to implement methods for polynomial linked lists.
 */
public class PolynomialImpl implements Polynomial {

  private PolyADTNode head;

  /** A private constructor used to change a values type.
   * @param n PolyADTNode to be converted.
   */
  private PolynomialImpl(PolyADTNode n) {
    this.head = n;
  }

  /** A constructor used to create a new EmptyNode for base case.
   */
  public PolynomialImpl() {
    head = new EmptyNode();
  }

  /** A constructor that takes in a string and converts it to a polynomial linked list.
   * @param string string of the polynomial to be converted.
   */
  public PolynomialImpl(String string) {
    String[] list = string.split("[ +]+");
    if (list[0].isEmpty()) {
      throw new IllegalArgumentException("This is an empty polynomial.");
    }
    this.head = new EmptyNode();
    for (int i = 0; i < list.length; i++) {
      if (list[i].length() == 1 && list[i].equals("x")) {
        list[i] = "1x^1";
      } else if (list[i].length() == 2 && list[i].equals("-x")) {
        list[i] = "-1x^1";
      } else if (list[i].contains("-x")) {
        list[i] = list[i].replace("-x","x");
      }
      if (list[i].substring(1).contains("-")) {
        throw new IllegalArgumentException("Either power is less than zero or "
                + "another polynomial is attached!");
      } else if (list[i].contains("xx") || list[i].contains("^^")) {
        throw new IllegalArgumentException("There can't be two constants next to each other!");
      }
      String[] list2 = list[i].split("x");
      int[] temp = new int[2];
      if (list2.length == 1) {
        temp[1] = 0;
      }
      for (int j = 0; j < list2.length; j++) {
        String term = list2[j];
        if (term.contains("+")) {
          term = term.replace("+", "");
        } else if (term.contains("^")) {
          term = term.replace("^", "");
        }
        int newTerm = 9999999;
        try {
          newTerm = Integer.parseInt(term);
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("Can't parse.");
        }
        temp[j] = newTerm;
      }
      this.addTerm(temp[0], temp[1]);
    }
  }

  /** Method to add a new term or update a node in the linked list.
   * @param coefficient int of the coefficient to be added.
   * @param power int of the power to be search for.
   */
  @Override
  public void addTerm(int coefficient, int power) {
    if (coefficient == 0) {
      return;
    }
    head = head.addTerm(coefficient, power);
  }

  /** Method to remove a term from a polynomial linked list.
   * @param power int of the power to be searched for and removed.
   * @return a new updated list with the node of said power removed.
   */
  @Override
  public PolyADTNode removeTerm(int power) {
    if (head.retPower() == power) {
      PolyADTNode temp = head;
      head = head.retNext();
      temp.removeTerm(power);
    }
    return head.removeTerm(power);
  }

  /** Method to return the degree of a polynomial linked list.
   * @return int of the highest power in the polynomial.
   */
  @Override
  public int getDegree() {
    return head.retPower();
  }

  /** Method to retrieve the coefficient of a node of certain power.
   * @param power int that is the node of said power to be searched for.
   * @return int that is the coefficient of the node searched for.
   */
  @Override
  public int getCoefficient(int power) {
    return head.getCoefficient(power);
  }

  /** Method to evaluate a polynomial with a certain number.
   * @param number int that is the number x is to be replaced with.
   * @return int that is the polynomials value with the number entered for x.
   */
  @Override
  public double evaluate(double number) {
    return head.evaluate(number);
  }

  /** Method to add two polynomial linked list together.
   * @param head2 the other poylnomial linked list to be added.
   * @return a new polynomial linked list with the new added values of both previous linked list.
   */
  @Override
  public Polynomial add(Polynomial head2) {
    PolyADTNode head2head = ((PolynomialImpl) head2).head;
    PolyADTNode result = head.addTerm2(head2head);
    return new PolynomialImpl(result);
  }

  /** Method to return a polynomial linked list as a string.
   * @return string that is the polynomial linked list.
   */
  @Override
  public String toString() {
    String complete = toStringHelper();
    if (complete.isEmpty()) {
      return "0";
    }
    if (complete.length() == 1) {
      return complete;
    }
    if (complete.substring(0, 1).equals("+")) {
      complete = complete.substring(1);
      return complete;
    }
    return complete;
  }

  /** Method to help return head.toString before it is modified.
   * @return the unmodified polynomial string.
   */
  private String toStringHelper() {
    return head.toString();
  }
}
