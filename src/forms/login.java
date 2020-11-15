/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class login extends Application {

  
    
    
    @Override
    public void start(Stage primaryStage) {
    
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(15));
    pane.setHgap(5);
    pane.setVgap(5);
    pane.setStyle("-fx-background-color: wheat");
   
    Text text1 = new Text("Welcome");
    text1.setFont(Font.font("times", FontWeight.BOLD, 20));
    text1.setFill(Color.DARKRED);
     pane.add(text1, 0, 0);
     GridPane.setHalignment(text1, HPos.RIGHT);
     
    ImageView image1 = new ImageView(new Image("https://picsum.photos/200"));
    pane.add(image1, 1, 1);
    
    pane.add(new Label("user name:"), 0, 2);
    pane.add(new TextField(), 1, 2);
    pane.add(new Label("password:"), 0, 3);
    pane.add(new TextField(), 1, 3);
   
    Button signin = new Button("sign in");
    pane.add(signin, 1, 4);
    GridPane.setHalignment(signin, HPos.RIGHT);
    
    
    Scene scene = new Scene(pane);
    primaryStage.setTitle("JavaFX Welcome!");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    
    
    
    }
    public static void main(String[] args) {
        launch(args);
    }
}
