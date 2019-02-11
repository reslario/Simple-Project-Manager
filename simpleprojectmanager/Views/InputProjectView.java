package simpleprojectmanager.Views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import simpleprojectmanager.ViewModels.EditProjectViewModel;
import simpleprojectmanager.ViewModels.InputProjectViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class InputProjectView extends StaticLoadView implements Initializable {

    protected static InputProjectViewModel viewModel;

    @FXML
    protected TextField nameTxf;

    @FXML
    protected TextArea descTxa;

    @FXML
    void confirmInput() {
        viewModel.confirmInput(nameTxf.getText(), descTxa.getText());
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (viewModel instanceof EditProjectViewModel) {
            nameTxf.setText(((EditProjectViewModel) viewModel).getProjectName());
            descTxa.setText(((EditProjectViewModel) viewModel).getProjectDesc());
        }
    }

}
