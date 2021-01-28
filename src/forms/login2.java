/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class login2 extends Application {

    
    GridPane pane = new GridPane();
   
      File users = new File("users.txt");
       
             
  
    
    
    @Override
    public void start(Stage primaryStage) {
    
     
        
        
        
        
    pane.setAlignment(Pos.TOP_LEFT);
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
    
    TextField user = new TextField();
    pane.add(new Label("user name:"), 0, 2);
    pane.add(user, 1, 2);
    
    TextField pass = new TextField();
    pane.add(new Label("password:"), 0, 3);
    pane.add(pass, 1, 3);
   
    
    
    Button signin = new Button("sign in");
   signin.setOnAction(e->{
    
          try {
          
         Scanner input =  new Scanner(users);
      
       
       boolean check= false;
       
       
       String user1 = user.getText();
    String pass1 = pass.getText();
    
        input.next();
        input.next();
        input.next();
        input.next();
        input.next();
        
        while(input.hasNext()){
        String user2= input.next();
        String pass2 = input.next();
        if(user1.equalsIgnoreCase(user2) && pass1.equalsIgnoreCase(pass2)){
            
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Signed in successfully");
        alert.initOwner(pane.getScene().getWindow());
        alert.show();
        check = true;
        input.close();
        
        }else if(user1.equalsIgnoreCase(user2)){
            
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The password is incorrect");
        alert.initOwner(pane.getScene().getWindow());
        alert.show();
        check = true;
        input.close();
        }
          else   if(pass1.equalsIgnoreCase(pass2)){
            
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The user name is incorrect");
        alert.initOwner(pane.getScene().getWindow());
        alert.show();
        check = true;
        input.close();
        }
            
        }     
        if(check == false){
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("");
        alert.initOwner(pane.getScene().getWindow());
        alert.show();
        input.close();
        }}  
   
          catch (FileNotFoundException ex) {
              
            System.out.println("Oops. File was not found");
            ex.printStackTrace();
        }
       
          
   });
    
    
    
    
    
    
    
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