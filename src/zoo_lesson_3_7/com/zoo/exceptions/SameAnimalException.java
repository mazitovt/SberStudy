package zoo_lesson_3_7.com.zoo.exceptions;

public class SameAnimalException extends EnclosureException{

    private String animalName;

    public SameAnimalException(String animalName, String name){
        super();
        this.animalName = animalName;
        this.enclosureName = name;
    }

    public String getMessage(){
        return String.format("В вольере %s уже существует такое животное.\nЖивотное: %s", enclosureName, animalName);
    }

}
