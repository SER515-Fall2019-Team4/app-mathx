package main.src.controllers.Grades;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public interface GradeParent {
    void produceWorkspace(Pane sandbox, VBox expressionPane);
}