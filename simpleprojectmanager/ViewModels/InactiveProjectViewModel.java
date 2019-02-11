package simpleprojectmanager.ViewModels;

import simpleprojectmanager.Models.Project;
import simpleprojectmanager.Models.ProjectStatus;
import simpleprojectmanager.Views.ConfirmDeletionView;

public class InactiveProjectViewModel extends ProjectViewModel {

    public InactiveProjectViewModel(Project project) {
        super(project);
    }

    public void activateProject() {
        project.setStatus(ProjectStatus.ACTIVE);
    }

    public void removeProject() {
        ConfirmDeletionView.show(project);
    }
}
