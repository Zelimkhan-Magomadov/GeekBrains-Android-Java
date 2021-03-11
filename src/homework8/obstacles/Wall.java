package homework8.obstacles;

import homework8.participants.Participant;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        setHeight(height);
    }

    public int getHeight() {
        return this.height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean passObstacle(Participant participant) {
        return participant.jump(getHeight());
    }
}
