package simpleprojectmanager.Views;

import javafx.scene.image.Image;
import simpleprojectmanager.Models.Project;
import simpleprojectmanager.ViewModels.EditProjectViewModel;

public class EditProjectView extends InputProjectView {

    public static void show(Project project) {
        viewModel = new EditProjectViewModel(project);
        load("InputProjectView");
        stage.setResizable(false);
        stage.setTitle("Edit Project");
        stage.getIcons().add(new Image("pencil.png"));
        stage.show();
    }
}
