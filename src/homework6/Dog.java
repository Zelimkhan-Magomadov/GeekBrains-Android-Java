package homework6;

public class Dog extends Animal {
    private static int dogCounter;
    private String name;

    public Dog(String name) {
        setName(name);
        dogCounter++;
    }

    public static int getTotalNumberOfDogs() {
        return dogCounter;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void voice() {
        System.out.println("Гав-гав");
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(getName() + " не может пробежать " + distance + "м.");
        } else {
            System.out.println(getName() + " пробежал " + distance + "м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(getName() + " не может проплыть " + distance + "м.");
        } else {
            System.out.println(getName() + " проплыл " + distance + "м.");
        }
    }
}
