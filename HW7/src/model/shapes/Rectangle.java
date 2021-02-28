package model.shapes;

/**
 * Class for the rectangle shape.
 */
public class Rectangle extends Shapes {

  static int rectangleCount = 0;

  /**
   * Constructor for the rectangle class.
   *
   * @param hei   double for the height.
   * @param wid   double for the width.
   * @param red   int between 0 and 255 for red color.
   * @param green int between 0 and 255 for green color.
   * @param blue  int between 0 and 255 for blue color.
   * @param x     double for x position of shape.
   * @param y     double for y position of shape.
   */
  public Rectangle(double hei, double wid, int red, int green, int blue, double x, double y) {
    super(hei, wid, red, green, blue, x, y, "Rectangle ", rectangleCount);
    rectangleCount++;
  }

}
