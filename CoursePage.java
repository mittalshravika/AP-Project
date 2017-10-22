import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox.*;
import javafx.scene.layout.VBox.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class CoursePage extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Scene CourseView;
		GridPane Course;

		primaryStage.setTitle("Classroom Booking System");

		Course = new GridPane();
		Course.setPadding(new Insets(20, 20, 20, 20));
		Course.setVgap(8);
		Course.setHgap(10);

		Label title = new Label("Course Page");
		
		Label iiitd = new Label("IIIT-D");

		HBox x = new HBox();
		x.getChildren().addAll(title, iiitd);
		x.setAlignment(Pos.CENTER);
		VBox y = new VBox();

		Label Name = new Label("Course Name:");
		GridPane.setConstraints(Name, 0, 0);
		Label Name_D = new Label("Advanced Programming");
		GridPane.setConstraints(Name_D, 1, 0);

		Label Number = new Label("Course Number:");
		GridPane.setConstraints(Number, 0, 1);
		Label Number_D = new Label("CSE201");
		GridPane.setConstraints(Number_D, 1, 1);

		Label Instructor = new Label("Instructor:");
		GridPane.setConstraints(Instructor, 0, 2);
		Label Instructor_D = new Label("Vivek Kumar");
		GridPane.setConstraints(Instructor_D, 1, 2);

		Label Type = new Label("Type of Course:");
		GridPane.setConstraints(Type, 0, 3);
		Label Type_D = new Label("Computer Science");
		GridPane.setConstraints(Type_D, 1, 3);

		Label PCond = new Label("Post Conditions:");
		GridPane.setConstraints(PCond, 0, 4);
		Label PCond_D = new Label("LOL");
		GridPane.setConstraints(PCond_D, 1, 4);

		Label Timings = new Label("Timings");
		GridPane.setConstraints(Timings, 0, 5);
		Label Timings_D = new Label("Mon 11:00 - 12:00 \nTue 11:00 - 12:00 \nThur 12:00 - 1:00");
		GridPane.setConstraints(Timings_D, 1, 5);

		Button Back = new Button("Back");

		//GridPane.setConstraints(SignUpPage, 0, 4);
		//GridPane.setConstraints(SignUpPageButton, 1, 4);


		Course.getChildren().addAll(Name, Name_D, Number, Number_D, Instructor, Instructor_D, Type, Type_D, PCond, PCond_D, Timings, Timings_D);
		y.getChildren().addAll(x, Course, Back); 

		CourseView = new Scene(y, 1000, 600);
		primaryStage.setScene(CourseView);
		primaryStage.show();



	}
}