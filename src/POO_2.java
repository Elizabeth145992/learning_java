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

    static class BankTransfer implements PaymentMethod {
        @Override
        public boolean pay(double amount) {
            System.out.println("Pagando $" + amount + " mediante transferencia bancaria");
            return true;
        }
    }

    public static boolean processPayment(PaymentMethod payment, double amount) {
        return payment.pay(amount);
    }

    public static void main(String[] args) {
        processPayment(new CreditCard(), 100);
        processPayment(new Cash(), 200);
        processPayment(new BankTransfer(), 300);
    }
}
