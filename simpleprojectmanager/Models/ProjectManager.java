package simpleprojectmanager.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManager {

    private static ProjectManager pm;

    private final ArrayList<Project> projects = new ArrayList<>();
    private static final Path path = Paths.get(".projects");

    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private ObservableList activeProjects = FXCollections.observableArrayList();
    private ObservableList inactiveProjects = FXCollections.observableArrayList();
    private ObservableList workingOnProjects = FXCollections.observableArrayList();

    private ProjectManager() {
    }

    public static ProjectManager getInstance() {
        if (pm == null)
            pm = new ProjectManager();
        return pm;
    }

    public void addProject(String name, String description) {
        projects.add(new Project(name, description));
        regenerateProjects();
    }

    public void removeProject(Project project) {
        projects.remove(project);
        regenerateProjects();
    }

    public void saveProjects() {
        try {
            Files.write(path, String.join("\n", projects.stream().map(Project::toString).toArray(String[]::new)).getBytes());
        } catch (IOException e) {
            System.out.println("oof");
        }
    }

    public void loadProjects() {
        List<String> sProjects = new ArrayList<>();

        if (Files.exists(path)) {
            try {
                sProjects = Files.readAllLines(path);
            } catch (IOException e) {
                System.out.println("oof");
            }
        }

        sProjects.forEach(s -> projects.add(Project.fromString(s)));
        regenerateProjects();
    }

    public void regenerateProjects() {
        ObservableList activeProjectsNew = projects.stream().filter(p -> p.getStatus() == ProjectStatus.ACTIVE).collect(Collectors.toCollection(FXCollections::observableArrayList));
        ObservableList inactiveProjectsNew = projects.stream().filter(p -> p.getStatus() == ProjectStatus.INACTIVE).collect(Collectors.toCollection(FXCollections::observableArrayList));
        ObservableList workingOnProjectsNew = projects.stream().filter(p -> p.getStatus() == ProjectStatus.WORKING_ON).collect(Collectors.toCollection(FXCollections::observableArrayList));
        changes.firePropertyChange("activeProjects", activeProjects, activeProjectsNew);
        changes.firePropertyChange("inactiveProjects", inactiveProjects, inactiveProjectsNew);
        changes.firePropertyChange("workingOnProjects", workingOnProjects, workingOnProjectsNew);
        activeProjects = activeProjectsNew;
        inactiveProjects = inactiveProjectsNew;
        workingOnProjects = workingOnProjectsNew;
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }
}
