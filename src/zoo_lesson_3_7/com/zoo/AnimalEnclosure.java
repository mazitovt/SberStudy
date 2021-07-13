package zoo_lesson_3_7.com.zoo;

import zoo_lesson_3_7.com.zoo.animal.classes.Animal;
import zoo_lesson_3_7.com.zoo.exceptions.*;

import java.util.*;

public class AnimalEnclosure {

    String species;
    HashSet<Animal> animals;
    Integer maxNumberOfAnimals;
    String name;

    public AnimalEnclosure(){

        maxNumberOfAnimals = 5;
        animals = new LinkedHashSet<>();
    }

    public AnimalEnclosure(String name, Integer maxNumber, String species) {

        this.name = name;
        this.species = species;
        animals = new LinkedHashSet<>();
        maxNumberOfAnimals = maxNumber;
    }

    public boolean isFull(){
        return animals.size() == maxNumberOfAnimals;
    }

    public void addAnimal(Animal animal) throws EnclosureException {

        checkFullness();
        checkSameAnimal(animal);

        animals.add(animal);
    }

    public Iterator<Animal> getAnimalsIter(){;
        return animals.iterator();
    }

    public void remove(Animal animal){
        animals.remove(animal);
    }

    private void checkFullness() throws FullEnclosureException {
        if (isFull()){
            throw new FullEnclosureException(this.name);
        }
    }

    private void checkSameAnimal(Animal animal) throws SameAnimalException {
        if (animals.contains(animal)) {
            throw new SameAnimalException(animal.toString(), this.name);
        }
    }

    public String toString(){
        return String.format("Название: %s, вместимость: %d", name, maxNumberOfAnimals);
    }
}
