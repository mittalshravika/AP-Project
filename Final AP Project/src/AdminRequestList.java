import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminRequestList extends Application
{
	User admin;
	String name;
	
	public AdminRequestList(User a)
	{
		this.admin = a;
	}
	
	public AdminRequestList() {
		// TODO Auto-generated constructor stub
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
		System.out.println(java.time.LocalDate.now()); 
		System.out.println(java.time.LocalTime.now());  
		
		for(int i = 0 ; i<App.admin_List.size() ; i++)
		{
			Date d1 = new SimpleDateFormat("MM/dd/yyyy").parse((String)App.admin_List.get(i).date);

			LocalDate date = java.time.LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String date2 = date.format(formatter);
			Date d2 = new SimpleDateFormat("MM/dd/yyyy").parse((String)date2);
			long diff = Math.abs(d1.getTime() - d2.getTime());
			long diffDays = diff / (24 * 60 * 60 * 1000);
			System.out.println(diffDays);
			if(diffDays>5)
			{
				try {
					App.deserializeRequests(App.admin_List.get(i).RequestUser);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Request obj = App.admin_List.get(i);
				for(int j = 0 ; j<App.admin_List.get(i).RequestUser.MyRequests.size() ; j++)
				{
					if(obj.ref == App.admin_List.get(i).RequestUser.MyRequests.get(j).ref)
					{
						App.admin_List.get(i).RequestUser.MyRequests.get(j).Cancel = true;
						App.admin_List.get(i).RequestUser.MyRequests.get(j).Approved = false;
						System.out.println(obj.toString());
						break;
					}
				}
				
				try {
					App.serializeRequests(App.admin_List.get(i).RequestUser);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				App.admin_List.remove(obj);
			}
		}
		
		
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
		
		Button Submit = new Button("Submit");
		x.getChildren().addAll(Home, Book, Submit);
		AdminRequestList obj = new AdminRequestList();
		
		Book.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				TextInputDialog dialog = new TextInputDialog("");
				dialog.setTitle("Name Input Dialog");
				dialog.setHeaderText("Enter the name for whom booking has to be done");
				dialog.setContentText("Name:");

				// Traditional way to get the response value.
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()){
					obj.name = result.get();
				}
				
				new book_Room(2, admin, obj).start(primaryStage);
			}
			
			
			
		});
		
		Submit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				
				try {
					App.deserialize("adminrequestlist");
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				List<ChoiceBox> choice_Box_List = new ArrayList<>();
				ArrayList<Integer> h = new ArrayList<Integer>();

				for(Node node : Table.getChildren())
				{
					if(node instanceof ChoiceBox)
					{
						choice_Box_List.add((ChoiceBox)node);
					}
				}
				for(int i = 0 ; i<choice_Box_List.size() ; i++)
				{
					if(choice_Box_List.get(i).getValue().equals("Approve"))
					{
						try {
							App.deserializeRequests(App.admin_List.get(i).RequestUser);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for(int j = 0 ; j<App.admin_List.get(i).RequestUser.MyRequests.size() ; j++)
						{
							if(App.admin_List.get(i).ref == App.admin_List.get(i).RequestUser.MyRequests.get(j).ref)
							{
								
								App.admin_List.get(i).RequestUser.MyRequests.get(j).Approved = true;
								App.admin_List.get(i).RequestUser.MyRequests.get(j).Cancel = false;
								System.out.println(App.admin_List.get(i).RequestUser.MyRequests.get(j).toString());
								
								break;
							}
						}
						try {
							App.serializeRequests(App.admin_List.get(i).RequestUser);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(choice_Box_List.get(i).getValue().equals("Cancel"))
					{
						for(int j = 0 ; j<App.admin_List.get(i).RequestUser.MyRequests.size() ; j++)
						{
							if(App.admin_List.get(i).ref == App.admin_List.get(i).RequestUser.MyRequests.get(j).ref)
							{
								try {
									App.deserializeRequests(App.admin_List.get(i).RequestUser);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								App.admin_List.get(i).RequestUser.MyRequests.get(j).Cancel = true;
								App.admin_List.get(i).RequestUser.MyRequests.get(j).Approved = false;
								System.out.println(App.admin_List.get(i).RequestUser.MyRequests.get(j).toString());
								try {
									App.serializeRequests(App.admin_List.get(i).RequestUser);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
						}
					}
				}
				
				try {
					App.serialize("adminrequestlist", "adminrequest");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		x.setSpacing(760);
		
		Home.setOnAction(e -> {new admin_Page(admin).start(primaryStage);});
		
		elements.getChildren().addAll(l, Title, Table, x);
		RequestScene = new Scene(elements, 1000, 600);
		RequestScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(RequestScene);
		primaryStage.show();


	}
}
