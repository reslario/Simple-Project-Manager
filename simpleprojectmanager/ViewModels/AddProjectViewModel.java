package simpleprojectmanager.ViewModels;

import simpleprojectmanager.Models.ProjectManager;

public class AddProjectViewModel extends InputProjectViewModel{

    @Override
    public void confirmInput(String name, String description) {
        ProjectManager.getInstance().addProject(clean(name), clean(description));
    }
}
