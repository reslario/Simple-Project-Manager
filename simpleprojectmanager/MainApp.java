/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleprojectmanager;

import javafx.application.Application;
import javafx.stage.Stage;
import simpleprojectmanager.Models.ProjectManager;
import simpleprojectmanager.Views.MainView;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        MainView.show();
        ProjectManager.getInstance().loadProjects();
    }

    @Override
    public void stop() throws Exception {
        ProjectManager.getInstance().saveProjects();
        Thread.sleep(1000);
        super.stop();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
