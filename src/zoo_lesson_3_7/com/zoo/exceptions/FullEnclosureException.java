package zoo_lesson_3_7.com.zoo.exceptions;

public class FullEnclosureException extends EnclosureException {

    public FullEnclosureException(String enclosureName){
        super();
        this.enclosureName = enclosureName;
    }

    public String getMessage(){
        return String.format("В вольер %s больше нельзя добавить животных.", enclosureName);
    }
}
