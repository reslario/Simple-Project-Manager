package simpleprojectmanager.Models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Project implements PropertyChangeListener {

    private String name;
    private String description;
    private Stopwatch stopwatch = new Stopwatch();
    private ProjectStatus status = ProjectStatus.INACTIVE;

    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        stopwatch.addPropertyChangeListener(this);
    }

    private Project(String name, String description, long runTime, ProjectStatus status) {
        this.name = name;
        this.description = description;
        stopwatch.addPropertyChangeListener(this);
        stopwatch.setElapsedSeconds(runTime);
        setStatus(status);
    }

    public static Project fromString(String s) {
        String[] data = s.split("\t");

        return new Project(data[0], data[1], Long.parseLong(data[2]), ProjectStatus.valueOf(data[3]));
    }

    public void setStatus(ProjectStatus status) {
        switch (status) {
            case INACTIVE:
                stopwatch.stop();
                break;
            case ACTIVE:
                stopwatch.stop();
                break;
            case WORKING_ON:
                stopwatch.start();
                break;
        }
        this.status = status;
        ProjectManager.getInstance().regenerateProjects();
    }

    @Override
    public String toString() {
        final char seperator = '\t' ;
        if (status == ProjectStatus.WORKING_ON)
            setStatus(ProjectStatus.ACTIVE);
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(seperator);
        sb.append(description);
        sb.append(seperator);
        sb.append(stopwatch.getElapsedSeconds());
        sb.append(seperator);
        sb.append(status);

        return sb.toString();
    }

    public String getTimespentHours() {
        return getTimespentHoursString(stopwatch.getElapsedSeconds());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        changes.firePropertyChange("name", this.name, name);
        this.name = name;
    }

    public void setDescription(String description) {
        changes.firePropertyChange("description", this.description, description);
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        long elapsedSeconds = (long)evt.getNewValue();

        changes.firePropertyChange("timespent", "", getTimespentFullString(elapsedSeconds));
    }

    private String getTimespentHoursString(long elapsedSeconds) {
        return String.format("%.1f hours spent so far", elapsedSeconds / 60.0 / 60.0);
    }

    private String getTimespentFullString(long elapsedSeconds) {
        long hrs = elapsedSeconds / 60 / 60;
        long mins = elapsedSeconds / 60 - hrs * 60;
        long secs = elapsedSeconds - (mins + hrs * 60) * 60;

        return String.format("%2d hours,\n%2d minutes,\n%2d seconds\nso far", hrs, mins, secs);
    }
}
