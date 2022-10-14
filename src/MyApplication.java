import Controller.MainSceneController;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application {

    Stage primaryStage;

    public static void run(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("My Application");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(true);

        //createScene();
        loadScene();
        primaryStage.show();

    }

    public void createScene() {

        Label helloWorldLabel = new Label("Hello World!");
        helloWorldLabel.setAlignment(Pos.CENTER);

        Scene primaryScene = new Scene(helloWorldLabel);
        primaryStage.setScene(primaryScene);

    }

    public void loadScene() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/MainScene.fxml"));

        MainSceneController controller = loader.getController();
        AnchorPane pane = loader.load();

        Scene primaryScene = new Scene(pane);
        primaryStage.setScene(primaryScene);

    }

}
