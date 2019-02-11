package simpleprojectmanager.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StaticLoadView {

    protected static Stage stage;

    protected static void load(String viewName) {
        load(viewName, viewName);
    }

    protected static void load(String viewName, String cssName) {
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(StaticLoadView.class.getResource(viewName + ".fxml"));
        try {
            Parent root = loader.load();
            final Scene scene = new Scene(root);
            scene.getStylesheets().add(cssName + ".css");
            stage.setScene(scene);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
