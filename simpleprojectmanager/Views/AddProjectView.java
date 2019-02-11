package simpleprojectmanager.Views;

import javafx.scene.image.Image;
import simpleprojectmanager.ViewModels.AddProjectViewModel;

public class AddProjectView extends InputProjectView {

    public static void show() {
        viewModel = new AddProjectViewModel();
        load("InputProjectView");
        stage.setResizable(false);
        stage.setTitle("Add Project");
        stage.getIcons().add(new Image("plus.png"));
        stage.show();
    }
}
