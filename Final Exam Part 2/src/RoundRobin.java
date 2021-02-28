import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoundRobin<T> implements Iterable<T> {

  private List<Iterator<T>> collectionOfIterators;
  private int index = 0;

  public RoundRobin(List<Iterator<T>> collectionOfIterators) {
    this.collectionOfIterators = collectionOfIterators;
  }

  public Iterator<T> iterator() {

    return new Iterator<T>() {

      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public T next() {
          return (T) this;
      }
    };
  }
}
