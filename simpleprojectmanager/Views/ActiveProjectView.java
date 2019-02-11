package simpleprojectmanager.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import simpleprojectmanager.Models.Project;
import simpleprojectmanager.ViewModels.ActiveProjectViewModel;

import java.io.IOException;

public class ActiveProjectView extends ProjectView {

    public ActiveProjectView(Project project) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ActiveProjectView.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        viewModel = new ActiveProjectViewModel(project);
        bind();
    }

    @FXML
    void deactivateProject(ActionEvent event) {
        ((ActiveProjectViewModel)viewModel).deactivateProject();
    }

    @FXML
    void startWorking(ActionEvent event) {
        ((ActiveProjectViewModel)viewModel).startWorking();
    }
}
