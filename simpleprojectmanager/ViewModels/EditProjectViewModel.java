package simpleprojectmanager.ViewModels;

import simpleprojectmanager.Models.Project;

public class EditProjectViewModel extends InputProjectViewModel {

    private Project project;

    public EditProjectViewModel(Project project) {
        this.project = project;
    }

    @Override
    public void confirmInput(String name, String description) {
        project.setName(clean(name));
        project.setDescription(clean(description));
    }

    public String getProjectName() {
        return project.getName();
    }

    public String getProjectDesc() {
        return project.getDescription();
    }

}
