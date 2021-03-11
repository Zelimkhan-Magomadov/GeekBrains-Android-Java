package homework8.obstacles;

import homework8.participants.Participant;

public class Track implements Obstacle {
    private int trackLength;

    public Track(int trackLength) {
        setTrackLength(trackLength);
    }

    public int getTrackLength() {
        return this.trackLength;
    }

    private void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    @Override
    public boolean passObstacle(Participant participant) {
        return participant.run(getTrackLength());
    }
}
