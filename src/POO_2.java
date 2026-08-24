public class POO_2 {
    interface PaymentMethod {
        boolean pay(double amount);
    }

    static class CreditCard implements PaymentMethod {
        @Override
        public boolean pay(double amount) {
            System.out.println("Pagando $" + amount + " con tarjeta de crédito");
            return true;
        }
    }
    
    static class Cash implements PaymentMethod {
        @Override
        public boolean pay(double amount) {
            System.out.println("Pagando $" + amount + " en efectivo");
            return true;
        }
    }

    public static void main(String[] args) {
        PaymentMethod payment = new CreditCard();
        payment.pay(100.0);
        payment = new Cash();
        payment.pay(50.0);
    }

}
