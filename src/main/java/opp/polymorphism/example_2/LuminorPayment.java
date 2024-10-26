package opp.polymorphism.example_2;

public class LuminorPayment extends Payment{
    @Override
    public void executePayment() {
        System.out.println("Connecting to Luminor, executing payment");
    }
}
