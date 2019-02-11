package simpleprojectmanager.Models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Stopwatch {

    private long elapsedSeconds = 0;
    private Timeline timeline = new Timeline();

    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public Stopwatch()
    {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), evt -> update()));
    }

    public void setElapsedSeconds(long elapsedSeconds) {
        this.elapsedSeconds = elapsedSeconds;
    }

    public long getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void start() {
        timeline.play();
    }

    private void update() {
        elapsedSeconds++;
        changes.firePropertyChange("elapsedSeconds", 0, elapsedSeconds);
    }

    public void stop() {
        timeline.stop();
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }


}
