package sample.principal;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;



public class Principal {
    ObservableList<String> choiceBoxList2 = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Feliz", "Normal", "triste","Enojado");


    @FXML
    AnchorPane anchorPane;
    @FXML
    StackPane stackPane;
    @FXML
    ChoiceBox choiceBox1, choiceBox2;

    @FXML
    private void initialize() {
        choiceBox1.setValue("Normal");
        choiceBox1.setItems(choiceBoxList);
        choiceBox2.setValue("3");
        choiceBox2.setItems(choiceBoxList2);

    }


    public void config(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../config/config.fxml"));
        Scene scene = anchorPane.getScene();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(anchorPane);
            }
        });
        timeline.play();


    }

    public void back1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
        Scene scene = anchorPane.getScene();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(anchorPane);
            }
        });
        timeline.play();
    }
}
