package zoo_lesson_3_7.com.zoo.exceptions;

public class NonExistingEnclosureException extends ZooException {

    public NonExistingEnclosureException(String name) {
        super("Вольера с именем " + name + " не существует.");
    }
}
