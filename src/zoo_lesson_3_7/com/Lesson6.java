// Lesson6.java - демонстарция работы зоопарка и вольеров, их исключений

package zoo_lesson_3_7.com;

import zoo_lesson_3_7.com.zoo.AnimalEnclosure;
import zoo_lesson_3_7.com.zoo.AnimalZoo;
import zoo_lesson_3_7.com.zoo.animal.classes.*;
import zoo_lesson_3_7.com.zoo.exceptions.EnclosureException;
import zoo_lesson_3_7.com.zoo.exceptions.ZooException;

import java.util.Scanner;

public class Lesson6 {

    private static AnimalZoo zoo = new AnimalZoo(5);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        Menu();
    }

    public static void Menu() {

        int choice = -1;
        boolean exit = false, flag;
        String menuList =
                "\n\nМеню: " +
                        "\n1. Показать вольеры." +
                        "\n2. Добавить вольер." +
                        "\n3. Показать животных в вольере." +
                        "\n4. Добавить животное в вольер." +
                        "\n5. Убрать животное из вольера." +
                "\n\nМаксимальное количество вольеров: 5";

        while (!exit)
        {
            System.out.println(menuList);

            do
            {
                System.out.println("\nВаш выбор: ");
                String input = scanner.nextLine();
                flag = isNumeric(input);
                if (flag){
                    choice = Integer.parseInt(input);
                }
                if (!(0 <= choice && choice <= 5) || !flag) System.out.println("\nВы ввели некорректные данные. Повторите ввод.");
            } while (!(0 <= choice && choice <= 5) || !flag);

            switch (choice)
            {
                case 1: ShowEnclosures(); break;
                case 2: AddEnclosure(); break;
                case 3: ShowAnimals(); break;
                case 4: AddAnimal(); break;
                case 5: RemoveAnimal(); break;

                case 0: exit = true; break;
            }
        }
        System.out.println("\nЗавершение работы программы");
    }

    private static void ShowAnimals() {

        System.out.print("Введите название вольера: ");
        var name = scanner.nextLine();

        try{
            var animals = zoo.getEnclosureAnimals(name);
            if (animals.size() == 0){
                System.out.println("Нет животных.");
                return;
            }
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void RemoveAnimal() {

        System.out.print("Введите название вольера: ");
        var encName = scanner.nextLine();

        try{
            var animals =  zoo.getEnclosureAnimals(encName);

            Integer index = 1;

            System.out.println("Все животные в вольере.");

            for (Animal animal : animals) {
                System.out.println((index++).toString() + ": " + animal);
            }

            var animalIndex = intInput("Введите номер животного: ", 1 , animals.size());

            zoo.removeAnimal(encName, animals.get(animalIndex - 1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void AddAnimal() {

        var enclosures = zoo.getEnclosures();

        System.out.print("Введите название вольера: ");
        var encName = scanner.nextLine();

        var animal = createAnimal();

        try{
            zoo.putAnimal(animal, encName);
        } catch (ZooException | EnclosureException e){
            System.out.println(e.getMessage());
        }
    }

    private static Animal createAnimal(){
        return AnimalCreator.createAnimal(scanner);
    }

    private static void AddEnclosure() {

        System.out.print("Введите название вольера: ");

        var name = scanner.nextLine();
        var maxNumber = intInput("Введите максимальное число животных (от 0 до 10): ", 0, 10);

        try{
            zoo.addEnclosure(name, "Животные", maxNumber);
        } catch (ZooException e){
            System.out.println(e.getMessage());
        }
    }

    public static void ShowEnclosures(){

        var enclosures = zoo.getEnclosures();

        Integer index = 1;

        System.out.println("Все вольеры.");

        if (enclosures.size() == 0){
            System.out.println("Нет вольеров.");
            return;
        }

        for (AnimalEnclosure enclosure : enclosures) {
            System.out.println((index++).toString() + ": " + enclosure);
        }
    }

    public static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }

    public static int intInput(String msg, int beg, int end) {
        boolean flag;
        int elem = 0;

        do
        {
            flag = false;
            System.out.println();
            System.out.print(msg);
            try
            {
                elem = Integer.parseInt(scanner.nextLine());
                if (elem < beg || elem > end) throw new IndexOutOfBoundsException();
            }
            catch (Exception e)
            {
                flag = true;
                System.out.println("\nВы ввели некорректные данные. Повторите ввод.");
            }
        } while (flag);

        return elem;
    }
}
