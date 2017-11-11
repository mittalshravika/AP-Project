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
public class FacultyBooking extends Application
{
	int type;
	User current_User;
	
	public FacultyBooking(int a, User obj)
	{
		type = a;
		current_User = obj;
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage primaryStage)
	{
		ScrollPane sp;
		GridPane Table;
		Scene BookingScene;
		primaryStage.setTitle("Classroom Booking System");

		//Title
		Label Title = new Label("Your Bookings");

		//Table
		Table = new GridPane();
		Table.setPadding(new Insets(20, 20, 20, 20));
		
		//Index
		TextField T1 = new TextField("Serial Number");
		TextField T2 = new TextField("Date");
		TextField T3 = new TextField("Time");
		TextField T4 = new TextField("Duration");
		//TextField T5 = new TextField("Name");
		//TextField T6 = new TextField("Purpose");
		TextField T7 = new TextField("Room");
		TextField T8 = new TextField("Capacity");
		TextField T9 = new TextField("Cancel");
		Table.add(T1, 0, 0, 1, 1);
		Table.add(T2, 1, 0, 1, 1);
		Table.add(T3, 2, 0, 1, 1);
		Table.add(T4, 3, 0, 1, 1);
		//Table.add(T5, 4, 0, 1, 1);
		//Table.add(T6, 5, 0, 1, 1);
		Table.add(T7, 4, 0, 1, 1);
		Table.add(T8, 5, 0, 1, 1);
		Table.add(T9, 6, 0, 1, 1);
		T1.setDisable(true);
		T2.setDisable(true);
		T3.setDisable(true);
		T4.setDisable(true);
		T7.setDisable(true);
		T8.setDisable(true);
		T9.setDisable(true);

		//Example
		TextField t1 = new TextField("1");
		TextField t2 = new TextField("01/11/2017");
		TextField t3 = new TextField("11:00");
		TextField t4 = new TextField("90");
		//TextField T5 = new TextField("Name");
		//TextField T6 = new TextField("Purpose");
		TextField t7 = new TextField("C21");
		TextField t8 = new TextField("150");
		TextField t9 = new TextField("Cancel");
		Table.add(t1, 0, 1, 1, 1);
		Table.add(t2, 1, 1, 1, 1);
		Table.add(t3, 2, 1, 1, 1);
		Table.add(t4, 3, 1, 1, 1);
		//Table.add(T5, 4, 0, 1, 1);
		//Table.add(T6, 5, 0, 1, 1);
		Table.add(t7, 4, 1, 1, 1);
		Table.add(t8, 5, 1, 1, 1);
		//Table.add(t9, 6, 1, 1, 1);
		
		t1.setDisable(true);
		t2.setDisable(true);
		t3.setDisable(true);
		t4.setDisable(true);
		t7.setDisable(true);
		t8.setDisable(true);
		t9.setDisable(true);



		//ChoiceBox
		CheckBox Approval = new CheckBox("Select");
		//Approval.getItems().addAll("Pending", "Approve", "Cancel");
		//Approval.setValue("Pending");
		Table.add(Approval, 6, 1, 1, 1);
		Table.setAlignment(Pos.CENTER);

		sp = new ScrollPane();
		sp.setContent(Table);

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		VBox elements = new VBox();
		HBox x = new HBox();
		Button Cancel = new Button("Cancel");
		
		elements.setPadding(new Insets(20));
		x.setSpacing(350);
		
		Button Home = new Button("Back");
		
		if(type == 1)
		{
			Home.setOnAction(e -> {new faculty_Page(current_User).start(primaryStage);});
		}
		else if(type == 2)
		{
			Home.setOnAction(e -> {new admin_Page(current_User).start(primaryStage);});
		}
		
		x.getChildren().addAll(Home, Cancel);
		elements.getChildren().addAll(l, Title, Table, x);
		elements.setSpacing(20);
		
		elements.setAlignment(Pos.TOP_CENTER);
		elements.setStyle("-fx-background-color: #00DDDD");
		BookingScene = new Scene(elements, 1000, 600);		
		BookingScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(BookingScene);
		primaryStage.show();


	}
}