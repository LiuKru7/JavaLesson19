package opp.polymorphism.example_2;

public class SwedbankPayment extends Payment {
    @Override
    public void executePayment() {
        System.out.println("Connecting to Swedbank, executing payment");
    }
}
