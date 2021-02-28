package shape;// class for future controller, ignore this, didn't want to throw away good code

public class futureController {


  /**
   * Method to have an object move to new location.
   *
   * @param x      double of what x shape is moving to.
   * @param y      double of what y shape is moving to.
   * @param tStart starting time of move.
   * @param tEnd   ending time of move.
   */
//  public void move(double x, double y, int tStart, int tEnd) {
//    int timeHelper = tEnd - tStart;
//    double xDiff = (x - this.x) / timeHelper;
//    double yDiff = (y - this.y) / timeHelper;

//    for (int i = 0; i < timeHelper; i++) {
//      this.x = this.x + xDiff;
//      this.y = this.y + yDiff;
//    }
//  }

  /**
   * Method to change the color of the shape on a RGB scale.
   *
   * @param red    int between 0 and 255 for red coloring change.
   * @param green  int between 0 and 255 for green coloring change.
   * @param blue   int between 0 and 255 for blue coloring change.
   * @param tStart int of the time change starts.
   * @param tEnd   int of the time change ends.
   */
//  public void changeColor(int red, int green, int blue, int tStart, int tEnd) {
//    if (green > 255 || green < 0 || red > 255 || red < 0 || blue > 255 || blue < 0) {
//      throw new IllegalArgumentException("Red, blue, or green color index must be between 0 and 255!");
//    } else if (tStart > tEnd) {
//      throw new IllegalArgumentException("Start time can't be greater than end time!");
//    }
//    int timeHelper = tEnd - tStart;
//   int redDiff = (red - this.color.getRed()) / timeHelper;
//    int greenDiff = (green - this.color.getGreen()) / timeHelper;
//    int blueDiff = (blue - this.color.getBlue()) / timeHelper;

//    for (int i = 0; i < timeHelper; i++) {
//      this.color = new Color(this.color.getRed() + redDiff, this.color.getGreen() + greenDiff, this.color.getBlue() + blueDiff);
//    }

//  }

  /**
   * Method to resize model.shapes with radius.
   *
   * @param radiusChange double of the shape's new radius.
   * @param tStart       int of the time change begins.
   * @param tEnd         inf of the time change ends.
   */
//  public void resize(double radiusChange, int tStart, int tEnd) {
//    if (radiusChange < 0) {
//      throw new IllegalArgumentException("Radius can't be negative!");
//    } else if (tStart > tEnd) {
//      throw new IllegalArgumentException("Start time can't be greater than end time!");
//    }
//    int timeHelper = tEnd - tStart;

//    double radDiff = (radiusChange - radius) / timeHelper;

//    for (int i = 0; i < timeHelper; i++) {
//      this.radius = this.radius + radDiff;
//    }
//  }

  /**
   * Method to resize model.shapes with width and height.
   *
   * @param heiChange double of the shape's new height.
   * @param widChange double of the shape's new width.
   * @param tStart    int of the time change begins.
   * @param tEnd      inf of the time change ends.
   */
//  public void resize(double heiChange, double widChange, int tStart, int tEnd) {
//    if (heiChange < 0 || widChange < 0) {
//      throw new IllegalArgumentException("model.shapes.Shape can't have a negative height or width!");
//    } else if (tStart > tEnd) {
//      throw new IllegalArgumentException("Start time can't be greater than end time!");
//    }
//    int timeHelper = tEnd - tStart;
//    double heiDiff = (heiChange - this.height) / timeHelper;
//    double widDiff = (widChange - this.width) / timeHelper;

//    for (int i = 0; i < timeHelper; i++) {
//      this.height = this.height + heiDiff;
//      this.width = this.width + widDiff;
//    }
//  }


}
