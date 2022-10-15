package Controller;

import javafx.scene.control.*;

import java.util.Random;

public class MainSceneController {

    public Button mainButton;

    public TextField playerLevelInput;
    public TextField enemyLevelInput;
    public TextField playerStrengthInput;
    public TextField enemyStrengthInput;
    public TextField playerDefenseInput;
    public TextField enemyDefenseInput;
    public TextArea outputResult;

    public void buttonClicked() {

        outputResult.setText("");

//        int playerLevel = Integer.parseInt(playerLevelInput.getText());
        int playerStrength = Integer.parseInt(playerStrengthInput.getText());
        int playerDefense = Integer.parseInt(playerDefenseInput.getText());

//        int enemyLevel = Integer.parseInt(enemyLevelInput.getText());
        int enemyStrength = Integer.parseInt(enemyStrengthInput.getText());
        int enemyDefense = Integer.parseInt(enemyDefenseInput.getText());

        Random random = new Random();

        int playerLow = playerStrength - 10;
        int playerHigh = playerStrength + 10;
        int playerHealthPoints = 100;

        int enemyHigh = enemyStrength + 10;
        int enemyLow = enemyStrength - 10;
        int enemyHealthPoints = 100;

        for (int i = 0; i < 10; i++) {

            int enemySetDamage = random.nextInt(enemyHigh - enemyLow) + enemyLow;
            int playerSetDamage = random.nextInt(playerHigh - playerLow) + playerLow;

            int enemyReceived = playerSetDamage - enemyDefense;
            if (enemyReceived < 0 ) {
                enemyReceived = 0;
            }
            enemyHealthPoints = enemyHealthPoints - enemyReceived;

            int playerReceived = enemySetDamage - playerDefense;
            if (playerReceived < 0 ) {
                playerReceived = 0;
            }
            playerHealthPoints = playerHealthPoints - playerReceived;

            outputResult.appendText("Player gives damage: " + enemyReceived + " Enemy HP: " + enemyHealthPoints + "\n");
            outputResult.appendText("Enemy gives damage: " + playerReceived + " Player HP: " + playerHealthPoints + "\n");

        }

    }

}
