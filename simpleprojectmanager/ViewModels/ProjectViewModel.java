package simpleprojectmanager.ViewModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import simpleprojectmanager.Models.Project;
import simpleprojectmanager.Views.EditProjectView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class ProjectViewModel implements PropertyChangeListener {

    protected Project project;

    protected StringProperty name = new SimpleStringProperty();
    protected StringProperty description = new SimpleStringProperty();
    protected StringProperty timespent = new SimpleStringProperty();

    public ProjectViewModel(Project project) {
        this.project = project;
        name.set(project.getName());
        description.set(project.getDescription());
        project.addPropertyChangeListener(this);
        timespent.set(project.getTimespentHours());
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty timespentProperty() {
        return timespent;
    }

    public Project getProject() {
        return project;
    }

    public void editProject() {
        EditProjectView.show(project);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "name":
                name.set(evt.getNewValue().toString());
                break;
            case "description":
                description.set(evt.getNewValue().toString());
                break;
        }
    }
}
