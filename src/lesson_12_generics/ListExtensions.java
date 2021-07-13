package lesson_12_generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public final class ListExtensions {


    private ListExtensions(){

    }

    static <T, R> List<R> map(List<T> origin, Function<T, R> mapper){
        
        List<R> resultList = new ArrayList<>();

        for (T elem : origin) {
            resultList.add(mapper.apply(elem));
        }
        
        return resultList;
    }
    
    static <T> void forEach(List<T> origin, Consumer<T> consumer){

        for (T elem : origin) {
            consumer.accept(elem);
        }
    }

    static <T> List<T> filter(List<T> origin, Predicate<T> predicate){

        List<T> resultList = new ArrayList<>();

        for (T elem : origin) {
            if(predicate.test(elem)){
                resultList.add(elem);
            }
        }

        return resultList;
    }

    static <T> Integer count(List<T> origin, Predicate<T> predicate){

        Integer count = 0;

        for (T elem : origin) {
            if (predicate.test(elem)){
                count++;
            }
        }

        return count;
    }

    // если в последовательности один элемент, то вернет этот элемент
    static <T> T foldLeft(List<T> origin, BinaryOperator<T> biOperation){

        if (origin.size() == 0){
            return null;
        }

        var iter = origin.listIterator();
        T result = iter.next();

        while (iter.hasNext()){
            result = biOperation.apply(result, iter.next());
        }

        return result;
    }

    // если в последовательности один элемент, то вернет этот элемент
    static <T> T foldRight(List<T> origin, BinaryOperator<T> biOperation){

        if (origin.size() == 0){
            return null;
        }

        var iter = origin.listIterator(origin.size());
        T result = iter.previous();

        while (iter.hasPrevious()){
            result = biOperation.apply(result, iter.previous());
        }

        return result;
    }

}
