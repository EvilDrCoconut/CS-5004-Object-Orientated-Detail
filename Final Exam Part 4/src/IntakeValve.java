
class IntakeValve implements PumpComponent {

  private boolean isOpen;

  public IntakeValve(boolean isOpen) {
    this.isOpen = isOpen;
  }

  public boolean isValveOpen() {
    return this.isOpen;
  }

  public void open() {
    isOpen = true;
  }

  public void close() {
    isOpen = false;
  }

  @Override
  public void accept(PumpComponentVisitor repairDrone) {
    repairDrone.visit(this); // ask the drone to visit
  }

}

