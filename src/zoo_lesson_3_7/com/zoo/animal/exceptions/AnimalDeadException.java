package zoo_lesson_3_7.com.zoo.animal.exceptions;

import zoo_lesson_3_7.com.zoo.animal.classes.Animal;

public class AnimalDeadException extends Exception{

    String animalName;

    public AnimalDeadException(Animal deadAnimal){
        super();
        this.animalName = deadAnimal.getName();
    }

    public String getMessage(){
        return String.format("Мертвое животное %s нельзя убить.", animalName);
    }

}
