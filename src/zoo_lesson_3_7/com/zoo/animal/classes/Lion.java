package zoo_lesson_3_7.com.zoo.animal.classes;

import zoo_lesson_3_7.com.zoo.animal.exceptions.NegativeIntegerException;
import zoo_lesson_3_7.com.zoo.animal.interfaces.MeatEater;

public final class Lion extends Mammal implements MeatEater {

    private boolean canHunt;

    public Lion(String name, Integer age, Integer weight, Boolean hasBaby, Boolean canHunt) throws NegativeIntegerException {
        super(name, age, weight,hasBaby);
        this.canHunt = canHunt;
    }

    public Lion() throws NegativeIntegerException {
        this("Симба", 10, 70, false, true);
    }

    public Lion(String name, Integer age, Integer weight) throws NegativeIntegerException {
        super(name, age, weight);
    }
    @Override
    public void show() {
        System.out.printf("Имя: %s, Возраст: %d, Вес: %d кг, Львята: %s, Может охотиться: %s\n",
                name, age, weight, hasBaby ? "есть" : "нет", canHunt ? "да" : "нет");
    }

    @Override
    public void voice() {
        System.out.println("Лев " + name + " рычит.");
    }

    @Override
    public void killPrey() {
        System.out.printf(canHunt ? "Лев %s убил добычу." : "Лев %s не может убить добычу.", name);
    }

    @Override
    public void eatPrey() {
        System.out.printf(canHunt ? "Лев %s ест добычу." : "Лев %s не может убить добычу, чтобы съесть ее.", name);
    }

    @Override
    public void move() {
        System.out.println("Лев " + name + " бежит.");
    }

    // переопределение метода Animal.eat
    public void eat(){
        System.out.println("Новый лев ест");
    }
}
