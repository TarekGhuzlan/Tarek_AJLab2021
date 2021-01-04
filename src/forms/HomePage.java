/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class HomePage extends Application {
	
   
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

      Pane page = new Pane();
     page.setPrefSize(600, 600);
      
      double w = 600;
      double h = 600;
      
      Image i1 = new Image("file:///C:\\Users\\User\\Documents\\fall sem\\advanced Java\\slide0.jpg"
              ,w, h, true, true);
       
      Image i2 = new Image("file:///C:\\Users\\User\\Documents\\fall sem\\advanced Java\\slide1.jpg"
              ,w, h, true, true);
    ImageView image1 = new ImageView(i1);
            
    ImageView image2 = new ImageView(i2);
           

    
    
            FadeTransition ft1 =  new FadeTransition(Duration.millis(4000), image1);
    ft1.setFromValue(1.0);
    ft1.setToValue(0.0);
   ft1.setCycleCount(Timeline.INDEFINITE);
  ft1.setAutoReverse(true);
    
ft1.play(); 

           FadeTransition ft2 =  new FadeTransition(Duration.millis(4000), image2);
    ft2.setFromValue(1.0);
    ft2.setToValue(0.0);
    ft2.setCycleCount(Timeline.INDEFINITE);
    ft2.setAutoReverse(true);
    ft2.setDelay(Duration.millis(3500)); 
  ft2.play(); 
 

   page.getChildren().addAll(image1, image2);
    
   
   Button log = new Button("log in");
   log.setOnMouseClicked(e ->{ 
            
           GridPane pane = new GridPane();
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
     
    ImageView im = new ImageView(new Image("https://picsum.photos/200"));
    pane.add(im, 1, 1);
    
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
    
   
    } );
   
   
   
   
   
   
   
   
   
   
    Button reg = new Button("registeration");
      reg.setOnMouseClicked(p ->{
          
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
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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
          
          
          
          
      } );
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  HBox H1 = new HBox(60);
  H1.getChildren().addAll(log, reg);
   
   H1.setAlignment(Pos.CENTER);
   H1.setPadding(new Insets(20));

   
   
   
   VBox V1 = new VBox(20);
   V1.getChildren().addAll(page, H1);
   
   

      Scene scene = new Scene(V1, 600, 550);
      primaryStage.setTitle("");
      primaryStage.setScene(scene);
      primaryStage.show(); 
  }    
public static void main(String[] args) { 
    launch(args);
  }
  }
   
   
    
    
     