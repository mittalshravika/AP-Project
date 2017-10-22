import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class RequestList extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage primaryStage)
	{
		ScrollPane sp;
		GridPane Table;
		Scene RequestScene;
		primaryStage.setTitle("Classroom Booking System");

		//Title
		Label Title = new Label("STUDENT REQUESTS");

		//Table
		Table = new GridPane();
		Table.setPadding(new Insets(20, 20, 20, 20));
		
		//Index
		TextField T1 = new TextField("Serial Number");
		TextField T2 = new TextField("Date");
		TextField T3 = new TextField("Time");
		TextField T4 = new TextField("Duration");
		TextField T5 = new TextField("Name");
		TextField T6 = new TextField("Purpose");
		TextField T7 = new TextField("Room");
		TextField T8 = new TextField("Capacity");
		TextField T9 = new TextField("Approval");
		Table.add(T1, 0, 0, 1, 1);
		Table.add(T2, 1, 0, 1, 1);
		Table.add(T3, 2, 0, 1, 1);
		Table.add(T4, 3, 0, 1, 1);
		Table.add(T5, 4, 0, 1, 1);
		Table.add(T6, 5, 0, 1, 1);
		Table.add(T7, 6, 0, 1, 1);
		Table.add(T8, 7, 0, 1, 1);
		Table.add(T9, 8, 0, 1, 1);

		//ChoiceBox
		ChoiceBox<String> Approval = new ChoiceBox<>();
		Approval.getItems().addAll("Pending", "Approve", "Cancel");
		Approval.setValue("Pending");
		Table.add(Approval, 8, 1, 1, 1);

		sp = new ScrollPane();
		sp.setContent(Table);

		VBox elements = new VBox();
		elements.getChildren().addAll(Title, Table);
		RequestScene = new Scene(elements, 700, 500);
		primaryStage.setScene(RequestScene);
		primaryStage.show();


	}
}