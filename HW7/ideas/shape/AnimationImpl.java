//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//public class AnimationImpl {
//  private List<model.shapes.Shape> stateChange;
//
//  public AnimationImpl() {
//    stateChange = new ArrayList<>();
//  }
//
//  public void addShape(String name, model.shapes.Shape shape) {
//    stateChange.add(shape);
//  }
//
//  public model.shapes.Shape getShape(String id) {
//    for (model.shapes.Shape each : stateChange) {
//      if (each.retID == id) {
//        return each;
//      }
//    }
//    throw new NoSuchElementException("model.shapes.Shape does not exist.");
//  }
//
//  public void addMove() {
//
//  }
//
//  public String getState() {
//
//  }
//
//
//}
