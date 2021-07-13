package lesson_7_comparator;

import java.util.Arrays;

public class Lesson7 {
    public static void main(String[] args) {

        demoMyPrimeDigits();

        System.out.println();
        System.out.println();

        demoMyUniqueDigits();
    }

    private static void demoMyUniqueDigits() {
        var array1 = new MyUniqueDigitsInteger[]{
                new MyUniqueDigitsInteger(-16),
                new MyUniqueDigitsInteger(1852),
                new MyUniqueDigitsInteger(123),
                new MyUniqueDigitsInteger(11111),
                new MyUniqueDigitsInteger(8),
                new MyUniqueDigitsInteger(92),
        };

        Arrays.sort(array1);

        System.out.println("Число : Количество уникальных цифр");

        for (MyUniqueDigitsInteger number : array1) {
            System.out.printf("%5s : %s\n",number, number.getNumberOfUniqueDigits());
        }
    }

    private static void demoMyPrimeDigits() {
        var array = new MyPrimeInteger[]{
                new MyPrimeInteger(-16),
                new MyPrimeInteger(6),
                new MyPrimeInteger(2),
                new MyPrimeInteger(17),
                new MyPrimeInteger(8),
                new MyPrimeInteger(15),
                new MyPrimeInteger(4),
                new MyPrimeInteger(5)
        };

        Arrays.sort(array);

        System.out.println("Число : Количество простых делителей");

        for (MyPrimeInteger myPrimeInteger : array) {
            System.out.printf("%5s : %s\n",myPrimeInteger, myPrimeInteger.getNumberOfPrimeDividers());
        }
    }
}
