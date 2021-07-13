// Lesson3.java - демонстарция иерархии классов и работы исключений.

package zoo_lesson_3_7.com;

import zoo_lesson_3_7.com.zoo.animal.classes.*;
import zoo_lesson_3_7.com.zoo.animal.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class Lesson3 {

    public static void main(String[] args){

        try{
            var zoo = createZoo();

            testAnimalMethods(zoo);

            testMammalMethods(zoo);

            // ДЕМОНСТРАЦИЯ ИСКЛЮЧЕНИЙ

            testAnimalCreation();

            testAnimalDeaths();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void testMammalMethods(List<Animal> zoo) {

        System.out.println("Вызов методов, определенных в классе Mammal.");

        for (Animal animal : zoo) {
            if (animal instanceof Mammal mammal){
                if (mammal.hasBaby()){
                    mammal.feed();
                }
            }
        }
    }

    private static void testAnimalDeaths() throws NegativeIntegerException {

        System.out.println("\nСмерть животных (демонстрация исключений).");

        Fish fish1 = new Fish();

        System.out.println("Рыба жива. Попытка убить.");
        try{
            fish1.getLifeState();
            fish1.killAnimal();
            fish1.getLifeState();
        } catch (AnimalDeadException e){
            System.out.println("Ошибка при попытке убить: " + e.getMessage());
        }

        System.out.println("\nРыба мертва. Попытка убить.");
        try{
            fish1.getLifeState();
            fish1.killAnimal();
            fish1.getLifeState();
        } catch (AnimalDeadException e){
            System.out.println("Ошибка при попытке убить: " + e.getMessage());
        }
    }

    private static void testAnimalCreation() {
        System.out.println("\nСоздание животных (демонстрация исключений).");

        try{
            new Lion("Лев", -15, 100, true, true);
        } catch (NegativeIntegerException e){
            System.out.println("Ошибка при создании животного: " + e.getMessage());
        }


        try{
            new Horse("Лошадь", 15, -100, true, true);
        } catch (NegativeIntegerException e){
            System.out.println("Ошибка при создании животного: " + e.getMessage());
        }
    }

    public static List<Animal> createZoo() throws NegativeIntegerException{

        System.out.println("Создание животных.");

        Lion lion = new Lion();
        Horse horse = new Horse();
        Fish fish = new Fish();
        Bird bird = new Bird();

        List<Animal> zoo = new ArrayList<Animal>();

        zoo.add(lion);
        zoo.add(horse);
        zoo.add(fish);
        zoo.add(bird);

        System.out.println("В зоопарке 4 животных.");

        return zoo;
    }

    private static void testAnimalMethods(List<Animal> zoo) {

        System.out.println("\nВызов методов, определенных в классе Animal.");

        for (Animal animal : zoo) {
            animal.show();
            animal.getLifeState();
            animal.eat();
            animal.eat("мандарин");

            try {
                animal.killAnimal();
            } catch (AnimalDeadException e){
                System.out.println(e.getMessage());
            }

            animal.getLifeState();
            System.out.println();
        }
    }
}
