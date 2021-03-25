package homework11;

public class Orange extends Fruit {
    private final float weight = 1.5f;

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange";
    }
}
