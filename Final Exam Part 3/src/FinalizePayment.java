public class FinalizePayment {

  private Payment method;

  public FinalizePayment(){
    method = null;
  }

  public void setPayment(Payment type){
    method = type;
  }

  public void complete(Order order){
    if(method instanceof CashOrder){
      System.out.println("Cash Accepted for " + order.getItems() + "\n");
    } else if(method instanceof CreditCardOrder){
      System.out.println("I'll need your credit card number, please.\n...Processing...");
      System.out.println("Credit Card Accepted for " + order.getItems() + "\n");
    } else if (method instanceof PayPalOrder){
      System.out.println("I'll need your PayPal account, please.\n...Processing...");
      System.out.println("PayPal Accepted for " + order.getItems()+ "\n");
    }
    System.out.println("Choose payment type");
  }

}
