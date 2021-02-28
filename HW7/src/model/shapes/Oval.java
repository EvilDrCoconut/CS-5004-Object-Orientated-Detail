package model.shapes;

/**
 * public class for the oval shape object.
 */
public class Oval extends Shapes {

  static int ovalCount = 0;

  /**
   * Constructor for the oval class.
   *
   * @param hei   double for the height.
   * @param wid   double for the width.
   * @param red   int between 0 and 255 for red color.
   * @param green int between 0 and 255 for green color.
   * @param blue  int between 0 and 255 for blue color.
   * @param x     double for x position of shape.
   * @param y     double for y position of shape.
   */
  public Oval(double hei, double wid, int red, int green, int blue, double x, double y) {
    super(hei, wid, red, green, blue, x, y, "Oval ", ovalCount);
    ovalCount++;
  }
}
