package Controller;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class MainSceneController {

    public Label mainTitle;
    public Label subTitle;
    public Button mainButton;

    public TextField strengthInput;
    public Pane textOutput;

    public void buttonClicked() {

        System.out.println("Button clicked!");
        System.out.println(strengthInput.getText());



    }

}
