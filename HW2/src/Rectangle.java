import java.util.NoSuchElementException;
import static java.lang.Math.max;
import static java.lang.Math.min;


/** A Rectangle class.
 */
public class Rectangle {
  private int x;
  private int y;
  private int height;
  private int width;

  private class Point2D {
    int x;
    int y;
  }

  /** The constructor for the rectangle class.
   * @param x      int x turned in for class x.
   * @param y      int y turned in for class y.
   * @param height int height turned in for class's height.
   * @param width  int width turned in for class's width.
   */
  public Rectangle(int x, int y, int width, int height) {
    if (height < 0 || width < 0) {
      throw new IllegalArgumentException("Height or width can't be negative values");
    } else if (height == 0 || width == 0) {
      throw new IllegalArgumentException("Height or width can't be zero");
    }
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
  }

  /** A private retrieve x function.
   * @return x for retrieving private variable.
   */
  private int retX() {
    return x;
  }

  /** A private retrieve y function.
   * @return y for retrieving private variable.
   */
  private int retY() {
    return y;
  }

  /** A private retrieve width function.
   * @return width for retrieving private variable.
   */
  private int retWidth() {
    return width;
  }

  /** A private retrieve height function.
   * @return height for retrieving private variable.
   */
  private int retHeight() {
    return height;
  }

  /** A function to check if two rectangles overlap.
   * @param other rectangle input.
   * @return boolean true or false if overlapping or not.
   */
  public boolean overlap(Rectangle other) {
    int leftX = retX();
    int leftY = retY() + retHeight();
    int rightX = retX() + retWidth();
    int rightY = retY();
    int otherLeftX = other.retX();
    int otherLeftY = other.retY() + other.retHeight();
    int otherRightX = other.retX() + other.retWidth();
    int otherRightY = other.retY();

    if (leftX > otherRightX || otherLeftX > rightX) {
      return false;
    } else if (leftY < otherRightY || otherLeftY < rightY) {
      return false;
    }
    return true;
  }

  /** Function to return the rectangle of the overlapped area.
   * @param other rectangle input.
   * @return newRectangle of the overlapped sections if there is an overlap, otherwise a
   *     NoSuchElementException is thrown.
   */
  public Rectangle intersect(Rectangle other) {
    boolean overlapCheck = overlap(other);
    if (overlapCheck) {
      int x1 = retX();
      int x2 = retX() + retWidth();
      int y1 = retY();
      int y2 = retY() + retHeight();
      int x3 = other.retX();
      int x4 = other.retX() + other.retWidth();
      int y3 = other.retY();
      int y4 = other.retY() + other.retHeight();
      int newX = min(x2, x4);
      int newX2 = max(x1, x3);
      int newY = min(y2, y4);
      int newY2 = max(y1, y3);
      int newWidth = (newX - newX2);
      int newHeight = (newY - newY2);

      Rectangle newRectangle = new Rectangle(newX2, newY2, newWidth, newHeight);
      return newRectangle;
    } else {
      throw new NoSuchElementException("There is no intersect between these two rectangles.");
    }
  }

  /** Function that returns a new rectangle with an area that holds both original rectangles.
   * @param other rectangle input.
   * @return newRectangle.
   */
  public Rectangle union(Rectangle other) {
    int otherX = other.retX();
    int otherY = other.retY();
    int lowestX = min(otherX, retX());
    int lowestY = min(otherY, retY());
    int highestY = max((retY() + retHeight()), (otherY + other.retHeight()));
    int highestX = max((retX() + retWidth()), (otherX + other.retWidth()));
    int newHeight = (highestY - lowestY);
    int newWidth = (highestX - lowestX);

    Rectangle newRectangle = new Rectangle(lowestX, lowestY, newWidth, newHeight);
    return newRectangle;
  }

  /** Function to retrieve a rectangle as a string.
   * @return rectangleDescription which a string that hold the rectangles parameters.
   */
  public String toString() {
    String rectangleDescription = "x: " + retX() + " y: "
            + retY() + " w: " + retWidth() + " h: " + retHeight();
    return rectangleDescription;
  }
}
