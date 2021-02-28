import java.util.LinkedList;
import java.util.List;

public class Order {

  Payment paymentMethod = null;

  private List<Item> items = new LinkedList<>();

  public void changePaymentMethod(Payment method){
    this.paymentMethod = method;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void acceptPurchase(Payment visitor) {
    visitor.acceptPurchase(this);
  }

  public void finalizePurchase(FinalizePayment visitor){
    visitor.setPayment(paymentMethod);
    visitor.complete(this);
  }

  protected List<Item> getItems() {
    return items;
  }
}

