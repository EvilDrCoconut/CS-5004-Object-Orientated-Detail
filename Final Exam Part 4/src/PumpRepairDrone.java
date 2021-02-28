import java.util.HashMap;

public class PumpRepairDrone implements PumpComponentVisitor {

  private HashMap<String, String> backLog;

 public PumpRepairDrone(){
   backLog = new HashMap<String, String>();
 }

  @Override
  public void visit(Drill drill) {
    if(drill.getStatus().equals(Drill.Status.BROKEN)){
     backLog.put("Drill", "Broken");
    } else{
     backLog.put("Drill", "Good");
    }
  }

  @Override
  public void visit(Motor motor) {
   int pipeCheck = Integer.parseInt(backLog.get("Pipe"));

   if(backLog.get("Drill").equals("Broken")){
      if(motor.isOn()){
       motor.turnOff();
       backLog.put("Motor", "Off");
      } else{
       backLog.put("Motor", "Off");
      }
   } else if(pipeCheck < 70){
     if(motor.isOn()){
      motor.turnOff();
      backLog.put("Motor", "Off");
     } else{
      backLog.put("Motor", "Off");
     }
   } else{
     backLog.put("Motor", "On");
   }
  }

  @Override
  public void visit(Pipe pipe) {
  int pipeCheck = pipe.getSealPct();
  if(pipeCheck < 100){
    System.out.println("WARNING: Pipe Seal under 100%!");
  }
   backLog.put("Pipe", Integer.toString(pipe.getSealPct()));
 }

  @Override
  public void visit(IntakeValve intakeValve) {
   int pipeCheck = Integer.parseInt(backLog.get("Pipe"));
    if(backLog.get("Drill").equals("Broken") || pipeCheck < 70){

     if(intakeValve.isValveOpen()){
       intakeValve.close();
      }
     backLog.put("IntakeValve", "Closed");
    } else{
      backLog.put("IntakeValve", "Opened");
    }
  }

  @Override
  public HashMap<String, String> getLog() {
    return backLog;
  }
}
