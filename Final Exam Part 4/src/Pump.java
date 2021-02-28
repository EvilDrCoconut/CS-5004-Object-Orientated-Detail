import java.util.List;
import java.util.LinkedList;

public class Pump {

  private List<PumpComponent> parts;

  public Pump() { // default constructor
    parts = new LinkedList<>();
    parts.add(new Drill(Drill.Status.BROKEN));
    parts.add(new Pipe(75));
    parts.add(new Motor(true));
    parts.add(new IntakeValve(true));
  }

  public Pump(List<PumpComponent> parts) {
    this.parts = parts;
  }

  public void inspectParts(PumpComponentVisitor drone) {
    for (PumpComponent eachPart : parts) {
      eachPart.accept(drone);
    }
  }

}
