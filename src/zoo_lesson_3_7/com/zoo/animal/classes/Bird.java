package zoo_lesson_3_7.com.zoo.animal.classes;

import zoo_lesson_3_7.com.zoo.animal.exceptions.NegativeIntegerException;
import zoo_lesson_3_7.com.zoo.animal.interfaces.Flyable;

public class Bird extends Animal implements Flyable {

    public static String className = "Птица";

    protected Integer speed;

    public Bird(String name, Integer age, Integer weight, Integer speed) throws NegativeIntegerException {
        super(name, age, weight);
        this.speed = speed;
    }

    public Bird() throws NegativeIntegerException {
        this("Зазу", 7, 1, 15);
    }

    public Bird(String name, Integer age, Integer weight) throws NegativeIntegerException {
        super(name, age, weight);
    }

    @Override
    public void fly() {
        System.out.println("Птица " + name + " летит.");
    }

    @Override
    public void show() {
        System.out.printf("Имя: %s, Возраст: %d, Вес: %d кг, Скорость: %d м/с\n", name, age, weight, speed);
    }

    @Override
    public void voice() {
        System.out.println("Птица " + name + " чирикает.");
    }
}
