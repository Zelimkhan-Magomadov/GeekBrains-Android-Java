package homework8.participants;

public interface Participant {
    String getName();
    Sex getSex();
    int getMaxRunDistance();
    int getMaxJumpHeight();

    default boolean run(int length) {
        String verb = getSex() == Sex.MALE ? "смог" : "смогла";
        String str  = " пробежать дистанцию в " + length + "км";

        if (length <= getMaxRunDistance()) {
            System.out.println(getName() + " " + verb + str + "!");
            return true;
        }
        System.out.println(getName() + " не " + verb + str);

        return false;
    }

    default boolean jump(int height) {
        String verb = getSex() == Sex.MALE ? "смог" : "смогла";
        String str = " перепрыгнуть стену высотой в " + height + "м";

        if (height <= getMaxJumpHeight()) {
            System.out.println(getName() + " " + verb + str + "!");
            return true;
        }
        System.out.println(getName() + " не " + verb + str);
        return false;
    }
}
