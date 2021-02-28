import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassTesting {

  @Test
  public void magicSquareTest() {
    MagicSquare magicSquare = new MagicSquare();
    Iterator<Integer> magicIt = magicSquare.iterator();
    for (int i = 0; i < 5; i++) { // get first 10 magic numbers
      if (magicIt.hasNext()) // not really needed but good practice
        System.out.println(magicIt.next());
    }
  }

  public static void main(String[] args) {

    List<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    List<String> trucks = new ArrayList<String>();
    trucks.add("GMC");
    trucks.add("Toyota");
    trucks.add("Mac");

    List<String> food = new ArrayList<String>();
    food.add("Hamburger");
    food.add("Hot dog");

    List<Iterator<String>> it = new ArrayList<>();
    it.add(cars.iterator());
    it.add(trucks.iterator());
    it.add(food.iterator());

    RoundRobin robin = new RoundRobin(it);
    Iterator<String> roundRobinIterator = robin.iterator();
    while (roundRobinIterator.hasNext()) {
      System.out.println(roundRobinIterator.next());
    }
  }

}