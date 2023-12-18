package com.example.cd_testdinimueter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class Game extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private GraphicsContext gc;
    private Set<KeyCode> pressedKeys = new HashSet<>();

    private int playerHealth = 100;
    private int enemyHealth = 100;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Game");

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        setupInput(scene);
        startGameLoop();
    }

    private void setupInput(Scene scene) {
        scene.setOnKeyPressed(event -> pressedKeys.add(event.getCode()));
        scene.setOnKeyReleased(event -> pressedKeys.remove(event.getCode()));
    }

    private void startGameLoop() {
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                update();
                draw();
            }
        }.start();
    }

    private void update() {
        // Update game logic here
        if (pressedKeys.contains(KeyCode.SPACE)) {
            // Handle spacebar press
        }
        // Add other game logic
    }

    private void draw() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // Draw game elements
        drawPlayerHealth();
        drawEnemyHealth();
        // Add more drawing code
    }

    private void drawPlayerHealth() {
        gc.setFill(Color.GREEN);
        gc.setFont(new Font("Arial", 20));
        gc.fillText("Player Health: " + playerHealth, 10, 20);
    }

    private void drawEnemyHealth() {
        gc.setFill(Color.RED);
        gc.setFont(new Font("Arial", 20));
        gc.fillText("Enemy Health: " + enemyHealth, WIDTH - 180, 20);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
