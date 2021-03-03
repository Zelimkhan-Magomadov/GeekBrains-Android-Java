package homework6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Матроскин");
        Dog dog = new Dog("Шарик");

        cat.run(120);
        dog.run(800);

        cat.swim(20);
        dog.swim(7);

        System.out.println("Всего животных - " + Animal.getTotalNumberOfAnimals());
        System.out.println("Всего котов - " + Cat.getTotalNumberOfCats());
        System.out.println("Всего собак - " + Dog.getTotalNumberOfDogs());
    }
}
