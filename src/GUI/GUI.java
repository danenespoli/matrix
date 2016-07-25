package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by danenespoli on 4/6/16.
 */
public class GUI extends Application {
    Stage window;
    Scene scene1, scene2;

    public GUI() {}

    public void begin(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Matrix");
        Button btn = new Button();
        btn.setText("Solve System");
        btn.setOnAction(e -> System.out.println("Hello World!"));
        btn.setLayoutX(0);
        btn.setLayoutY(0);
        TextArea text = new TextArea();
        text.setLayoutX(0);
        text.setLayoutY(100);


        Pane root = new Pane();
        root.getChildren().addAll(btn, text);
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.show();
    }
}

