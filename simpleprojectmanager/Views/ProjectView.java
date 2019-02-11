package simpleprojectmanager.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import simpleprojectmanager.ViewModels.ProjectViewModel;

public abstract class ProjectView extends Pane {

    protected ProjectViewModel viewModel;

    public ProjectView() {
    }

    @FXML
    private Label titleLbl;

    @FXML
    private Label descLbl;

    @FXML
    private Label timespentLbl;

    @FXML
    void editProject(MouseEvent event) {
        viewModel.editProject();
    }

    public void bind() {
        titleLbl.textProperty().bind(viewModel.nameProperty());
        descLbl.textProperty().bind(viewModel.descriptionProperty());
        timespentLbl.textProperty().bind(viewModel.timespentProperty());
    }
}
