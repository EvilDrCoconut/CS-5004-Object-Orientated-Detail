
class Pipe implements PumpComponent {

  private int seal;

  public Pipe(int seal) {
    this.seal = seal;
  }

  public int getSealPct() {
    return this.seal;
  }

  @Override
  public void accept(PumpComponentVisitor repairDrone) {
    repairDrone.visit(this); // ask the drone to visit
  }

}
