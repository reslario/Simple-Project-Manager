package simpleprojectmanager.ViewModels;

import simpleprojectmanager.Models.Project;
import simpleprojectmanager.Models.ProjectManager;

public class ConfirmDeletionViewModel {

    private Project project;

    public ConfirmDeletionViewModel(Project project) {
        this.project = project;
    }

    public void confirmDelete() {
        ProjectManager.getInstance().removeProject(project);
    }
}
