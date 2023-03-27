package lesson_21_design_patterns.practice.factory_method;

public class FactoryDemo {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal dog = animalFactory.getAnimal("dog");
        Animal cat = animalFactory.getAnimal("cat");
        System.out.println("Dog sound: " + dog.makeSound());
        System.out.println("Cat sound: " + cat.makeSound());
    }
}
