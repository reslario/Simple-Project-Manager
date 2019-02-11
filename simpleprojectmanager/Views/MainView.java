/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleprojectmanager.Views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import simpleprojectmanager.ViewModels.MainViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class MainView extends StaticLoadView implements Initializable {

    private static final MainViewModel viewModel = new MainViewModel();

    @FXML
    private ScrollPane workingOnScp;

    @FXML
    private VBox workingonVbx;

    @FXML
    private ScrollPane activeScp;

    @FXML
    private VBox activeVbx;

    @FXML
    private ScrollPane inactiveScp;

    @FXML
    private VBox inactiveVbx;

    @FXML
    private Label workinOnPresenceLbl;

    @FXML
    private Label activePresenceLbl;

    @FXML
    private Label inactivePresenceLbl;

    @FXML
    void addProject(ActionEvent event) {
        viewModel.openAddProjectWindow();
    }

    public static void show() {
        load("MainView");
        stage.setResizable(false);
        stage.setTitle("Simple Project Manager");
        stage.getIcons().add(new Image("icon.png"));
        stage.show();
    }

    public void bind(){
        Bindings.bindContent(workingonVbx.getChildren(), viewModel.workingOnProjectsProperty());
        Bindings.bindContent(activeVbx.getChildren(), viewModel.activeProjectsProperty());
        Bindings.bindContent(inactiveVbx.getChildren(), viewModel.inactiveProjectsProperty());
        workinOnPresenceLbl.visibleProperty().bind(viewModel.workinOnAreEmptyProperty());
        activePresenceLbl.visibleProperty().bind(viewModel.activeAreEmptyProperty());
        inactivePresenceLbl.visibleProperty().bind(viewModel.inactiveAreEmptyProperty());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bind();
    }
}
