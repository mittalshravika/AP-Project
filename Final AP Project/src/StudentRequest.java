import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
	
	User current_User;
	
	public StudentRequest(User current_User) 
	{
		this.current_User = current_User;
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException, IOException
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
		TextField T9 = new TextField("Status");
		Table.add(T1, 0, 0, 1, 1);
		Table.add(T2, 1, 0, 1, 1);
		Table.add(T3, 2, 0, 1, 1);
		Table.add(T4, 3, 0, 1, 1);
		//Table.add(T5, 4, 0, 1, 1);
		Table.add(T6, 4, 0, 1, 1);
		Table.add(T7, 5, 0, 1, 1);
		Table.add(T8, 6, 0, 1, 1);
		Table.add(T9, 7, 0, 1, 1);
		T1.setDisable(true);
		T2.setDisable(true);
		T3.setDisable(true);
		T4.setDisable(true);
		T6.setDisable(true);
		T7.setDisable(true);
		T8.setDisable(true);
		T9.setDisable(true);
		App.deserializeRequests(current_User);
		System.out.println(current_User.MyRequests.size());
		//example
		for(int i = 0; i < current_User.MyRequests.size(); i++)
		{
			TextField t1 = new TextField(String.valueOf(i + 1));
			TextField t2 = new TextField(current_User.MyRequests.get(i).date);
			TextField t3 = new TextField(current_User.MyRequests.get(i).time);
			TextField t4 = new TextField(String.valueOf(current_User.MyRequests.get(i).duration));
			TextField t6 = new TextField(current_User.MyRequests.get(i).purpose);
			TextField t7 = new TextField(current_User.MyRequests.get(i).preferred_Room);
			TextField t8 = new TextField(String.valueOf(current_User.MyRequests.get(i).capacity));
			TextField t9;
			if(current_User.MyRequests.get(i).Approved)
				t9 = new TextField("Approved");
			else
			{
				if(current_User.MyRequests.get(i).Cancel)
					t9 = new TextField("Cancelled");
				else
					t9 = new TextField("Pending");
			}
			
			Request object = current_User.MyRequests.get(i);
			
			Button B = new Button("Show");
	
			B.setOnAction(e -> {
				try {
					
					
					new RequestDetails(object ,current_User).start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			});
			Table.add(B, 8, i+1, 1, 1);
		
			Table.add(t1, 0, i+1, 1, 1);
			Table.add(t2, 1, i+1, 1, 1);
			Table.add(t3, 2, i+1, 1, 1);
			Table.add(t4, 3, i+1, 1, 1);
			Table.add(t6, 4, i+1, 1, 1);
			Table.add(t7, 5, i+1, 1, 1);
			Table.add(t8, 6, i+1, 1, 1);
			t1.setDisable(true);
			t2.setDisable(true);
			t3.setDisable(true);
			t4.setDisable(true);
			t6.setDisable(true);
			t7.setDisable(true);
			t8.setDisable(true);

		
		//Approval.getItems().addAll("Pending", "Approve", "Cancel");
		//Approval.setValue("Pending");
		Table.setAlignment(Pos.CENTER);
		}
		
		App.serializeRequests(current_User);


		sp = new ScrollPane();
		sp.setContent(Table);

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		VBox elements = new VBox();
		HBox x = new HBox();
		Button Cancel = new Button("Cancel");
		
		elements.setSpacing(20);
		elements.setPadding(new Insets(20));
		elements.setAlignment(Pos.TOP_CENTER);
		elements.setStyle("-fx-background-color: #00DDDD");
		
		Button Home = new Button("Back");
		x.getChildren().addAll(Home, Cancel);
		x.setSpacing(760);
		
		Home.setOnAction(e -> {new student_Page(current_User).start(primaryStage);});
		
		elements.getChildren().addAll(l, Title, Table, x);
		RequestScene = new Scene(elements, 1000, 600);
		RequestScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(RequestScene);
		primaryStage.show();


	}
	
}