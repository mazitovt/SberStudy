import java.util.Scanner;

public class Kth {
    public static void main(String[] args) {

        long start = 0 , end = 8, countNumbers = 9, numberOfDigits = 1;

        var k = new Scanner(System.in).nextLong();

//      перебор и вывод чисел от 1 до k
//        Test(k);

        while (!(k >= start && k <= end)){
            start = end + 1;
            countNumbers =  countNumbersMethod(numberOfDigits, countNumbers);
            if (countNumbers < 0){
                countNumbers = Long.MAX_VALUE - start + 1;
            }
            end = start + countNumbers - 1;
            if (end < 0){
                end = Long.MAX_VALUE;
            }
            numberOfDigits++;
        }

        long v1 = k - start;
        long numberPart = v1 / numberOfDigits;
        long numberStartPos = start + numberPart * numberOfDigits;

        long wholePart = 1;

        for (int i = 1; i < numberOfDigits; i++){
            wholePart *= 10L;
        }

        long number = wholePart + numberPart;

        long position = k - numberStartPos;
        char numberStr = Long.toString(number).charAt((int) position);

        System.out.println(numberStr);
    }

    public static long countNumbersMethod(long numberOfDigits, long prevCount){

        long v1 = prevCount / 9L;

        long v2 = 1;
        for (int i = 1; i < numberOfDigits; i++){
            v2 *= 10L;
        }

        long v3 = v1 + v2;
        long v4 = v3 * 90L;

        return v4;
    }


    public static void Test(long position){
        long count = 0;

        System.out.println("Цифра | Позиция");
        for (int i = 1; i != 0; i++){
            String num = Integer.toString(i);
            for (int j = 0; j < num.length();j++){
                System.out.printf("%" + (5) + "s | %s\n", num.charAt(j), count++);
                if (count - 1 == position){
                    return;
                }
            }
        }
    }
}
