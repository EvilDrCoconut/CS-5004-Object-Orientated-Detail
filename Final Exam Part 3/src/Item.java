
public class Item {

  private String name;
  private double price;

  Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  double getPrice () {
    return price;
  }

  @Override
  public String toString() {
    return name;
  }

}
