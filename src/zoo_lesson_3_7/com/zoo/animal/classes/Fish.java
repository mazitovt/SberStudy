package zoo_lesson_3_7.com.zoo.animal.classes;

import zoo_lesson_3_7.com.zoo.animal.exceptions.NegativeIntegerException;
import zoo_lesson_3_7.com.zoo.animal.interfaces.Swimmable;

public class Fish extends Animal implements Swimmable {

    public static String className = "Рыба";

    protected Integer depth;

    public Fish(String name, Integer age, Integer weight, Integer depth) throws NegativeIntegerException {
        super(name, age, weight);
        this.depth = depth;
    }

    public Fish() throws NegativeIntegerException {
        this("Немо", 1, 1, 1000);
    }

    public Fish(String name, Integer age, Integer weight) throws NegativeIntegerException {
        super(name, age, weight);
    }

    @Override
    public void swim() {
        System.out.println("Рыба " + name + " плывет.");
    }

    @Override
    public void show() {
        System.out.printf("Имя: %s, Возраст: %d, Вес: %d кг, Глубина: %d метров\n", name, age, weight, depth);
    }

    @Override
    public void voice() {
        System.out.println("Рыба " + name + " не умеет говорить.");
    }
}
