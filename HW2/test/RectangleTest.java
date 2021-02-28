import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/** A Junit test for the Rectangles class.
 */

public class RectangleTest {

  private Rectangle rectangle1;
  private Rectangle rectangle2;
  private Rectangle rectangle3;

  @Before
  public void setUp() {
    rectangle1 = new Rectangle(2, 2, 3, 4);
    rectangle2 = new Rectangle(-1, -3, 4, 6);
    rectangle3 = new Rectangle(0, -3, 8, 4);
  }

  @Test
  public void testFirst() {
    Rectangle rectangle = new Rectangle(2, 4, 5, 6);
    assertEquals("x: 2 y: 4 w: 5 h: 6", rectangle.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecond() {
    Rectangle rectangle = new Rectangle(2, 3, -4, -5);
    assertEquals("x: 2.0 y: 3.0 w: -5.0 h: -4.0", rectangle.toString());
  }

  @Test
  public void testThird() {
    assertEquals("x: 2 y: 2 w: 3 h: 4", rectangle1.toString());
    assertEquals("x: -1 y: -3 w: 4 h: 6", rectangle2.toString());
    assertEquals("x: 0 y: -3 w: 8 h: 4", rectangle3.toString());
  }

  @Test
  public void testFourth() {
    Rectangle extraRectangle = new Rectangle(-4, 5, 4, 3);
    assertEquals(true, rectangle1.overlap(rectangle2));
    assertEquals(true, rectangle2.overlap(rectangle3));
    assertEquals(false, rectangle3.overlap(rectangle1));
    assertEquals(false, extraRectangle.overlap(rectangle1));

  }

  @Test
  public void testFifth() {
    Rectangle extraRectangle = new Rectangle(0, 0, 4, 4);
    assertEquals("x: 2 y: 2 w: 1 h: 1", rectangle1.intersect(rectangle2).toString());
    assertEquals("x: 0 y: -3 w: 3 h: 4", rectangle2.intersect(rectangle3).toString());
    assertEquals("x: 2 y: 2 w: 2 h: 2", rectangle1.intersect(extraRectangle).toString());
    assertEquals("x: 0 y: 0 w: 3 h: 3", rectangle2.intersect(extraRectangle).toString());
    assertEquals("x: 0 y: 0 w: 4 h: 1", rectangle3.intersect(extraRectangle).toString());
  }

  @Test(expected = NoSuchElementException.class)
  public void testSixth() {
    Rectangle extraRectangle = new Rectangle(-4, 5, 4, 3);
    assertEquals("There is no intersect between these two rectangles.",
            rectangle1.intersect(extraRectangle));
    assertEquals("x: There is no intersect between these two rectangles.",
            rectangle3.intersect(rectangle1).toString());
  }


  @Test
  public void testSeventh() {
    Rectangle otherRectangle = new Rectangle(-4, 5, 4, 3);
    assertEquals("x: -1 y: -3 w: 6 h: 9", rectangle1.union(rectangle2).toString());
    assertEquals("x: -1 y: -3 w: 9 h: 6", rectangle2.union(rectangle3).toString());
    assertEquals("x: 0 y: -3 w: 8 h: 9", rectangle3.union(rectangle1).toString());
    assertEquals("x: -4 y: -3 w: 12 h: 11", rectangle3.union(otherRectangle).toString());
  }



  @Test(expected = IllegalArgumentException.class)
  public void testNinth() {
    Rectangle extraRectangle;
    assertEquals("Height or width cannot be zero value, that does not form a rectangle",
            extraRectangle = new Rectangle(1, 2, 0, 0));
  }

}