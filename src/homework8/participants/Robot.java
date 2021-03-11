package homework8.participants;

public class Robot implements Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private Sex sex;

    public Robot(String name, int maxRunDistance, int maxJumpHeight, Sex sex) {
        setName(name);
        setMaxRunDistance(maxRunDistance);
        setMaxJumpHeight(maxJumpHeight);
        setSex(sex);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public int getMaxRunDistance() {
        return this.maxRunDistance;
    }

    private void setMaxJumpHeight(int maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public int getMaxJumpHeight() {
        return this.maxJumpHeight;
    }

    private void setSex(Sex sex) {
        this.sex = sex;
    }

    public Sex getSex() {
        return this.sex;
    }
}
