import org.junit.Test;

public class OrderDemo {

  @Test
  public void testFirst() {
    Order order = new Order();
    order.addItem(new Item("Toilet Paper", 100.00));
    order.addItem(new Item("Hand sanitizer", 25.32));
    order.acceptPurchase(new CreditCardOrder());
    order.finalizePurchase(new FinalizePayment());
  }

  @Test
  public void testSecond() {
    Order order = new Order();
    order.addItem(new Item("Toilet Paper", 100.00));
    order.addItem(new Item("Hand sanitizer", 25.32));
    order.acceptPurchase(new CashOrder());
    order.finalizePurchase(new FinalizePayment());
  }

  @Test
  public void testThird() {
    Order order = new Order();
    order.addItem(new Item("Toilet Paper", 100.00));
    order.addItem(new Item("Hand sanitizer", 25.32));
    order.acceptPurchase(new PayPalOrder());
    order.finalizePurchase(new FinalizePayment());
  }

}
