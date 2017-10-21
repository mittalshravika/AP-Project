import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
//import javafx.geometry.Pos;
import javafx.geometry.Insets;
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

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		//Title
		Label Title = new Label("SEARCH");
		GridPane.setHalignment(Title, HPos.CENTER);
		GridPane.setConstraints(Title, 3, 0);
		//
		TextField Search = new TextField();
		GridPane.setConstraints(Search, 3, 1);

		Button Search_Button = new Button("Search");
		GridPane.setHalignment(Search_Button, HPos.RIGHT);
		GridPane.setConstraints(Search_Button, 3, 2);
		grid.getChildren().addAll(Title, Search, Search_Button);
		CourseSearchScene = new Scene(grid, 700, 500);

		primaryStage.setScene(CourseSearchScene);
		primaryStage.show();
	}

}
