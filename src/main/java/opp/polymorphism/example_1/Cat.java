package opp.polymorphism.example_1;

public class Cat extends Animal{

    @Override
    protected void makeSound() {
        System.out.println("Meow!!!");
    }
    public void drinkMilk () {
        System.out.println("Drink milk");
    }
}
