package shape;

import java.awt.Color;

/**
 * Abstract class for all model.shapes.
 */
public abstract class Shapes {

  private double radius;
  private double height;
  private double width;
  private Color color;
  private double x;
  private double y;
  private String id;


  /**
   * Constructor for the model.shapes using radius.
   * @param radius double for radius of the object.
   * @param red    int between 0 and 255 for red color.
   * @param green  int between 0 and 255 for green color.
   * @param blue   int between 0 and 255 for blue color.
   * @param x      double for x position of shape.
   * @param y      double for y position of shape.
   */
  public Shapes(double radius, int red, int green, int blue, double x, double y) {
    if (green > 255 || green < 0 || red > 255 || red < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Red, blue, or green color index must be between 0 and 255!");
    } else if (radius < 0) {
      throw new IllegalArgumentException("model.shapes.Shape can't have a negative radius!");
    }
    this.radius = radius;
    this.color = new Color(red, green, blue);
    this.x = x;
    this.y = y;
  }

  /**
   * Constructor for the model.shapes using width and height.
   * @param hei   double for the height.
   * @param wid   double for the width.
   * @param red   int between 0 and 255 for red color.
   * @param green int between 0 and 255 for green color.
   * @param blue  int between 0 and 255 for blue color.
   * @param x     double for x position of shape.
   * @param y     double for y position of shape.
   */
  public Shapes(double hei, double wid, int red, int green, int blue, double x, double y, String id, int count) {
    if (green > 255 || green < 0 || red > 255 || red < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Red, blue, or green color index must be between 0 and 255!");
    } else if (hei < 0 || wid < 0) {
      throw new IllegalArgumentException("model.shapes.Shape can't have a negative height or width!");
    }
    this.width = wid;
    this.height = hei;
    this.color = new Color(red, green, blue);
    this.x = x;
    this.y = y;
    count++;
    this.id = id + count;
  }

  /**
   * Method to return the model.shapes personal id.
   * @return String of object's id.
   */
  public String retID() {
    return this.id;
  }

  /**
   * Method to return shape's height.
   * @return double of the model.shapes current height.
   */
  public double retHeight() {
    return this.height;
  }

  /**
   * Method to return the shape's width.
   * @return double of the shape's current width.
   */
  public double retWidth() {
    return this.width;
  }

  /**
   * Method to return the shape's radius.
   * @return double of the shape's current radius.
   */
  public double retRadius() {
    return this.radius;
  }

  /**
   * Method to return the shape's x coordinate.
   * @return double of the shape's current x coordinate.
   */
  public double retX() {
    return this.x;
  }

  /**
   * Method to return the shape's y coordinate.
   * @return double of the shape's current y coordinate.
   */
  public double retY() {
    return this.y;
  }

  /**
   * Method to return a shape's color.
   * @return the actually color of the shape. Use built in get method to retrieve rgb values.
   */
  public Color retColor() {
    return this.color;
  }

  /**
   * Method to have an object move to new location.
   * @param x      double of what x shape is moving to.
   * @param y      double of what y shape is moving to.
   * @param tStart starting time of move.
   * @param tEnd   ending time of move.
   */
  public void move(double x, double y, int tStart, int tEnd) {
    int timeHelper = tEnd - tStart;
    double xDiff = (x - this.x) / timeHelper;
    double yDiff = (y - this.y) / timeHelper;

    for (int i = 0; i < timeHelper; i++) {
      this.x = this.x + xDiff;
      this.y = this.y + yDiff;
    }
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
    if (green > 255 || green < 0 || red > 255 || red < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Red, blue, or green color index must be between 0 and 255!");
    } else if (tStart > tEnd) {
      throw new IllegalArgumentException("Start time can't be greater than end time!");
    }
    int timeHelper = tEnd - tStart;
    int redDiff = (red - this.color.getRed()) / timeHelper;
    int greenDiff = (green - this.color.getGreen()) / timeHelper;
    int blueDiff = (blue - this.color.getBlue()) / timeHelper;

    for (int i = 0; i < timeHelper; i++) {
      this.color = new Color(this.color.getRed() + redDiff, this.color.getGreen() + greenDiff, this.color.getBlue() + blueDiff);
    }

  }

  /**
   * Method to resize model.shapes with radius.
   * @param radiusChange double of the shape's new radius.
   * @param tStart       int of the time change begins.
   * @param tEnd         inf of the time change ends.
   */
  public void resize(double radiusChange, int tStart, int tEnd) {
    if (radiusChange < 0) {
      throw new IllegalArgumentException("Radius can't be negative!");
    } else if (tStart > tEnd) {
      throw new IllegalArgumentException("Start time can't be greater than end time!");
    }
    int timeHelper = tEnd - tStart;

    double radDiff = (radiusChange - radius) / timeHelper;

    for (int i = 0; i < timeHelper; i++) {
      this.radius = this.radius + radDiff;
    }
  }

  /**
   * Method to resize model.shapes with width and height.
   * @param heiChange double of the shape's new height.
   * @param widChange double of the shape's new width.
   * @param tStart    int of the time change begins.
   * @param tEnd      inf of the time change ends.
   */
  public void resize(double heiChange, double widChange, int tStart, int tEnd) {
    if (heiChange < 0 || widChange < 0) {
      throw new IllegalArgumentException("model.shapes.Shape can't have a negative height or width!");
    } else if (tStart > tEnd) {
      throw new IllegalArgumentException("Start time can't be greater than end time!");
    }
    int timeHelper = tEnd - tStart;
    double heiDiff = (heiChange - this.height) / timeHelper;
    double widDiff = (widChange - this.width) / timeHelper;

    for (int i = 0; i < timeHelper; i++) {
      this.height = this.height + heiDiff;
      this.width = this.width + widDiff;
    }
  }

}
