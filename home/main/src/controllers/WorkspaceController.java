package main.src.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;


public class WorkspaceController implements Initializable {

    @FXML
    private StackPane operator;

    public void setOperator(StackPane operator) {
        this.operator = operator;

        final double[] deltaX = new double[1];
        final double[] deltaY = new double[1];
        deltaX[0]=operator.getLayoutX()-422;
        deltaY[0]=operator.getLayoutX()-330;
        System.out.println(deltaX[0]);System.out.println(deltaY[0]);

        operator.setOnMouseClicked(mouseEvent -> {
            deltaX[0]=operator.getLayoutX()-mouseEvent.getSceneX();
            deltaY[0]=operator.getLayoutY()-mouseEvent.getSceneY();  /*190,110*/ /*232,220*/
            System.out.println(deltaX[0]);System.out.println(deltaY[0]);
        });

        operator.setOnMouseDragged(mouseEvent -> {
            operator.setLayoutX(mouseEvent.getSceneX()+deltaX[0]);
            operator.setLayoutY(mouseEvent.getSceneY()+deltaY[0]);  /*190,110*/ /*232,220*/
            System.out.println(deltaX[0]);System.out.println(deltaY[0]);
        });


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setOperator(operator);
    }
}