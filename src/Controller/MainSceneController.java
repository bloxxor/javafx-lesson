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

        boolean gameOver = false;

        int playerWin = 0;
        int enemyWin = 0;
        int rounds = 0;

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

        do {

            int enemySetDamage = random.nextInt(enemyHigh - enemyLow) + enemyLow;
            int playerSetDamage = random.nextInt(playerHigh - playerLow) + playerLow;

            int enemyReceived = playerSetDamage - enemyDefense;
            if (enemyReceived < 0) {
                enemyReceived = 0;
            }
            enemyHealthPoints = enemyHealthPoints - enemyReceived;

            int playerReceived = enemySetDamage - playerDefense;
            if (playerReceived < 0) {
                playerReceived = 0;
            }
            playerHealthPoints = playerHealthPoints - playerReceived;

            outputResult.appendText("Player gives damage: " + enemyReceived + " \nEnemy HP: " + enemyHealthPoints + "\n");
            outputResult.appendText("Enemy gives damage: " + playerReceived + " \nPlayer HP: " + playerHealthPoints + "\n");

            if (playerHealthPoints <= 0) {
                enemyWin++;
                outputResult.appendText("Player Dies!\n");
                outputResult.appendText("Game over after " + rounds + " Rounds");
                gameOver = true;
            }
            if (enemyHealthPoints <= 0) {
                playerWin++;
                outputResult.appendText("Monster Dies!\n");
                outputResult.appendText("Game over after " + rounds + " Rounds");
                gameOver = true;
            }

            rounds++;

        } while (!gameOver);



    }



}
