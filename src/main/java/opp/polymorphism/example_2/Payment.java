package opp.polymorphism.example_2;

public abstract class Payment {
    public void chargeForService() {
        System.out.println("Charging 10 cents for transaction!");
    }
    public abstract void executePayment();

}
