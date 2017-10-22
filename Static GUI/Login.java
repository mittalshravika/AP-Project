import javafx.application.Application;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Login extends Application
{
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Scene LoginScene, SignUpScene;
		GridPane grid1, grid2;		
		primaryStage.setTitle("Classroom Booking System");
		
		//Sign Up
		grid2 = new GridPane();
		grid2.setPadding(new Insets(10, 10, 10, 10));
		grid2.setVgap(8);
		grid2.setHgap(10);

		Label name = new Label("IIIT-D");
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_RIGHT);
		
		name.setStyle("-fx-font: normal bold 50px 'serif' ");
		l.setStyle("-fx-font: normal bold 50px 'serif' ");
		
		VBox y = new VBox();
		y.setPadding(new Insets(20));
		
		VBox y2 = new VBox();
		y2.setPadding(new Insets(20));
		
		//Type of User
		Label Type = new Label("Type of User");
		Type.setStyle("-fx-font: normal 20px 'sans-serif' ");
		GridPane.setConstraints(Type, 2, 0);
		ChoiceBox<String> User_Type = new ChoiceBox<>();
		User_Type.setStyle("-fx-color: #FFFFFF ; -fx-font: normal bold 15px 'sans-serif' ; -fx-padding: 5 22 5 22 ; -fx-border-color: #00DDDD ; ");
		User_Type.getItems().addAll("Admin", "Faculty", "Student");
		User_Type.setValue("Student");
		GridPane.setConstraints(User_Type, 3, 0);


		//Name
		Label User_Name = new Label("Name:");
		User_Name.setStyle("-fx-font: normal 20px 'sans-serif' ");
		GridPane.setConstraints(User_Name, 0, 0);
		TextField Name_input = new TextField();
		Name_input.setStyle("-fx-border-color: #00DDDD ; ");
		GridPane.setConstraints(Name_input, 1, 0);

		//Email ID
		Label User_Email_ID = new Label("Email ID");
		User_Email_ID.setStyle("-fx-font: normal 20px 'sans-serif' ");
		GridPane.setConstraints(User_Email_ID, 0, 1);
		TextField User_Email_input = new TextField();
		User_Email_input.setStyle("-fx-border-color: #00DDDD ");
		GridPane.setConstraints(User_Email_input, 1, 1);
		
		//Password
		Label User_Password = new Label("Password:");
		User_Password.setStyle("-fx-font: normal 20px 'sans-serif' ");
		GridPane.setConstraints(User_Password, 0, 2);
		TextField User_Password_input = new TextField();
		User_Password_input.setStyle("-fx-border-color: #00DDDD ");
		GridPane.setConstraints(User_Password_input, 1, 2);
		
		//Retype Password
		Label User_Password_2 = new Label("Retype Password:");
		User_Password_2.setStyle("-fx-font: normal 20px 'sans-serif' ");
		GridPane.setConstraints(User_Password_2, 0, 3);
		TextField User_Password_input_2 = new TextField();
		User_Password_input_2.setStyle("-fx-border-color: #00DDDD ");
		GridPane.setConstraints(User_Password_input_2, 1, 3);

		//Sign Up Button
		Button SignUpButton = new Button("Sign Up");
		SignUpButton.setStyle("-fx-color: #FFFFFF ; -fx-font: normal bold 15px 'sans-serif' ; -fx-padding: 5 22 5 22 ; -fx-border-color: #00DDDD ; ");
		
		
		GridPane.setConstraints(SignUpButton, 1, 4);

		//Login Button
		Label LoginPage = new Label("Already a User?");
		LoginPage.setStyle("-fx-font: normal 20px 'sans-serif' ");
		GridPane.setConstraints(LoginPage, 0, 5);
		Button LoginPageButton = new Button("Login");
		LoginPageButton.setStyle("-fx-color: #FFFFFF ; -fx-font: normal bold 15px 'sans-serif' ; -fx-padding: 5 22 5 22 ; -fx-border-color: #00DDDD ; ");
		//LoginPageButton.setOnAction(e -> primaryStage.setScene(LoginScene));
		GridPane.setConstraints(LoginPageButton, 1, 5);


		grid2.getChildren().addAll(Type, User_Type, User_Name, Name_input, User_Email_ID, User_Email_input, User_Password, User_Password_input, User_Password_2,User_Password_input_2, SignUpButton, LoginPage, LoginPageButton);
		
		y2.getChildren().addAll(l, grid2);
		y2.setAlignment(Pos.TOP_CENTER);
		y2.setSpacing(30);
		
		y2.setStyle("-fx-background-color: #00DDDD ; -fx-text-fill: white");
		y.setStyle("-fx-background-color: #00DDDD ; -fx-text-fill: white");
		
		SignUpScene = new Scene(y2, 1000, 600);
		//Login
		grid1 = new GridPane();
		//grid1.setPadding(new Insets(10, 10, 10, 10));
		grid1.setVgap(8);
		grid1.setHgap(10);

		//Email ID
		Label Email_ID = new Label("Email ID:");
		Email_ID.setStyle("-fx-font: normal 20px 'sans-serif' ");
		GridPane.setConstraints(Email_ID, 0, 0);
		TextField Email_input = new TextField();
		Email_input.setStyle("-fx-border-color: #00DDDD");
		//Email_input.setPromtText("eg. abc@iiitd.ac.in");
		GridPane.setConstraints(Email_input, 1, 0);

		//Password
		Label Password = new Label("Password:");
		Password.setStyle("-fx-font: normal 20px 'sans-serif' ");
		GridPane.setConstraints(Password, 0, 1);
		TextField Password_input = new TextField();
		Password_input.setStyle("-fx-border-color: #00DDDD ");
		GridPane.setConstraints(Password_input, 1, 1);

		//Login button
		Button LoginButton = new Button("Log In");
		LoginButton.setStyle("-fx-color: #FFFFFF ; -fx-font: normal bold 15px 'sans-serif' ; -fx-padding: 5 22 5 22 ; -fx-border-color: #00DDDD ; ");
		GridPane.setConstraints(LoginButton, 1, 3);

		//SignUp button
		Label SignUpPage = new Label("Not Registered yet? Sign Up for free!");
		SignUpPage.setStyle("-fx-font: normal 20px 'sans-serif' ");
		Button SignUpPageButton = new Button("Sign Up");
		SignUpPageButton.setStyle("-fx-color: #FFFFFF ; -fx-font: normal bold 15px 'sans-serif' ; -fx-padding: 5 22 5 22 ; -fx-border-color: #00DDDD ; ");
		SignUpPageButton.setOnAction(e -> primaryStage.setScene(SignUpScene));
		GridPane.setConstraints(SignUpPage, 0, 4);
		GridPane.setConstraints(SignUpPageButton, 1, 4);


		grid1.getChildren().addAll(Email_ID, Email_input, Password, Password_input, LoginButton, SignUpPage, SignUpPageButton);

		y.getChildren().addAll(name, grid1);
		y.setAlignment(Pos.TOP_CENTER);
		y.setSpacing(30);

		LoginScene = new Scene(y, 1000, 600);

		LoginPageButton.setOnAction(e -> primaryStage.setScene(LoginScene));

		primaryStage.setScene(LoginScene);
		primaryStage.show();

	}
} 