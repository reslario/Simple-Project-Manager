package simpleprojectmanager.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import simpleprojectmanager.Models.Project;
import simpleprojectmanager.ViewModels.ConfirmDeletionViewModel;

public class ConfirmDeletionView extends StaticLoadView {

    private static ConfirmDeletionViewModel viewModel;

    @FXML
    void abortDelete(ActionEvent event) {
        stage.close();
    }

    @FXML
    void confirmDelete(ActionEvent event) {
        viewModel.confirmDelete();
        stage.close();
    }

    public static void show(Project project) {
        load("ConfirmDeletionView");
        viewModel = new ConfirmDeletionViewModel(project);
        stage.setTitle("Confirm Deletion");
        stage.getIcons().add(new Image("x.png"));
        stage.setResizable(false);
        stage.show();
    }
}
