/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class registeration extends Application {
	
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

      GridPane form = new GridPane();
      form.setVgap(10);
      form.setHgap(10);
      form.setPadding(new Insets(20));
    
      
          
  
      
      TextField name = new  TextField();

    form.add(new Label("name:") , 0, 0);
    form.add(name , 1, 0);
      
    
  
        TextField mail = new  TextField();
  
    form.add(new Label("mail:") , 0, 1);
    form.add(mail , 1, 1);
      
      
      
        TextField phone = new  TextField();
 
    
    form.add(new Label("phone:") , 0, 2);
    form.add(phone , 1, 2);
   
    
        PasswordField password = new PasswordField();
      password.setOnKeyReleased(z ->{
          if(!z.getCharacter().matches("[\\sa-zA-Z*]"))
          {z.consume();}
         
      }
     );  
    form.add(new Label("password:") , 0, 3);
    form.add(password , 1, 3); 
    
   
        PasswordField cpassword = new PasswordField();  
    form.add(new Label("confirm password:") , 0, 4);
    form.add(cpassword , 1, 4); 
    
    
    
      ComboBox<String> country = new ComboBox<String>();
	        country.getItems().addAll("lebanon", "palestine", "USA");
                
            country.setPromptText("select");
    form.add(new Label("country:") , 0, 5);
    form.add(country , 1, 5);  
      
      
    RadioButton m = new RadioButton("male");
    RadioButton f = new RadioButton("female");  
    
    final ToggleGroup group = new ToggleGroup();
    m.setToggleGroup(group);
    f.setToggleGroup(group);  
      
    HBox gender = new HBox(5);
    gender.getChildren().addAll(m, f);
    
    form.add(new Label("gender:") , 0, 6);
    form.add(gender, 1, 6);
      
    
      CheckBox a = new CheckBox("arabic"); CheckBox en = new CheckBox("english"); CheckBox s = new CheckBox("spanish"); 
    
     HBox language = new HBox(5);
    language.getChildren().addAll(a, en, s); 
    
    form.add(new Label("language:") , 0, 7);
    form.add(language, 1, 7);
    
    TextArea about = new TextArea();
    about.setPromptText("your biography");
    about.setPrefWidth(300);
    about.setPrefRowCount(4);
    
    form.add(new Label("about you:") , 0, 8);
    form.add(about, 1, 8);
    
    Button register = new Button("register");
    register.setMaxWidth(Double.MAX_VALUE);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    register.setOnAction(e ->{
      
                Text t1 = new Text("");
        t1.setStyle("-fx-fill: red");
        Text t2 = new Text("");
        t2.setStyle("-fx-fill: red");
        Text t3 = new Text("");
        t3.setStyle("-fx-fill: red");
        Text t4 = new Text("");
        t4.setStyle("-fx-fill: red");
        Text t5 = new Text("");
        t5.setStyle("-fx-fill: red");
        Text t6 = new Text("");
        t6.setStyle("-fx-fill: red");
        Text t7 = new Text("");
        t7.setStyle("-fx-fill: red");
        
        VBox vbox = new VBox(10);
    
     vbox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE
             , CornerRadii.EMPTY, Insets.EMPTY)));   
    vbox.getChildren().addAll(t1, t2, t3, t4, t5, t6 ,t7); 
    form.add(vbox, 0, 10);
          form.setColumnSpan(vbox, 2);
      
      
          
        if(!name.getText().matches("[a-zA-Z]+")) {
        t1.setText("name must contain only letters");}
           
           else vbox.getChildren().remove(t1);
           
  if(!mail.getText().contains("@") && !mail.getText().contains(".")) {
          t2.setText("Invalid email");}
           
           else vbox.getChildren().remove(t2);
     
      if(!phone.getText().matches("\\d*") || phone.getText().length() != 8) {
          t3.setText("phone number must be 8 digits");}  
         
           else vbox.getChildren().remove(t3);
      
        if(password.getText().length() < 8)
        { t4.setText("minimum password length is 8");}
           
           else vbox.getChildren().remove(t4);   
        
           if(!password.getText().contentEquals(cpassword.getText()))
           { t5.setText("password doesn't match");}
           else vbox.getChildren().remove(t5);
           
           
            if(country.getSelectionModel().isEmpty())
            { t6.setText("country is required"); }
              
           else vbox.getChildren().remove(t6);
            
           if(about.getText().length() < 50)
           { t7.setText("biography must be longer");}
              
           else vbox.getChildren().remove(t7);
           
           
           
           if(vbox.getChildren().isEmpty())
            { 
                Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Registration Successful!");
        alert.setContentText("Welcome " + name.getText());
        alert.initOwner(form.getScene().getWindow());
        alert.show();
            }
         
           
    });
    form.add(register, 0, 9);
    form.setColumnSpan(register, 2);

      


      Scene scene = new Scene(form, 450, 650);
      primaryStage.setTitle("registeration");
      primaryStage.setScene(scene);
      primaryStage.show(); 
  }    
  
public static void main(String[] args) { 
    launch(args);
  }
  

  

}