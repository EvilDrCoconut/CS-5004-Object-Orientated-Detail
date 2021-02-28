package model.shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class the employs an array list to house Transformations of model.shapes.Shape objects. Included in model so
 * that as the model.shapes.Shape objects change, there will be a record of what transformations they underwent
 * which can be printed in a string description.
 */
public class AnimationImpl {
  private List<Transformation> transformationList;

  public AnimationImpl() {
    transformationList = new ArrayList<>();
  }

  /**
   * Adds a Transformation object to the array list.
   *
   * @param transformation object of a Shapes transformation.
   */
  public void addTransformation(Transformation transformation) {
    for (Transformation each : transformationList) {
      if (each.getType() == transformation.getType()) {
        if ((transformation.getStartTime() >= each.getStartTime() && transformation.getStartTime()
                <= each.getEndTime()) || (transformation.getEndTime() >= each.getStartTime()
                && transformation.getEndTime() <= each.getEndTime())) {
          throw new IllegalArgumentException("Two transformations of the same type cannot happen "
                  + "concurrently!");
        }
      }
      transformationList.add(transformation);
    }
  }

  /**
   * Returns an item in the Transformation array list.
   *
   * @param id String ID to identify the object.
   * @return a transformation object based on the entered ID.
   */
  public Transformation getTransformation(String id) {
    for (Transformation each : transformationList) {
      if (each.getShape().retID().equals(id)) {
        return each;
      }
    }
    throw new NoSuchElementException("model.shapes.Shape does not exist.");
  }

  /**
   * String that reflects all the transformation by citing beginning property and transformation
   * result property.
   *
   * @return a string detailing the transformation of each object that has occurred
   */
  public String toString() {
    String currentState = "";
    for (Transformation each : transformationList) {
      currentState += String.format("%s", each.getCurrentState());
    }
    return currentState.stripTrailing();
  }

}

