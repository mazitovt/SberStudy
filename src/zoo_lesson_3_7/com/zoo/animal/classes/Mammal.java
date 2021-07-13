package zoo_lesson_3_7.com.zoo.animal.classes;

import zoo_lesson_3_7.com.zoo.animal.exceptions.NegativeIntegerException;
import zoo_lesson_3_7.com.zoo.animal.interfaces.Movable;

public abstract class Mammal extends Animal implements Movable {

    protected boolean hasBaby;

    public Mammal(String name, Integer age, Integer weight, Boolean hasBaby) throws NegativeIntegerException {
        super(name, age, weight);
        this.hasBaby = hasBaby;
    }

    public Mammal() {
        super();
    }

    public Mammal(String name, Integer age, Integer weight) throws NegativeIntegerException {
        super(name, age, weight);
    }

    public boolean hasBaby(){
        return hasBaby;
    }

    public void feed(){

        System.out.println("Млекопитающее " + name + " кормит молоком.");
    }
}
