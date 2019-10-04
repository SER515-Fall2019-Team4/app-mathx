package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {

    public static Stage signUpStage,loginStage,homePageStage,workspaceStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

          this.signUpStage=primaryStage;
          openSignUpWindow();
    }

    public void openSignUpWindow() {

        try {

            FXMLLoader loader=new FXMLLoader(getClass().getResource("res/view/signup.fxml"));
            GridPane pane=loader.load();
            Scene scene=new Scene(pane);
            signUpStage.setScene(scene);
            signUpStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void openLoginWindow() {

        try {

            FXMLLoader loader=new FXMLLoader(getClass().getResource("res/view/loginPage.fxml"));
            Pane pane=loader.load();
            Scene scene=new Scene(pane);
            loginStage=new Stage();
            loginStage.setScene(scene);
            loginStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openHomePageWindow() {

        try {

            FXMLLoader loader=new FXMLLoader(getClass().getResource("res/view/homepage.fxml"));
            GridPane pane=loader.load();
            Scene scene=new Scene(pane);
            homePageStage=new Stage();
            homePageStage.setScene(scene);
            homePageStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openWorkSpaceWindow() {

        try {

            FXMLLoader loader=new FXMLLoader(getClass().getResource("res/view/workspace.fxml"));
            BorderPane pane=loader.load();
            Scene scene=new Scene(pane);
            workspaceStage=new Stage();
            workspaceStage.setScene(scene);
            workspaceStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}