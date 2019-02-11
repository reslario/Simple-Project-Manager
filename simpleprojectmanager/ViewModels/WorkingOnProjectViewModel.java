package simpleprojectmanager.ViewModels;

import simpleprojectmanager.Models.Project;
import simpleprojectmanager.Models.ProjectStatus;

import java.beans.PropertyChangeEvent;

public class WorkingOnProjectViewModel extends ProjectViewModel {

    public WorkingOnProjectViewModel(Project project) {
        super(project);
    }

    public void pauseProject() {
        project.setStatus(ProjectStatus.ACTIVE);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);

        if (evt.getPropertyName().equals("timespent"))
                timespent.set(evt.getNewValue().toString());
    }
}
