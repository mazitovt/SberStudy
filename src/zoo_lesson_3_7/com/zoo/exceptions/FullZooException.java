package zoo_lesson_3_7.com.zoo.exceptions;

public class FullZooException extends ZooException{

    public FullZooException(){
        super("Максимальное количество вольеров.");
    }
}
