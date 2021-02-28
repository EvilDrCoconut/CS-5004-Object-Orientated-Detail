/** The Polynomial interface used by PolynomialImpl.
 */
public interface Polynomial {

  /** Method to add a new term or update a node in the linked list.
   * @param coefficient int of the coefficient to be added.
   * @param power int of the power to be search for.
   */
  void addTerm(int coefficient, int power);

  /** Method to remove a term from a polynomial linked list.
   * @param power int of the power to be searched for and removed.
   * @return a new updated list with the node of said power removed.
   */
  PolyADTNode removeTerm(int power);

  /** Method to return the degree of a polynomial linked list.
   * @return int of the highest power in the polynomial.
   */
  int getDegree();

  /** Method to retrieve the coefficient of a node of certain power.
   * @param power int that is the node of said power to be searched for.
   * @return int that is the coefficient of the node searched for.
   */
  int getCoefficient(int power);

  /** Method to evaluate a polynomial with a certain number.
   * @param number int that is the number x is to be replaced with.
   * @return int that is the polynomials value with the number entered for x.
   */
  double evaluate(double number);

  /** Method to add two polynomial linked list together.
   * @param head2 the other poylnomial linked list to be added.
   * @return a new polynomial linked list with the new added values of both previous linked list.
   */
  Polynomial add(Polynomial head2);

  /** Method to return a polynomial linked list as a string.
   * @return string that is the polynomial linked list.
   */
  String toString();

}