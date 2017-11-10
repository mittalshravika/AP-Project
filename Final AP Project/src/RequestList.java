import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RequestList extends Application
{
	User current_User;
	
	public RequestList(User current_User) 
	{
		this.current_User = current_User;
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
		Scene RequestScene;
		primaryStage.setTitle("Classroom Booking System");

		//Title
		Label Title = new Label("STUDENT REQUESTS");

		//Table
		Table = new GridPane();
		Table.setPadding(new Insets(20, 20, 20, 20));
		
		//Index
		TextField T1 = new TextField("S. No.");
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
		T1.setDisable(true);
		T2.setDisable(true);
		T3.setDisable(true);
		T4.setDisable(true);
		T5.setDisable(true);
		T6.setDisable(true);
		T7.setDisable(true);
		T8.setDisable(true);
		T9.setDisable(true);
		
		TextField t1 = new TextField("1");
		TextField t2 = new TextField("01/11/2017");
		TextField t3 = new TextField("11:00");
		TextField t4 = new TextField("90");
		TextField t5 = new TextField("Name");
		TextField t6 = new TextField("Purpose");
		TextField t7 = new TextField("C21");
		TextField t8 = new TextField("150");
		TextField t9 = new TextField("Cancel");
		Table.add(t1, 0, 1, 1, 1);
		Table.add(t2, 1, 1, 1, 1);
		Table.add(t3, 2, 1, 1, 1);
		Table.add(t4, 3, 1, 1, 1);
		Table.add(t5, 4, 1, 1, 1);
		Table.add(t6, 5, 1, 1, 1);
		Table.add(t7, 6, 1, 1, 1);
		Table.add(t8, 7, 1, 1, 1);
		//Table.add(t9, 6, 1, 1, 1);
		
		t1.setDisable(true);
		t2.setDisable(true);
		t3.setDisable(true);
		t4.setDisable(true);
		t5.setDisable(true);
		t6.setDisable(true);
		t7.setDisable(true);
		t8.setDisable(true);
		t9.setDisable(true);

		//ChoiceBox
		ChoiceBox<String> Approval = new ChoiceBox<>();
		Approval.getItems().addAll("Pending", "Approve", "Cancel");
		Approval.setValue("Pending");
		//Approval.getStyleClass().add("labelchoicebox");
		Table.add(Approval, 8, 1, 1, 1);

		sp = new ScrollPane();
		sp.setContent(Table);
		

		Button btn2 = new Button("Submit Room Bookings");
		Button btn3 = new Button("Back");
		
		btn3.setOnAction(e -> {new admin_Page(current_User).start(primaryStage);});
		
		HBox x2 = new HBox();
		x2.setSpacing(300);
		x2.getChildren().addAll(btn3, btn2);
		x2.setAlignment(Pos.TOP_LEFT);
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");

		VBox elements = new VBox();
		elements.getChildren().addAll(l, Title, Table, x2);
		elements.setAlignment(Pos.TOP_CENTER);
		
		elements.setStyle("-fx-background-color: #00DDDD");
		elements.setSpacing(20);
		elements.setPadding(new Insets(20));
		
		RequestScene = new Scene(elements, 1000, 600);
		RequestScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(RequestScene);
		primaryStage.show();
	}
}