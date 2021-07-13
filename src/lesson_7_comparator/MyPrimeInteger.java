// Создать класс целых чисел MyInteger с порядком на основе количества простых делителей.

package lesson_7_comparator;

import java.lang.management.MemoryUsage;
import java.util.Comparator;

public class MyPrimeInteger implements Comparable<MyPrimeInteger> {


    private Integer number;
    private Integer numberOfPrimeDividers;

    public MyPrimeInteger(Integer num){
        number = num;
        countNumberOfPrimeDividers();
    }

    @Override
    public int compareTo(MyPrimeInteger o) {
        return Integer.compare(this.numberOfPrimeDividers, o.numberOfPrimeDividers);
    }

    private void countNumberOfPrimeDividers(){

        if (number == -1 || number == 0 || number == 1){
            numberOfPrimeDividers = 0;
            return;
        }

        Integer count = 0;


        Integer divider = 2;
        Integer num = number;

        while (Math.abs(num) != 1){
            if (isPrime(divider) && num % divider == 0){
                count++;
                num /= divider;
                continue;
            }

            divider++;
        }

        numberOfPrimeDividers = count;
    }

    public Integer getNumberOfPrimeDividers() {
        return numberOfPrimeDividers;
    }

    private boolean isPrime(Integer num){

        if (num == 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }

    public String toString(){
        return number.toString();
    }
}
