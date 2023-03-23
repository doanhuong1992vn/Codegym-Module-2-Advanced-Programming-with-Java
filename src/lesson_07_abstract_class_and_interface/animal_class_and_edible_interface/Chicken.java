package lesson_07_abstract_class_and_interface.animal_class_and_edible_interface;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howtoEat() {
        return "could be fried";
    }
}
