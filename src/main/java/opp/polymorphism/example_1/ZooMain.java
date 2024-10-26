package opp.polymorphism.example_1;

import java.util.ArrayList;
import java.util.List;

public class ZooMain {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        Animal rainysCat = new Cat();
        rainysCat.makeSound();
        rainysCat = new Dog();
        rainysCat.makeSound();

        Animal fidoDog = new Dog();
        fidoDog.makeSound();

        List<Animal> animals = new ArrayList<>();
        animals.add(rainysCat);
        animals.add(fidoDog);

        for(Animal gyvunas: animals) {
            gyvunas.makeSound();
        }
    }
}
