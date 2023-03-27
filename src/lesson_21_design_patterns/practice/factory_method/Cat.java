package lesson_21_design_patterns.practice.factory_method;

public class Cat extends Animal{
    @Override
    public String makeSound() {
        return "meow meow";
    }
}
