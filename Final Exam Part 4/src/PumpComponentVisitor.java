import java.util.HashMap;

public interface PumpComponentVisitor {

  void visit(Drill drill);

  void visit(Motor motor);

  void visit(Pipe pipe);

  void visit(IntakeValve intakeValve);

  HashMap<String, String> getLog();

}
