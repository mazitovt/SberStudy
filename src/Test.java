import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {

    public static <T> T func(int h){
        return null;
    }

    public static void main(String[] args) {


        var r = func(56);

        var g = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer integer) {
                return null;
            }
        };

        java.util.function.BiFunction<Integer, Integer, Integer> l = (k, m) -> k + m;

        Scanner sc = new Scanner(System.in);

        boolean correctSequence = true;
        var brackets = sc.nextLine();
        var brackets1 = sc.nextLine();
        var brackets2 = sc.nextLine();

        Queue<Character> queue = new LinkedList<>();

        Integer b = 6;
        b.longValue();

        TreeSet<String> set = new TreeSet<String>();

        for (char bracket : brackets.toCharArray()) {
            if (bracket == '('){
                queue.offer(bracket);
            }
            try{
                if (bracket == ')'){
                    queue.remove();
                }
            } catch (Exception e){
                correctSequence = false;
                break;
            }
        }

        if (correctSequence && queue.isEmpty()){
            System.out.println("Последовательность правильная");
        }
        else{
            System.out.println("Последовательность неправильная");
        }

    }
}
