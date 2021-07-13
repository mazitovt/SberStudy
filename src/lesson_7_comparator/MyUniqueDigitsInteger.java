// Создать класс целых чисел MyInteger с порядком на основе количества различных (!) цифр в десятичном представлении.

package lesson_7_comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyUniqueDigitsInteger implements Comparable<MyUniqueDigitsInteger>{

    private Integer number;
    private Integer numberOfUniqueDigits;

    public MyUniqueDigitsInteger(Integer num){
        number = num;
        countNumberOfUniqueDigits();
    }

    private void countNumberOfUniqueDigits() {

        var numberDigits = new ArrayList<Character>();

        for (char digit : Integer.valueOf(Math.abs(number)).toString().toCharArray()) {
            numberDigits.add(digit);
        }

        Set<Character> digits = new HashSet<Character>(numberDigits);

        numberOfUniqueDigits = digits.size();
    }

    public Integer getNumberOfUniqueDigits() {
        return numberOfUniqueDigits;
    }

    public String toString(){
        return number.toString();
    }

    @Override
    public int compareTo(MyUniqueDigitsInteger o) {
        return Integer.compare(this.numberOfUniqueDigits, o.numberOfUniqueDigits);
    }
}
