package opp.polymorphism.example_1;

public class Dog extends Animal{
    @Override
    protected void makeSound() {
        System.out.println("Gaf gaf");
    }
    public void bark() {
        System.out.println("Bark bark");
    }
}
