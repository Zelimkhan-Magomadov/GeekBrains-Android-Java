package homework6;

public class Cat extends Animal {
    private static int catCounter;
    private String name;

    public Cat(String name) {
        setName(name);
        catCounter++;
    }

    public static int getTotalNumberOfCats() {
        return catCounter;
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
        System.out.println("Мяу-мяу");
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println(getName() + " - \"У меня лапки, сам беги " + distance + "м.\"");
        } else {
            System.out.println(getName() + " пробежал " + distance + "м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " - \"Не буду я плавать!\"");
    }
}
