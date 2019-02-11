/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleprojectmanager.ViewModels;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import simpleprojectmanager.Models.Project;
import simpleprojectmanager.Models.ProjectManager;
import simpleprojectmanager.Views.ActiveProjectView;
import simpleprojectmanager.Views.AddProjectView;
import simpleprojectmanager.Views.InactiveProjectView;
import simpleprojectmanager.Views.WorkingOnProjectView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainViewModel implements PropertyChangeListener {

    private final ListProperty<ActiveProjectView> activeProjects = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ListProperty<InactiveProjectView> inactiveProjects = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ListProperty<WorkingOnProjectView> workingOnProjects = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final BooleanProperty activeAreEmpty = new SimpleBooleanProperty(true);
    private final BooleanProperty inactiveAreEmpty = new SimpleBooleanProperty(true);
    private final BooleanProperty workinOnAreEmpty = new SimpleBooleanProperty(true);


    public MainViewModel() {
        ProjectManager.getInstance().addPropertyChangeListener(this);
    }

    public ListProperty activeProjectsProperty() {
        return activeProjects;
    }

    public ListProperty inactiveProjectsProperty() {
        return inactiveProjects;
    }

    public ListProperty workingOnProjectsProperty() {
        return workingOnProjects;
    }

    public BooleanProperty activeAreEmptyProperty() {
        return activeAreEmpty;
    }

    public BooleanProperty inactiveAreEmptyProperty() {
        return inactiveAreEmpty;
    }

    public BooleanProperty workinOnAreEmptyProperty() {
        return workinOnAreEmpty;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ObservableList newList = (ObservableList) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case "activeProjects":
                regenerateActiveProjectViews(newList);
                activeAreEmpty.set(newList.size() == 0);
                break;
            case "inactiveProjects":
                regenerateInactiveProjectViews(newList);
                inactiveAreEmpty.set(newList.size() == 0);
                break;
            case "workingOnProjects":
                regenerateWorkingOnProjectViews(newList);
                workinOnAreEmpty.set(newList.size() == 0);
                break;
        }
    }

    private void regenerateActiveProjectViews(ObservableList newProjects) {
        ObservableList<ActiveProjectView> newViews = FXCollections.observableArrayList();
        newProjects.forEach(p -> newViews.add(new ActiveProjectView((Project)p)));
        activeProjects.set(newViews);
    }

    private void regenerateInactiveProjectViews(ObservableList newProjects) {
        ObservableList<InactiveProjectView> newViews = FXCollections.observableArrayList();
        newProjects.forEach(p -> newViews.add(new InactiveProjectView((Project)p)));
        inactiveProjects.set(newViews);
    }

    private void regenerateWorkingOnProjectViews(ObservableList newProjects) {
        ObservableList<WorkingOnProjectView> newViews = FXCollections.observableArrayList();
        newProjects.forEach(p -> newViews.add(new WorkingOnProjectView((Project)p)));
        workingOnProjects.set(newViews);
    }

    public void openAddProjectWindow() {
        AddProjectView.show();
    }
}
