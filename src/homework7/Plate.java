package homework7;

public class Plate {
    private int amountFood;

    public Plate(int amountFood) {
        setAmountFood(amountFood);
    }

    public int getAmountFood() {
        return this.amountFood;
    }

    private void setAmountFood(int amountFood) {
        if (amountFood < 0) {
            System.out.println("В миске не может быть отрицательное кол-во еды!");
        } else {
            this.amountFood = amountFood;
        }
    }

    public void printInfo() {
        System.out.println("Кол-во еды в миске: " + getAmountFood() + "кг");
    }

    public void decreaseFood(int amountFood) {
        setAmountFood(getAmountFood() - amountFood);
    }

    public void addFood(int amountFood) {
        setAmountFood(getAmountFood() + amountFood);
        System.out.println("В миску добавили " + amountFood + "кг еды");
    }
}
