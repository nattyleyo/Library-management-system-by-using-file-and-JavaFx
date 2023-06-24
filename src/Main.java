import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    private static Stage stg;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            System.out.println("Login FXML found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.setTitle("Library Management System");
        primaryStage.setResizable(false);
        Scene scene=new Scene(root,700,580);
        primaryStage.setScene(scene);
        stg = primaryStage;
        primaryStage.show();
    }
    public void changeScene(String fxml,String title,double width,double height,boolean r ) {
        Parent pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource(fxml));
            System.out.println("Scene changer found");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stg.getScene().setRoot(pane);
        stg.setTitle(title);
        stg.setHeight(height);
        stg.setWidth(width);
        stg.centerOnScreen();
        stg.setResizable(r);
        Scene scene=new Scene(pane,width,height);
        stg.setScene(scene);
        stg.show();
    }
}


