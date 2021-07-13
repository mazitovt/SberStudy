package zoo_lesson_3_7.com.zoo.animal.classes;

import zoo_lesson_3_7.com.zoo.animal.exceptions.AnimalDeadException;
import zoo_lesson_3_7.com.zoo.animal.exceptions.NegativeIntegerException;

public abstract class Animal {

    public static String className = "Животное";

    protected Integer age;
    protected String name;
    protected Integer weight;

    protected Boolean isAlive = true;

    public abstract void show();
    public abstract void voice();

    public Animal(){

    }

    public Animal(String name, Integer age, Integer weight) throws NegativeIntegerException {
        setAge(age);
        setName(name);
        setWeight(weight);
    }

    public Integer getWeight(){
        return weight;
    }

    public void setWeight(Integer weight) throws NegativeIntegerException {
        if (weight < 0) {
            throw new NegativeIntegerException(weight.toString());
        } else {
            this.weight = weight;
        }
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age) throws NegativeIntegerException {
        if (age < 0) {
            throw new NegativeIntegerException(age.toString());
        }
        else{
            this.age = age;
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void eat() {
        System.out.println("Животное " + name + " ест.");
    }

    public void eat(String meal){
        System.out.println("Животное " + name + " ест " + meal + ".");
    }

    public void getLifeState(){
        System.out.printf(isAlive ? "Животное %s живет.\n" : "Животное %s мертво.\n", name);
    }

    public void killAnimal() throws AnimalDeadException {
        if (isAlive){
            isAlive = false;
            System.out.printf("Животное %s убито.\n", name);
            return;
        }

        throw new AnimalDeadException(this);
    }

    public String toString(){
        return String.format("Имя: %s, Возраст: %d, Вес: %d кг.",
                name, age, weight);
    }

}
