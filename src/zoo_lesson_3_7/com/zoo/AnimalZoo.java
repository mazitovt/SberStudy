package zoo_lesson_3_7.com.zoo;

import zoo_lesson_3_7.com.zoo.animal.classes.Animal;
import zoo_lesson_3_7.com.zoo.exceptions.*;

import java.util.*;

public class AnimalZoo {

    protected Integer maxNumberOfEnclosures;

//    public Map<String, Enclosure<? extends Animal>> prototypeEnclosures = new HashMap<>(){{
//        put("Животное", new Enclosure<Animal>());
//        put("Млекопитающее", new Enclosure<Mammal>());
//        put("Лев", new Enclosure<Lion>());
//        put("Лошадь", new Enclosure<Horse>());
//        put("Рыба", new Enclosure<Fish>());
//        put("Птица", new Enclosure<Bird>());
//    }};

    protected Map<String, AnimalEnclosure> enclosures = new HashMap<>();


    public AnimalZoo(){

    }

    public AnimalZoo(Integer maxNumber){

        maxNumberOfEnclosures = maxNumber;
    }

    public boolean containsEnclosure(String name){
        return enclosures.containsKey(name);
    }

    public void addEnclosure(String name, String species, Integer maxNumber) throws ZooException {

        if (enclosures.size() == maxNumberOfEnclosures){
            throw new FullZooException();
        }

        if (enclosures.containsKey(name)){
            throw new ExistingEnclosureException(name);
        }

        var enclosure = new AnimalEnclosure(name, maxNumber, species);
        enclosures.put(name, enclosure);
    }

    public Collection<AnimalEnclosure> getEnclosures(){
        return enclosures.values();
    }


    public void putAnimal(Animal animal, String name) throws EnclosureException, ZooException {

        checkEnclosure(name);

        enclosures.get(name).addAnimal(animal);
    }

    private void checkEnclosure(String name) throws NonExistingEnclosureException {
        if (!containsEnclosure(name)){
            throw new NonExistingEnclosureException(name);
        }
    }

    public List<Animal> getEnclosureAnimals(String name) throws NonExistingEnclosureException{

        checkEnclosure(name);

        var iter =  enclosures.get(name).getAnimalsIter();

        List<Animal> animals = new ArrayList<>();

        while (iter.hasNext()){
            animals.add(iter.next());
        }

        return animals;
    }

    public void removeAnimal(String name, Animal animal) throws NonExistingEnclosureException {

        checkEnclosure(name);
        enclosures.get(name).remove(animal);
    }

}
