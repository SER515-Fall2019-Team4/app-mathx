package main.src.controllers.Listeners;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import main.src.controllers.WorkspaceExtras.AllRectangles;
import main.src.controllers.WorkspaceExtras.SandBoxChildren;

import java.util.Map;

public class SandBoxListeners {


    public void makeDraggable(StackPane operator) {
        //Sandbox Bounds
        int HorizontalBound = 1650;
        int VerticalBound = 480;

        operator.setOnMouseEntered(mouseEvent -> operator.setCursor(Cursor.MOVE));

        //Adjust drag for instant drag
        final double[] deltaX = new double[1];
        final double[] deltaY = new double[1];
        operator.setOnMouseMoved(mouseEvent -> {
            deltaX[0] = operator.getLayoutX() - mouseEvent.getSceneX();
            deltaY[0] = operator.getLayoutY() - mouseEvent.getSceneY();
        });


        //No drag out of bounds
        operator.setOnMouseDragged(mouseEvent -> {

            operator.toFront();

            if (mouseEvent.getSceneX() < -deltaX[0]) {
                operator.setLayoutX(0);
            }
            //Right
            else if (mouseEvent.getSceneX() + operator.getWidth() + deltaX[0] > HorizontalBound) {
                operator.setLayoutX(HorizontalBound - operator.getWidth());
            }
            //Horizontal - In bounds
            else {
                operator.setLayoutX(mouseEvent.getSceneX() + deltaX[0]);
            }
            //Top
            if (mouseEvent.getSceneY() < -deltaY[0]) {
                operator.setLayoutY(1);
            }
            //Bottom
            else if (mouseEvent.getSceneY() + operator.getHeight() + deltaY[0] > VerticalBound) {
                operator.setLayoutY(VerticalBound - operator.getHeight());
            }
            //Vertical - In bounds
            else {
                operator.setLayoutY(mouseEvent.getSceneY() + deltaY[0]);
            }


        });

        operator.setOnMouseReleased(mouseEvent -> {
            Map<Node, Object> nodes1 = SandBoxChildren.formValues(operator);

            Pane sandBox = new Pane();
            sandBox = (Pane) operator.getParent();
            Map<Node, Object> nodes = SandBoxChildren.formValues(sandBox);

            for (Map.Entry<Node, Object> entry : nodes1.entrySet())
                nodes.remove(entry.getKey(), entry.getValue());

            for (Node node : nodes.keySet()) {
                float nodePositionX = (float) node.localToScene(node.getBoundsInLocal()).getMinX();
                float nodePositionY = (float) node.localToScene(node.getBoundsInLocal()).getMinY();
                if (mouseEvent.getSceneX() > nodePositionX && mouseEvent.getSceneX() < nodePositionX + 40)
                    if (mouseEvent.getSceneY() > nodePositionY && mouseEvent.getSceneY() < nodePositionY + 40) {
                        HBox nodeParent;
                        nodeParent = (HBox) node.getParent();
                        int tempIndex = nodeParent.getChildren().indexOf(node);
                        float tempNodeWidth = (float) node.getBoundsInLocal().getWidth();
                        nodeParent.getChildren().add(tempIndex, operator);
                        nodeParent.getChildren().remove(tempIndex + 1);
                        StackPane tempStackPane;
                        tempStackPane = (StackPane) nodeParent.getParent();
                        Rectangle tempRectangle;
                        tempRectangle = (Rectangle) tempStackPane.getChildren().get(0);
                        float tempRectangleWidth = (float) tempRectangle.getWidth();
//                        tempRectangle.setWidth(tempRectangleWidth + operator.getWidth() - tempNodeWidth);
                        tempRectangle.setWidth(500);
                    }
            }


            Map<Node, Object> allRectangles = AllRectangles.formValues(sandBox);
//            System.out.println(allRectangles);

            System.out.println("------");
        });

        operator.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                Pane sandbox;
                sandbox = (Pane) operator.getParent();
                sandbox.getChildren().remove(operator);
            }
        });


    }

}
