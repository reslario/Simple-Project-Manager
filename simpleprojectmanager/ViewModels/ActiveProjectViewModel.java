package simpleprojectmanager.ViewModels;

import simpleprojectmanager.Models.Project;
import simpleprojectmanager.Models.ProjectStatus;

public class ActiveProjectViewModel extends ProjectViewModel {

    public ActiveProjectViewModel(Project project) {
        super(project);
    }

    public void deactivateProject() {
        project.setStatus(ProjectStatus.INACTIVE);
    }

    public void startWorking() {
        project.setStatus(ProjectStatus.WORKING_ON);
    }
}
