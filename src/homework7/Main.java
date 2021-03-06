package homework7;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Plate plate = new Plate(getRandomNumber(5));

        Cat[] cats = {
                new Cat("Матроскин"),
                new Cat("Том"),
                new Cat("Гарфилд")
        };

        for (Cat cat : cats) {
            plate.printInfo();
            cat.eat(plate);

            while (!cat.isTheCatFull()) {
                plate.addFood(getRandomNumber(5));
                plate.printInfo();
                cat.eat(plate);
            }
        }
    }

    public static int getRandomNumber(int max) {
        return random.nextInt(max) + 1;
    }
}
