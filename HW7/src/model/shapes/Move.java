package model.shapes;

/**
 * A class of type model.shapes.Transformation to move a shape object to a new position.
 */
public class Move extends model.shapes.AbstractTransformation {
  private Shapes shape;
  private double x;
  private double y;
  private int tStart;
  private int tEnd;
  protected Type type;

  /**
   * Constructor for the Move class.
   *
   * @param shape  shape that is being transformed
   * @param x      destination x-coordinate for shape to be moved to
   * @param y      destination y-coordinate for shape to be moved to
   * @param tStart start time of transformation
   * @param tEnd   end time of transformation
   */
  public Move(Shapes shape, double x, double y, int tStart, int tEnd) {
    if (tStart < 0 || tEnd < 0) {
      throw new IllegalArgumentException("Time cannot be negative!");
    }
    if (tStart > tEnd) {
      throw new IllegalArgumentException("Start time cannot be after end time!");
    }
    this.shape = shape;
    this.x = x;
    this.y = y;
    this.tStart = tStart;
    this.tEnd = tEnd;
    this.type = Type.MOVE;
  }

  @Override
  public String getCurrentState() {
    return String.format("%s moves from (%.1f, %.1f) to (%.1f, %.1f) from time %d to %d.\n",
            this.shape.retID(), this.shape.retX(), this.shape.retY(), this.x, this.y, this.tStart,
            this.tEnd);

  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public Type getType() {
    return this.type;
  }
}
