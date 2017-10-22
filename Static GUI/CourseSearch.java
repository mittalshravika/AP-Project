import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

public class CourseSearch extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{

		Scene CourseSearchScene;
		GridPane grid;
		primaryStage.setTitle("Classroom Booking System");
		grid = new GridPane();

		//grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		//Title
		Label Title = new Label("SEARCH");
		GridPane.setHalignment(Title, HPos.CENTER);
		GridPane.setConstraints(Title, 3, 0, 1, 1);
		//
		TextField Search = new TextField();
		GridPane.setConstraints(Search, 3, 1, 1, 1);
		Search.setPrefWidth(900);

		Button Search_Button = new Button("Search");
		GridPane.setHalignment(Search_Button, HPos.CENTER);
		GridPane.setConstraints(Search_Button, 3, 2);
		
		Button btn3 = new Button("Back");
		GridPane.setConstraints(btn3, 0, 30);
		
		btn3.setOnAction(e -> {new student_Page().start(primaryStage);});
		
		grid.getChildren().addAll(Title, Search, Search_Button);
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		HBox x = new HBox();
		x.getChildren().add(btn3);
		x.setAlignment(Pos.BOTTOM_LEFT);
		
		VBox y = new VBox();
		y.setPadding(new Insets(20));
		y.setSpacing(50);
		y.setAlignment(Pos.TOP_CENTER);
		y.getChildren().addAll(l, Title, grid, x);
		
		y.setStyle("-fx-background-color: #00DDDD");
		CourseSearchScene = new Scene(y, 1000, 600);
		CourseSearchScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

		primaryStage.setScene(CourseSearchScene);	
		primaryStage.show();
	}

}