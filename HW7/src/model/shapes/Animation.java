package model.shapes;

import model.shapes.Shape;

public interface Animation {

// What objects to I Need?
  // model.shapes.Shape: Oval, Rectangle, Circle, Square Triange, just start with Oval and Rectangle though

  //Why do I have to worry about where the objects will be stored? Where is storage coming from?

  //So an animation class follows the animation imple. But there's a shape interface that has the
  // shape client classes in it.

// **create an application that will draw an animation according to how it is described in text**


  /**
   * Command to the model to resize the shape.
   */
  Shape resize();
  void move();
  void changeColor();







}
