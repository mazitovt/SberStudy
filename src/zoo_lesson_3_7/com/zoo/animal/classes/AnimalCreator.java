package zoo_lesson_3_7.com.zoo.animal.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnimalCreator {

    private static Map<Integer, Class> animalTypes = new HashMap<>(){{
        put(1, Lion.class);
        put(2, Horse.class);
        put(3, Fish.class);
        put(4, Bird.class);
    }};

    public static Animal createAnimal(Scanner sc){

        System.out.println("Объект какого класса нужно создать?");
        System.out.println("1 - Лев\n2 - Конь\n3 - Рыба\n4 - Птица");

        int choice = intInput(sc,"Введите числоа от 1 до 4:" , 1, 4);

        var type = animalTypes.get(choice);

        Animal animal = null;

        Class[] params = {String.class, Integer.class, Integer.class};

        System.out.print("Введите имя животного: ");
        String name = sc.nextLine();
        Integer age = intInput(sc, "Введите возвраст животного (от 0 до 100): ", 0, 100);
        Integer weight = intInput(sc ,"Введите вес животного (от 0 до 500): ", 0, 100);

        try{
            animal = (Animal)(type.getConstructor(params).newInstance(name, age, weight));

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return animal;
    }


    private static int intInput(Scanner scanner, String msg, int beg, int end) {
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
