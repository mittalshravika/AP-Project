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

public class RequestPage extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Scene RequestScene;
		GridPane grid;
		primaryStage.setTitle("Classroom Booking System");

		grid = new GridPane();

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		//Title 
		Label Title = new Label("REQUEST");
		//sGridPane.setHalignment(Title, HPos.RIGHT);
		//GridPane.setConstraints(Title, 3, 0);

		//Purpose
		Label Purpose = new Label("Purpose:");
		GridPane.setConstraints(Purpose, 0, 2);
		TextField Purpose_input = new TextField();
		GridPane.setConstraints(Purpose_input, 1, 2, 4, 1);

		//Preferred Room
		Label Preferred = new Label("Preferred Room:");
		GridPane.setConstraints(Preferred, 0, 3);
		TextField Preferred_input = new TextField();
		GridPane.setConstraints(Preferred_input, 1, 3);

		//Capacity
		Label Capacity = new Label("Capacity:");
		GridPane.setConstraints(Capacity, 0, 4);
		TextField Capacity_input = new TextField();
		GridPane.setConstraints(Capacity_input, 1, 4);

		//date
		Label Date = new Label("Date:");
		GridPane.setConstraints(Date, 0, 5);
		DatePicker checkInDatePicker = new DatePicker();
		GridPane.setConstraints(checkInDatePicker, 1, 5);

		// Time
		Label Time = new Label("Time:");
		GridPane.setConstraints(Time, 2, 5);
		ChoiceBox<String> Hours = new ChoiceBox<>();
		Hours.setPrefWidth(100);
		Hours.getItems().addAll("1" , "2" , "3" , "4", "5", "6" ,"7" ,"8", "9", "11", "12");
		Hours.setValue("1");
		GridPane.setConstraints(Hours, 3, 5);

		ChoiceBox<String> Minutes = new ChoiceBox<>();
		Minutes.getItems().addAll("00", "15", "30", "45");
		Minutes.setValue("00");
		GridPane.setConstraints(Minutes, 4, 5);
		

		ChoiceBox<String> M = new ChoiceBox<>();
		M.getItems().addAll("a.m.", "p.m.");
		M.setValue("p.m.");
		GridPane.setConstraints(M, 5, 5);

		//Duration
		Label Duration = new Label("Duration(Minutes):");
		GridPane.setConstraints(Duration, 0, 6);
		TextField Duration_input = new TextField();
		GridPane.setConstraints(Duration_input, 1, 6);


		//Submit
		Button Submit = new Button("Submit");
		GridPane.setConstraints(Submit, 3, 7);
		
		Button btn3 = new Button("Back");
		GridPane.setConstraints(btn3, 0, 30);
		
		btn3.setOnAction(e -> {new student_Page().start(primaryStage);});

		grid.getChildren().addAll(Title, Purpose, Purpose_input, Preferred, Preferred_input, Capacity, Capacity_input, Date, Hours, Minutes, M, Duration_input, Time, Duration, Submit, checkInDatePicker, btn3);
		//GridPane.setC(checkInDatePicker, 1, 5);
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		VBox y = new VBox();
		y.setAlignment(Pos.TOP_CENTER);
		y.getChildren().addAll(l, Title, grid);
		
		y.setStyle("-fx-background-color: #00DDDD");

		RequestScene = new Scene(y, 1000, 600);			
		RequestScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(RequestScene);
		primaryStage.show();

	}
}