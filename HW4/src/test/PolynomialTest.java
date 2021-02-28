import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** This is the JUnit test for the Polynomial Interface and classes.
 */
public class PolynomialTest {

  private Polynomial head1;
  private Polynomial head2;
  private Polynomial head3;

  @Before
  public void setUp() {

    head1 = new PolynomialImpl();
    head1.addTerm(12, 0);
    head1.addTerm(32, 1);
    head1.addTerm(7, 2);
    head1.addTerm(3, 5);

    head2 = new PolynomialImpl();
    head2.addTerm(13, 0);
    head2.addTerm(-27, 1);
    head2.addTerm(12, 2);
    head2.addTerm(-3, 3);
    head2.addTerm(6, 4);

    head3 = new PolynomialImpl("4x^5 +-17x^4 +42x^3 -3x^2 +2x^1");
  }

  /** This test shows that a new term can be a
   *     added to polynomials of both constructor starting types.
   */
  @Test
  public void testFirst() {
    head1.addTerm(4, 2);
    assertEquals("3x^5 +11x^2 +32x^1 +12", head1.toString());
    head1.addTerm(-23, 1);
    head1.addTerm(6, 3);
    head1.addTerm(4, 4);

    assertEquals(4, head1.getCoefficient(4));
    assertEquals(6, head1.getCoefficient(3));
    assertEquals(11, head1.getCoefficient(2));
    assertEquals(9, head1.getCoefficient(1));
    assertEquals(6, head1.getCoefficient(3));

    head2.addTerm(4, 4);
    head2.addTerm(-1, 3);
    head2.addTerm(7, 2);
    head2.addTerm(-5, 1);
    head2.addTerm(72, 0);

    assertEquals(10, head2.getCoefficient(4));
    assertEquals(-4, head2.getCoefficient(3));
    assertEquals(19, head2.getCoefficient(2));
    assertEquals(-32, head2.getCoefficient(1));
    assertEquals(85, head2.getCoefficient(0));

    head3.addTerm(3, 3);
    head3.addTerm(4, 7);
    head3.addTerm(1, 4);

    assertEquals(45, head3.getCoefficient(3));
    assertEquals(-16, head3.getCoefficient(4));
    assertEquals(4, head3.getCoefficient(7));

  }

  /** This test shows that when adding a new term,
   *     if an existing term's coefficient becomes 0, it is removed.
   */
  @Test
  public void testSecond() {
    head1.addTerm(-7, 2);
    head2.addTerm(3, 3);
    head3.addTerm(3, 2);

    assertEquals(0, head1.getCoefficient(2));
    assertEquals(0, head2.getCoefficient(3));
    assertEquals(0, head3.getCoefficient(2));

  }

  /** This test shows that a new node can not be made if started with a power of less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testThird() {
    head1.addTerm(32, -1);
  }

  /** This test shows that nodes from in the list, and the head, can be removed.
   */
  @Test
  public void testFourth() {
    head1.removeTerm(2);
    head2.removeTerm(3);
    head2.removeTerm(1);
    head3.removeTerm(5);
    head3.removeTerm(3);

    assertEquals(0, head1.getCoefficient(2));
    assertEquals(0, head2.getCoefficient(3));
    assertEquals(0, head2.getCoefficient(1));
    assertEquals(0, head3.getCoefficient(5));
    assertEquals(0, head3.getCoefficient(3));
  }

  /** This test shows that the degree is accurate,
   *     even when removing the old head an assigning a new head.
   */
  @Test
  public void testFifth() {
    assertEquals(5, head1.getDegree());
    assertEquals(4, head2.getDegree());
    assertEquals(5, head3.getDegree());


    head1.removeTerm(5);
    head2.removeTerm(4);
    head3.removeTerm(5);

    assertEquals(2, head1.getDegree());
    assertEquals(3, head2.getDegree());
    assertEquals(4, head3.getDegree());

  }

  /** This is a general test to show that getCoefficient works
   *     and returns 0 if no node of that power exists.
   */
  @Test
  public void testSixth() {
    assertEquals(3, head1.getCoefficient(5));
    assertEquals(7, head1.getCoefficient(2));
    assertEquals(32, head1.getCoefficient(1));
    assertEquals(12, head1.getCoefficient(0));

    assertEquals(6, head2.getCoefficient(4));
    assertEquals(-3, head2.getCoefficient(3));
    assertEquals(12, head2.getCoefficient(2));
    assertEquals(-27, head2.getCoefficient(1));
    assertEquals(13, head2.getCoefficient(0));

    assertEquals(4, head3.getCoefficient(5));
    assertEquals(-17, head3.getCoefficient(4));
    assertEquals(42, head3.getCoefficient(3));
    assertEquals(-3, head3.getCoefficient(2));
    assertEquals(2, head3.getCoefficient(1));

    assertEquals(0, head1.getCoefficient(20));

  }

  /** This test shows that polynomial linked lists can be evaluated from both constructor types.
   */
  @Test
  public void testSeventh() {

    assertEquals(1115490, head1.evaluate(13), .0001);
    assertEquals(-23256, head1.evaluate(-6), .0001);
    assertEquals(80825.03446487038, head1.evaluate(7.68), .0001);
    assertEquals(1615304, head1.evaluate(14), .0001);
    assertEquals(54, head1.evaluate(1), .0001);
    assertEquals(-16, head1.evaluate(-1), .0001);

    assertEquals(120649, head2.evaluate(12), .0001);
    assertEquals(27109, head2.evaluate(-8), .0001);
    assertEquals(722423.01278746, head2.evaluate(18.73), .0001);
    assertEquals(13, head2.evaluate(0), .0001);

    assertEquals(1612912, head3.evaluate(14), .0001);
    assertEquals(-3516, head3.evaluate(-3), .0001);
    assertEquals(32771.56879073279, head3.evaluate(6.72), .0001);

  }


  /** This test shows that newly formed polynomials can be added to other polynomials, that
   *     polynomials can be added together, and when creating another string polynomial,
   *     it can still be added to another string polynomial.
   */
  @Test
  public void testEighth() {
    PolynomialImpl poly = new PolynomialImpl();
    poly.addTerm(2, 1);
    poly.addTerm(3, 2);

    head1 = head1.add(poly);
    assertEquals("3x^5 +10x^2 +34x^1 +12", head1.toString());

    head1 = head1.add(head2);
    assertEquals("3x^5 +6x^4 -3x^3 +22x^2 +7x^1 +25", head1.toString());

    PolynomialImpl poly2 = new PolynomialImpl();
    poly2.addTerm(3, 2);
    poly2.addTerm(1, 6);
    poly2.addTerm(23, 8);

    head2 = head2.add(poly2);
    assertEquals("23x^8 +1x^6 +6x^4 -3x^3 +15x^2 -27x^1 +13", head2.toString());

    head3 = head3.add(head2);
    assertEquals("23x^8 +1x^6 +4x^5 -11x^4 +39x^3 +12x^2 -25x^1 +13", head3.toString());

    Polynomial poly3 = new PolynomialImpl("2x^3 +4x^2 -12x^1 -10");
    head3 = head3.add(poly3);
    assertEquals("23x^8 +1x^6 +4x^5 -11x^4 +41x^3 +16x^2 -37x^1 +3", head3.toString());

    Polynomial n = new PolynomialImpl("73x^197 -95x^196 +20x^191 -54x^187 +76x^178 -19x^174 "
            + "+96x^172 +41x^168 -51x^166 +94x^165 -91x^163 +53x^161 -23x^157 +87x^155 -46x^152 "
            + "-40x^151 +64x^150 +51x^149 +76x^146 +26x^145 +83x^142 +51x^141 +61x^140 -80x^133 "
            + "+98x^131 +36x^130 -14x^127 +49x^125 -74x^123 -53x^122 +33x^118 +10x^108 +47x^107 "
            + "-7x^105 -89x^101 +53x^98 -32x^95 -11x^94 +89x^91 +43x^80 +55x^76 -41x^75 -1x^72 "
            + "+41x^68 -65x^67 -51x^66 -92x^65 -55x^61 +21x^51 +10x^50 -45x^49 -41x^48 -74x^45 "
            + "-67x^44 +34x^42 +98x^41 -12x^32 -78x^31 -55x^29 -75x^28 -38x^24 -15x^23 -61x^21 "
            + "-56x^17 +74x^15 +67x^12 -47x^10 +52x^7 -9x^2");
    Polynomial n2 = new PolynomialImpl("64x^197 +43x^195 -46x^194 +26x^193 +82x^187 "
            + "-52x^179 +81x^176 +16x^174 +60x^171 +96x^168 +20x^161 -24x^158 +19x^157 -6x^153 "
            + "+93x^151 -29x^149 +97x^146 +50x^144 +88x^143 -46x^141 -39x^138 +75x^137 -88x^128 "
            + "-70x^120 +4x^112 +33x^109 -61x^107 -52x^106 -7x^105 +14x^104 -72x^95 -93x^93 "
            + "+82x^87 -33x^78 -22x^76 +21x^75 +66x^70 +51x^69 +55x^68 -84x^66 -84x^65 -16x^59 "
            + "-3x^58 -100x^56 -76x^54 -84x^53 +91x^50 +12x^43 +93x^41 +26x^40 +51x^36 -23x^33 "
            + "+52x^28 +36x^25 -85x^23 +19x^9 -12x^3 -34x^2 -50");
    n = n.add(n2);

    assertEquals(-1.1771869396623886E37, n.evaluate(-1.5), 0.001);

  }

  /** A general test to show that toString works.
   */
  @Test
  public void testNinth() {

    assertEquals("3x^5 +7x^2 +32x^1 +12", head1.toString());
    assertEquals("6x^4 -3x^3 +12x^2 -27x^1 +13", head2.toString());
    assertEquals("4x^5 -17x^4 +42x^3 -3x^2 +2x^1", head3.toString());

    PolynomialImpl poly = new PolynomialImpl();
    poly.addTerm(3, 0);
    poly.addTerm(4, 1);
    poly.addTerm(4, 3);
    poly.addTerm(6, 5);
    assertEquals("6x^5 +4x^3 +4x^1 +3", poly.toString());
  }

  /** Test to show that zero coefficient addTerms are ignored.
   */
  @Test
  public void testTenth() {
    Polynomial test2 = new PolynomialImpl();
    test2.addTerm(2,0);
    test2.addTerm(6,1);
    test2.addTerm(0,2);
    test2.addTerm(4,3);
    assertEquals("4x^3 +6x^1 +2",test2.toString());

    Polynomial test  = new PolynomialImpl("-6x^5 +4x^2 +0x^3");
    assertEquals("-6x^5 +4x^2",test.toString());
  }

  /** Test to show that polynomial can't have no spacing.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testEleventh() {
    Polynomial test = new PolynomialImpl("3x^4 +2x^4-2x^3");
  }

  /** Test to show that a zero coefficient in a string polynomial will be ignored.
   */
  @Test
  public void testTwelfth() {
    Polynomial polyTest = new PolynomialImpl("2x^3 +1x^2 +0x^1 -12 ");
    assertEquals("2x^3 +1x^2 -12", polyTest.toString());
  }

  /** Test to show a empty string will result in an ArgumentException.
   */
  @Test (expected = IllegalArgumentException.class)
   public void testThirteenth() {
    Polynomial polyTest2 = new PolynomialImpl("");
    assertEquals("", polyTest2.toString());
  }

  /** Test to show singles constants can be accepted.
   */
  @Test
  public void testFourteenth() {
    Polynomial polyTest = new PolynomialImpl("5");
    assertEquals("5", polyTest.toString());
  }

  /** Test shows that a -x is fixed to x.
   */
  @Test
  public void testFifteenth() {
    Polynomial polyTest = new PolynomialImpl("2-x^3");
    assertEquals("2x^3", polyTest.toString());
  }

  /** Test shows that both just x and -x are accounted for.
   */
  @Test
  public void testSixteenth() {
    Polynomial polyTest = new PolynomialImpl("x");
    assertEquals("1x^1", polyTest.toString());

    Polynomial polyTest2 = new PolynomialImpl("-x");
    assertEquals("-1x^1", polyTest2.toString());

  }
}