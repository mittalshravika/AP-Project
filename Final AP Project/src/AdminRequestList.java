import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminRequestList extends Application
{
	User admin;
	
	public AdminRequestList(User a)
	{
		this.admin = a;
	}
	
	private static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		ScrollPane sp;
		GridPane Table;
		Scene RequestScene;
		
		primaryStage.setTitle("Classroom Booking System");

		//Title
		Label Title = new Label("Student Requests");

		//Table
		Table = new GridPane();
		Table.setPadding(new Insets(20, 20, 20, 20));
		
		//Index
		TextField T1 = new TextField("Serial Number");
		TextField T0 = new TextField("Name");
		TextField T2 = new TextField("Date");
		TextField T3 = new TextField("Time");
		TextField T4 = new TextField("Duration");
		TextField T6 = new TextField("Purpose");
		TextField T7 = new TextField("Room");
		TextField T8 = new TextField("Capacity");
		TextField T9 = new TextField("Status");
		Table.add(T1, 0, 0, 1, 1);
		Table.add(T0, 1, 0, 1, 1);
		Table.add(T2, 2, 0, 1, 1);
		Table.add(T3, 3, 0, 1, 1);
		Table.add(T4, 4, 0, 1, 1);
		//Table.add(T5, 4, 0, 1, 1);
		Table.add(T6, 5, 0, 1, 1);
		Table.add(T7, 6, 0, 1, 1);
		Table.add(T8, 7, 0, 1, 1);
		Table.add(T9, 8, 0, 1, 1);
		T0.setDisable(true);
		T1.setDisable(true);
		T2.setDisable(true);
		T3.setDisable(true);
		T4.setDisable(true);
		T6.setDisable(true);
		T7.setDisable(true);
		T8.setDisable(true);
		T9.setDisable(true);
		try{
			App.deserialize("adminrequestlist");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("new file");
		}
		System.out.println(App.getAdmin_List().size());
		//example
		for(int i = 0; i < App.getAdmin_List().size(); i++)
		{
			TextField t1 = new TextField(String.valueOf(i + 1));
			TextField t0 = new TextField(App.getAdmin_List().get(i).RequestUser.getName());
			TextField t2 = new TextField(App.getAdmin_List().get(i).date);
			TextField t3 = new TextField(App.getAdmin_List().get(i).time);
			TextField t4 = new TextField(String.valueOf(App.getAdmin_List().get(i).duration));
			TextField t6 = new TextField(App.getAdmin_List().get(i).purpose);
			TextField t7 = new TextField(App.getAdmin_List().get(i).preferred_Room);
			TextField t8 = new TextField(String.valueOf(App.getAdmin_List().get(i).capacity));
			ChoiceBox t9 = new ChoiceBox();
			t9.setItems(FXCollections.observableArrayList("Pending", "Approve", "Cancel"));
			t9.setValue("Pending");
			
			Request object = App.getAdmin_List().get(i);
			
			Button B = new Button("Show");
	
			B.setOnAction(e -> {
				try {
					
					
					new AdminRequestPage(object, admin).start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			});
			Table.add(B, 9, i+1, 1, 1);
		
			Table.add(t1, 0, i+1, 1, 1);
			Table.add(t0, 1, i+1, 1, 1);
			Table.add(t2, 2, i+1, 1, 1);
			Table.add(t3, 3, i+1, 1, 1);
			Table.add(t4, 4, i+1, 1, 1);
			Table.add(t6, 5, i+1, 1, 1);
			Table.add(t7, 6, i+1, 1, 1);
			Table.add(t8, 7, i+1, 1, 1);
			Table.add(t9, 8, i+1, 1, 1);
			t1.setDisable(true);
			t0.setDisable(true);
			t2.setDisable(true);
			t3.setDisable(true);
			t4.setDisable(true);
			t6.setDisable(true);
			t7.setDisable(true);
			t8.setDisable(true);
			//t9.setDisable(true);
			

		
		//Approval.getItems().addAll("Pending", "Approve", "Cancel");
		//Approval.setValue("Pending");
		Table.setAlignment(Pos.CENTER);
		}
		
		try {
			
			App.serialize("adminrequestlist", "adminrequest");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


		sp = new ScrollPane();
		sp.setContent(Table);

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		VBox elements = new VBox();
		HBox x = new HBox();
		Button Book = new Button("Book");
		
		elements.setSpacing(20);
		elements.setPadding(new Insets(20));
		elements.setAlignment(Pos.TOP_CENTER);
		elements.setStyle("-fx-background-color: #00DDDD");
		
		Button Home = new Button("Back");
		x.getChildren().addAll(Home, Book);
		x.setSpacing(760);
		
		Home.setOnAction(e -> {new admin_Page(admin).start(primaryStage);});
		
		elements.getChildren().addAll(l, Title, Table, x);
		RequestScene = new Scene(elements, 1000, 600);
		RequestScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(RequestScene);
		primaryStage.show();


	}
}
