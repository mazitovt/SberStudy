package zoo_lesson_3_7.com.zoo.animal.classes;

import zoo_lesson_3_7.com.zoo.animal.exceptions.NegativeIntegerException;

public final class Horse extends Mammal{

    private Boolean canRace;

    public Horse(String name, Integer age, Integer weight, Boolean hasBaby, Boolean canRace) throws NegativeIntegerException {
        super(name, age, weight, hasBaby);
        this.canRace = canRace;
    }

    public Horse() throws NegativeIntegerException {
        this("Бэмби", 7, 50, true, false);
    }

    public Horse(String name, Integer age, Integer weight) throws NegativeIntegerException {
        super(name, age, weight);
    }

    @Override
    public void show() {
        System.out.printf("Имя: %s, Возраст: %d, Вес: %d кг, Жеребята: %s, Скаковая лошадь: %s\n",
                name, age, weight, hasBaby ? "есть" : "нет", canRace ? "да" : "нет");
    }

    @Override
    public void voice() {
        System.out.println("Лошадь " + name + " говорит 'И-го-го'.");
    }

    @Override
    public void move() {
        System.out.println("Лошадь " + name + " скачет.");
    }
}
