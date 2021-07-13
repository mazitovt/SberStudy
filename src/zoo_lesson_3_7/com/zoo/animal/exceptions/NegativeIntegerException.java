package zoo_lesson_3_7.com.zoo.animal.exceptions;

public class NegativeIntegerException extends Exception{

    private String number;
    public String getNumber(){ return number; }

    public NegativeIntegerException(String number){
        super("Число " + number + " меньше нуля.");
        this.number = number;
    }

//    public String toString(){
//        return this.
//    }

}
