package model.shapes;

/**
 * Abstract Transformation class representing the commonalities amongst the three Transformation
 * classes: Resize, Move, and ChangeColor.
 */
public class AbstractTransformation implements Transformation {
  private Shapes shape;
  private double width;
  private double height;
  private int tStart;
  private int tEnd;
  private int red;
  private int green;
  private int blue;
  private double x;
  private double y;
  private Type type;

  @Override
  public String getCurrentState() {
    return null;
  }

  @Override
  public Shapes getShape() {
    return this.shape;
  }

  @Override
  public int getStartTime() {
    return this.tStart;
  }

  @Override
  public int getEndTime() {
    return this.tEnd;
  }

  @Override
  public Type getType() {
    return this.type;
  }
}
