import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import javafx.scene.layout.GridPane.*;
import javafx.geometry.Pos;

public class StudentRequest extends Application
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
		Label Title = new Label("Your Requests");

		//Table
		Table = new GridPane();
		Table.setPadding(new Insets(20, 20, 20, 20));
		
		//Index
		TextField T1 = new TextField("Serial Number");
		TextField T2 = new TextField("Date");
		TextField T3 = new TextField("Time");
		TextField T4 = new TextField("Duration");
		TextField T6 = new TextField("Purpose");
		TextField T7 = new TextField("Room");
		TextField T8 = new TextField("Capacity");
		TextField T9 = new TextField("Cancel");
		Table.add(T1, 0, 0, 1, 1);
		Table.add(T2, 1, 0, 1, 1);
		Table.add(T3, 2, 0, 1, 1);
		Table.add(T4, 3, 0, 1, 1);
		//Table.add(T5, 4, 0, 1, 1);
		Table.add(T6, 4, 0, 1, 1);
		Table.add(T7, 5, 0, 1, 1);
		Table.add(T8, 6, 0, 1, 1);
		Table.add(T9, 7, 0, 1, 1);

		//example
		TextField t1 = new TextField("1");
		TextField t2 = new TextField("02/11/2017");
		TextField t3 = new TextField("17:00");
		TextField t4 = new TextField("120");
		TextField t6 = new TextField("Byld Session");
		TextField t7 = new TextField("C01");
		TextField t8 = new TextField("170");
		TextField t9 = new TextField("Cancel");
		Table.add(t1, 0, 1, 1, 1);
		Table.add(t2, 1, 1, 1, 1);
		Table.add(t3, 2, 1, 1, 1);
		Table.add(t4, 3, 1, 1, 1);
		//Table.add(t5, 4, 0, 1, 1);
		Table.add(t6, 4, 1, 1, 1);
		Table.add(t7, 5, 1, 1, 1);
		Table.add(t8, 6, 1, 1, 1);
		//Table.add(t9, 6, 1, 1, 1);

		CheckBox Approval = new CheckBox("Select");
		//Approval.getItems().addAll("Pending", "Approve", "Cancel");
		//Approval.setValue("Pending");
		Table.add(Approval, 7, 1, 1, 1);
		Table.setAlignment(Pos.CENTER);

		sp = new ScrollPane();
		sp.setContent(Table);

		VBox elements = new VBox();
		HBox x = new HBox();
		Button Cancel = new Button("Cancel");
		
		Button Home = new Button("Home");
		x.getChildren().addAll(Home, Cancel);
		elements.getChildren().addAll(Title, Table, x);
		RequestScene = new Scene(elements, 700, 500);
		primaryStage.setScene(RequestScene);
		primaryStage.show();


	}
}