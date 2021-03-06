package homework7;

import java.util.Random;

public class Cat {
    private String name;
    private boolean isTheCatFull;
    Random random = new Random();

    public Cat(String name) {
        setName(name);
        setTheCatFull(false);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTheCatFull() {
        return this.isTheCatFull;
    }

    private void setTheCatFull(boolean theCatFull) {
        this.isTheCatFull = theCatFull;
    }

    public void eat(Plate plate) {
        int appetite = getAppetite();

        if (isTheCatFull()) {
            System.out.println(getName() + " - уже сыт");
        }
        else if (appetite <= plate.getAmountFood()){
            plate.decreaseFood(appetite);
            System.out.println(getName() + " поел " + appetite + "кг и наелся");
            setTheCatFull(true);
        }
        else {
            System.out.println("Недостаточно еды для " + getName() + "a");
        }
    }

    private int getAppetite() {
        return random.nextInt(4) + 3;
    }
}
