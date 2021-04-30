package lesson1;

import java.util.Scanner;
import java.util.StringJoiner;

public class AsteriskFrame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();
        String word = sc.next();

        int length = word.length();

        if (height < 3 || width < length + 2){
            System.out.println("Ошибка");
            return;
        }

        int wordRow = (int) Math.round((height - 2) / 2d);
        int leftPad = (int) Math.floor((width - length - 2) / 2d);
        int rightPad = (int) Math.round((width - length - 2) / 2d);

        String asterisks = "*".repeat(width);

        StringBuilder sb;
        StringJoiner sj = new StringJoiner("\n");

        sj.add(asterisks);
        for (int i = 1; i < height - 1; i++){
            if (i == wordRow){
                sb = new StringBuilder();

                sb.append("*")
                        .append("-".repeat(leftPad))
                        .append(word)
                        .append("-".repeat(rightPad))
                        .append("*");
                sj.add(sb);
            }
            else{
                sb = new StringBuilder();
                sb.append("*")
                        .append("-".repeat(width-2))
                        .append("*");
                sj.add(sb);
            }
        }
        sj.add(asterisks);

        System.out.println(sj);
    }
}
