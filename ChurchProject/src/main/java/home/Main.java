package home;

import javafx.application.Application;
import javafx.css.Style;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double x,y;

    @Override
    public void start(Stage primaryStage) throws Exception{
        String fxmlFile = "/fxml/main.fxml";

        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setScene(new Scene(root));
        root.setOnMousePressed(mouseEvent -> {

            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();


        });
        root.setOnMouseDragged(mouseEvent -> {

            primaryStage.setX(mouseEvent.getSceneX() - x);
            primaryStage.setY(mouseEvent.getSceneY() - y);

        });
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
