package simpleprojectmanager.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import simpleprojectmanager.Models.Project;
import simpleprojectmanager.ViewModels.InactiveProjectViewModel;

import java.io.IOException;

public class InactiveProjectView extends ProjectView {

    public InactiveProjectView(Project project) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InactiveProjectView.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
        }

        viewModel = new InactiveProjectViewModel(project);
        bind();

    }

    @FXML
    private Button activateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    void activateProject(ActionEvent event) {
        ((InactiveProjectViewModel)viewModel).activateProject();
    }

    @FXML
    void removeProject(ActionEvent event) {
        ((InactiveProjectViewModel)viewModel).removeProject();
    }
}
