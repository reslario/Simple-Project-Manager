package simpleprojectmanager.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import simpleprojectmanager.Models.Project;
import simpleprojectmanager.ViewModels.WorkingOnProjectViewModel;

import java.io.IOException;

public class WorkingOnProjectView extends ProjectView {

    public WorkingOnProjectView(Project project) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkingOnProjectView.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        viewModel = new WorkingOnProjectViewModel(project);
        bind();
    }

    @FXML
    private Button pauseBtn;

    @FXML
    void pauseProject(ActionEvent event) {
        ((WorkingOnProjectViewModel)viewModel).pauseProject();
    }
}
