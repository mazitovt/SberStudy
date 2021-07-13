package lesson_12_generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lesson12 {


    static class MyInteger {
        public Integer number;

        public MyInteger(Integer num){
            number = num;
        }

        public String toString(){
            return number.toString();
        }
    }

    public static void main(String[] args) {

        List<MyInteger> listMyInteger = new ArrayList<>() {{
            add(new MyInteger(1));
            add(new MyInteger(2));
            add(new MyInteger(3));
            add(new MyInteger(4));
        }};

        List<Integer> listInteger = new ArrayList<>(){{
            add(2);
            add(1);
            add(3);
            add(4);
        }};

        System.out.println("\n1. Демострация метода map.");
        demoMap(listInteger);

        System.out.println("\n\n2. Демострация метода forEach.");
        demoForEach(listMyInteger);


        var listWithNegative = new ArrayList<>(listInteger);
        listWithNegative.add(-1);
        listWithNegative.add(-2);

        System.out.println("\n\n3. Демострация метода filter.");
        demoFilter(listWithNegative);

        System.out.println("\n\n4. Демонстрация метода count.");
        demoCount(listWithNegative);


        System.out.println("\n\n5. Демонстарция метода foldLeft.");
        demoFoldLeft(listInteger);

        System.out.println("\n\n6. Демонстарция метода foldRight.");
        demoFoldRight(listInteger);
    }

    private static void demoFoldRight(List<Integer> listInteger) {

        listInteger = new ArrayList<>(listInteger);

        BinaryOperator<Integer> integerPow = (elem, pow) -> {

            if (pow <= 0){
                return 1;
            }
            Integer res = 1;

            for (int i = 1; i <= pow; i++){
                res *= elem;
            }

            return res;
        };

        var resultSum = ListExtensions.foldRight(listInteger, (elem1, elem2) -> elem1 + elem2);
        var resultPow = ListExtensions.foldRight(listInteger, integerPow);


        System.out.print("\nПравоассоциативная свертка по функции суммирования: ");
        System.out.println(resultSum);

        System.out.print("\nПравоассоциативная свертка по функции возведения в степень: ");
        System.out.println(resultPow);
    }

    private static void demoFoldLeft(List<Integer> listInteger) {

        listInteger = new ArrayList<>(listInteger);

        BinaryOperator<Integer> integerPow = (elem, pow) -> {

            if (pow <= 0){
                return 1;
            }
            Integer res = 1;

            for (int i = 1; i <= pow; i++){
                res *= elem;
            }

            return res;
        };

        var resultSum = ListExtensions.foldLeft(listInteger, (elem1, elem2) -> elem1 + elem2);
        var resultPow = ListExtensions.foldLeft(listInteger, integerPow);


        System.out.print("\nЛевоассоциативная свертка по функции суммирования: ");
        System.out.println(resultSum);

        System.out.print("\nЛевоассоциативная свертка по функции возведения в степень: ");
        System.out.println(resultPow);
    }

    private static void demoCount(List<Integer> listInteger) {

        listInteger = new ArrayList<>(listInteger);

        var evenIntegers = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        var resultCountLambda = ListExtensions.count(listInteger, (elem) -> elem < 0);
        var resultCountFunctionInterface = ListExtensions.count(listInteger, evenIntegers);

        System.out.println("\nИсходный список.");
        print(listInteger);

        System.out.println("\nЧисло отрицательных чисел (лямбда): " + resultCountLambda);
        System.out.println("\nЧисло четных чисел (функциональный интерфейс): " + resultCountFunctionInterface);
    }

    private static void demoFilter(List<Integer> listInteger) {

        listInteger = new ArrayList<>(listInteger);

        var evenIntegers = new Predicate<Integer>(){

            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        var resultListLambda = ListExtensions.filter(listInteger, (elem) -> elem > 0);
        var resultListFunctionInterface = ListExtensions.filter(listInteger, evenIntegers);

        System.out.println("\nИсходный список.");
        print(listInteger);
        System.out.println("\nПолученный список положительных чисел (лямбда).");
        print(resultListLambda);
        System.out.println("\nПолученный список четных чисел (функциональный интерфейс).");
        print(resultListFunctionInterface);
    }

    private static void demoMap(List<Integer> listInteger) {

        listInteger = new ArrayList<>(listInteger);

        var squareInteger = new Function<Integer, Integer>(){

            @Override
            public Integer apply(Integer integer) {
                return integer * integer * integer;
            }
        };

        var resultListLambda = ListExtensions.map(listInteger, (elem) -> elem * elem);

        var resultListFunctionInterface = ListExtensions.map(listInteger, squareInteger);

        System.out.println("\nИсходный список.");
        print(listInteger);
        System.out.println("\nПолученный список квадратов чисел (лямбда).");
        print(resultListLambda);
        System.out.println("\nПолученный список кубов чисел (функциональный интерфейс).");
        print(resultListFunctionInterface);
    }

    private static void demoForEach(List<MyInteger> list) {

        list = new ArrayList<>(list);

        System.out.println("\nИсходный список.");
        print(list);

        ListExtensions.forEach(list, (MyInteger elem) -> elem.number = elem.number * elem.number);

        System.out.println("\nЭлементы объекта исходного списка изменились.");
        print(list);
    }

    static <T> void print(List<T> list){
        System.out.println(String.join(" ",ListExtensions.map(list, Object::toString)));
    }
}
