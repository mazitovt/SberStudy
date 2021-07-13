package zoo_lesson_3_7.com.zoo.exceptions;

public class ExistingEnclosureException extends ZooException{

    public ExistingEnclosureException(String name){
        super("Вольер с именем " + name + " уже существует.");
    }
}
