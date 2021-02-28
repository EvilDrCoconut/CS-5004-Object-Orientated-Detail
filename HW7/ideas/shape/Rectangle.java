package shape;

/**
 * Class for the rectangle shape.
 */
public class Rectangle extends Shapes {

  static int rectangleCount = 0;

  /**
   * Constructor for the rectangle class.
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

  /**
   * Method to return the model.shapes personal id.
   * @return String of object's id.
   */
  public String retID() {
    return super.retID();
  }

  /**
   * Method to have an object move to new location.
   * @param x      double of what x shape is moving to.
   * @param y      double of what y shape is moving to.
   * @param tStart starting time of move.
   * @param tEnd   ending time of move.
   */
  public void move(double x, double y, int tStart, int tEnd) {
    super.move(x, y, tStart, tEnd);
  }

  /**
   * Method to change the color of the shape on a RGB scale.
   * @param red    int between 0 and 255 for red coloring change.
   * @param green  int between 0 and 255 for green coloring change.
   * @param blue   int between 0 and 255 for blue coloring change.
   * @param tStart int of the time change starts.
   * @param tEnd   int of the time change ends.
   */
  public void changeColor(int red, int green, int blue, int tStart, int tEnd) {
    super.changeColor(red, green, blue, tStart, tEnd);
  }

  /**
   * Method to resize shape.
   * @param heiChange double of the shape's new height.
   * @param widChange double of the shape's new width.
   * @param tStart    int of the time change begins.
   * @param tEnd      inf of the time change ends.
   */
  public void resize(double heiChange, double widChange, int tStart, int tEnd) {
    super.resize(heiChange, widChange, tStart, tEnd);
  }

}
