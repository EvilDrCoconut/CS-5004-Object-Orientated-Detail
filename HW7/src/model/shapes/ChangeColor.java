package model.shapes;

/**
 * A class of type model.shapes.Transformation to change the color of a model.shapes.Shape object.
 */
public class ChangeColor extends model.shapes.AbstractTransformation {
  private Shapes shape;
  private int red;
  private int green;
  private int blue;
  private int tStart;
  private int tEnd;
  protected Type type;

  /**
   * Constructor for the ChangeColor class.
   *
   * @param shape  model.shapes.Shape class that is being recolored
   * @param red    degree of red in RGB scale
   * @param green  degree of green in RGB scale
   * @param blue   degree of blue in RGB scale
   * @param tStart start time of transformation
   * @param tEnd   end time of transformation
   */
  public ChangeColor(Shapes shape, int red, int green, int blue, int tStart, int tEnd) {
    if (green > 255 || green < 0 || red > 255 || red < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Red, blue, or green color index must be between 0 and "
              + "255!");
    }
    if (tStart < 0 || tEnd < 0) {
      throw new IllegalArgumentException("Time cannot be negative!");
    }
    if (tStart > tEnd) {
      throw new IllegalArgumentException("Start time cannot be after end time!");
    }
    this.shape = shape;
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.tStart = tStart;
    this.tEnd = tEnd;
    this.type = Type.CHANGECOLOR;

  }

  @Override
  public String getCurrentState() {
    return String.format("%s moves changes color from (%d, %d, %d) to (%d, %d, %d) from time %d "
                    + "to %d.\n", this.shape.retID(), this.shape.retColor().getRed(),
            this.shape.retColor().getGreen(), this.shape.retColor().getBlue(), red,
            green, blue, this.tStart,
            this.tEnd);

  }

  public int getRed() {
    return this.red;
  }

  public int getGreen() {
    return this.green;
  }

  public int getBlue() {
    return this.blue;
  }

  public Type getType() {
    return this.type;
  }
}
