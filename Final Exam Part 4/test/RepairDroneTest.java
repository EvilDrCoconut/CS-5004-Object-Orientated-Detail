import java.util.LinkedList;
import java.util.List;

public class RepairDroneTest {

  public static void main(String [] args ) {
    Pump pump = new Pump();
    PumpRepairDrone drone = new PumpRepairDrone();
    pump.inspectParts(drone);
    System.out.println("=> Status of Anti-matter Pump #1:");
    System.out.println(drone.getLog());

    drone = new PumpRepairDrone(); // make a new drone for next inspection
    pump.inspectParts(drone);
    System.out.println("==> Status of Anti-matter Pump #1 (again):");
    System.out.println(drone.getLog());

    List<PumpComponent> parts = new LinkedList<>();
    parts.add(new Drill(Drill.Status.GOOD));
    parts.add(new Pipe(70));
    parts.add(new Motor(true));
    parts.add(new IntakeValve(true));
    drone = new PumpRepairDrone(); // build a new drone, new status, etc.
    pump = new Pump(parts);
    pump.inspectParts(drone);
    System.out.println("===> Status of Anti-matter Pump #2:");
    System.out.println(drone.getLog());
  }

}
