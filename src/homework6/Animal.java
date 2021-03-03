package homework6;

public abstract class Animal {
    private static int animalCounter;

    public Animal() {
        animalCounter++;
    }

    public static int getTotalNumberOfAnimals() {
        return animalCounter;
    }

    public abstract String getName();
    public abstract void voice();
    public abstract void run(int distance);
    public abstract void swim(int distance);
}
