package homework11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public Box() {}

    public Box(T[] array) {
        fruits.addAll(Arrays.asList(array));
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public List<T> getFruits() {
        return fruits;
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.0f;
        }
        return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box<?> Box) {
        return getWeight() == Box.getWeight();
    }

    public void pourFruitInto(Box<T> Box) {
        Box.getFruits().addAll(fruits);
        fruits.clear();
    }
}
