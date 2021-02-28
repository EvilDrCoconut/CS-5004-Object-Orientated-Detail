import java.util.Iterator;
/**
 * Magic Square Rule: m = n * (n * n + 1) / 2
 */
public class MagicSquare implements Iterable<Integer> {

  private class MagicSquareIterator {

    int current = 1;
    int m = (current * (current*current) + 1) / 2;

  }

  @Override
  public Iterator<Integer> iterator() {
    return new MagicSquareIterator();
  }
}