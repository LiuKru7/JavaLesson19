package opp.polymorphism.example_2;

public class PaymentMain {
    public static void main(String[] args) {
        String paymentSelection = "Swedbank";
        Payment payment = null;

        if ("Swedbank".equalsIgnoreCase(paymentSelection)) {
            payment = new SwedbankPayment();
        } else if ("Luminor".equalsIgnoreCase(paymentSelection)) {
            payment = new LuminorPayment();
        }
        payment.executePayment();
        payment = new LuminorPayment();
        payment.executePayment();
    }
}
