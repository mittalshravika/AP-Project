import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
	public void start(Stage primaryStage) throws ClassNotFoundException, IOException
	{
		int s = 125;
		ScrollPane sp = null;
		GridPane Table;
		Scene BookingScene;
		primaryStage.setTitle("Classroom Booking System");

		//Title
		Label Title = new Label("Your Bookings");

		//Table
		Table = new GridPane();
		Table.setPadding(new Insets(20, 20, 20, 20));
		
		//Index
		TextField T1 = new TextField("S.No."); T1.setPrefWidth(150);
		TextField T2 = new TextField("Date"); T2.setPrefWidth(150);
		TextField T3 = new TextField("Time");T3.setPrefWidth(150);
		TextField T4 = new TextField("Duration");T4.setPrefWidth(150);
		//TextField T5 = new TextField("Name");
		//TextField T6 = new TextField("Purpose");
		TextField T7 = new TextField("Room");T7.setPrefWidth(150);
		TextField T8 = new TextField("Capacity");T8.setPrefWidth(150);
		TextField T9 = new TextField("Cancel");T9.setPrefWidth(150);
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
		
			System.out.println(current_User.getEmail_id());
			
			try{
				App.deserialize(current_User.getEmail_id());
			}
			catch(NullPointerException e)
			{
				System.out.println("New File");
			}
			finally{
				
			}
			System.out.println(current_User.bookings.size());
			
			System.out.println(current_User.bookings.size());
			
			if(type == 1)
			{

				for(int i = 0 ; i<current_User.bookings.size() ; i++)
				{
					cancel_Booking obj = current_User.bookings.get(i);
					TextField t1 = new TextField(Integer.toString(i+1)); t1.setPrefWidth(s);
					TextField t2 = new TextField(obj.date); t2.setPrefWidth(s);
					TextField t3 = new TextField(obj.time); t3.setPrefWidth(s);
					TextField t4 = new TextField(Integer.toString(obj.duration)); t4.setPrefWidth(s);
					TextField t7 = new TextField(obj.room); t7.setPrefWidth(s);
					TextField t8 = new TextField(Integer.toString(obj.capacity));t8.setPrefWidth(s);
					TextField t9 = new TextField("Cancel"); t9.setPrefWidth(s);
					
					CheckBox Approval = new CheckBox("Select");
					
					Table.add(t1, 0, i+1, 1, 1);
					Table.add(t2, 1, i+1, 1, 1);
					Table.add(t3, 2, i+1, 1, 1);
					Table.add(t4, 3, i+1, 1, 1);
					Table.add(t7, 4, i+1, 1, 1);
					Table.add(t8, 5, i+1, 1, 1);
					Table.add(Approval, 6, i+1, 1, 1);
					
					t1.setDisable(true);
					t2.setDisable(true);
					t3.setDisable(true);
					t4.setDisable(true);
					t7.setDisable(true);
					t8.setDisable(true);
					t9.setDisable(true);
					
				}
			}
			
			else if(type == 2)
			{

				for(int i = 0 ; i<current_User.bookings.size() ; i++)
				{
					cancel_Booking obj = current_User.bookings.get(i);
					TextField t1 = new TextField(Integer.toString(i+1)); t1.setPrefWidth(150);
					TextField t2 = new TextField(obj.date); t2.setPrefWidth(150);
					TextField t3 = new TextField(obj.time); t3.setPrefWidth(150);
					TextField t4 = new TextField(Integer.toString(obj.duration)); t4.setPrefWidth(150);
					TextField t7 = new TextField(obj.room); t7.setPrefWidth(150);
					TextField t8 = new TextField(Integer.toString(obj.capacity)); t8.setPrefWidth(150);
					TextField t9 = new TextField("Cancel"); t9.setPrefWidth(125);
					
					CheckBox Approval = new CheckBox("Select");
					
					Table.add(t1, 0, i+1, 1, 1);
					Table.add(t2, 1, i+1, 1, 1);
					Table.add(t3, 2, i+1, 1, 1);
					Table.add(t4, 3, i+1, 1, 1);
					Table.add(t7, 4, i+1, 1, 1);
					Table.add(t8, 5, i+1, 1, 1);
					Table.add(Approval, 6, i+1, 1, 1);
					
					t1.setDisable(true);
					t2.setDisable(true);
					t3.setDisable(true);
					t4.setDisable(true);
					t7.setDisable(true);
					t8.setDisable(true);
					t9.setDisable(true);
				}
			}
			
			App.serialize(current_User.getEmail_id(), "book");
			
		

		Table.setAlignment(Pos.CENTER);

		sp = new ScrollPane();
		sp.setContent(Table);

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		VBox elements = new VBox();
		HBox x = new HBox();
		Button Cancel = new Button("Cancel");
		
			ArrayList<String> h1 = new ArrayList<String>();
			h1.add("8:00");
			h1.add("8:30");
			h1.add("9:00");
			h1.add("9:30");
			h1.add("10:00");
			h1.add("10:30");
			h1.add("11:00");
			h1.add("11:30");
			h1.add("12:00");
			h1.add("12:30");
			h1.add("1:00");
			h1.add("1:30");
			h1.add("2:00");
			h1.add("2:30");
			h1.add("3:00");
			h1.add("3:30");
			h1.add("4:00");
			h1.add("4:30");
			h1.add("5:00");
			h1.add("5:30");
			
			Cancel.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {

					List<CheckBox> check_Box_List = new ArrayList<>();
					ArrayList<Integer> h = new ArrayList<Integer>();

					for(Node node : Table.getChildren())
					{
						if(node instanceof CheckBox)
						{
							check_Box_List.add((CheckBox)node);
						}
					}
					
					ArrayList<cancel_Booking> help = new ArrayList<cancel_Booking>();
					try {
						App.deserialize(current_User.getEmail_id());
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(int i = 0 ; i<check_Box_List.size() ; i++)
					{
						if(check_Box_List.get(i).isSelected())
						{
							h.add(GridPane.getRowIndex((Node)check_Box_List.get(i)));
							int index = GridPane.getRowIndex((Node)check_Box_List.get(i));
							
							String room = current_User.bookings.get(index - 1).room;
							
							try {
								App.deserialize("roomlist");
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							for(int i1 = 0 ; i1<App.actual_Room_List.size() ; i1++)
							{
								System.out.println(room);
								System.out.println(31 - current_User.bookings.get(index - 1).week);
								if(App.actual_Room_List.get(i1).get_Name().equals(room))
								{
									App.actual_Room_List.get(i1).getList_Of_Weeks().get(current_User.bookings.get(index - 1).week - 31).getWeek_List().get(current_User.bookings.get(index - 1).day).getday_List().set(h1.indexOf(current_User.bookings.get(index - 1).time), false);
									break;
								}
							}
							
							try {
								App.serialize("roomlist", "room");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							help.add(current_User.bookings.get(index - 1));
							
							
						}
					}
					
					for(int i = 0 ; i<help.size() ; i++)
					{
						current_User.bookings.remove(help.get(i));
					}
					
					try {
						App.serialize(current_User.getEmail_id(), "book");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						new FacultyBooking(type, current_User).start(primaryStage);
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			});
		
		
		
		elements.setPadding(new Insets(20));
		x.setSpacing(350);
		
		ScrollPane T = new ScrollPane();
		T.setContent(Table);
		T.setPrefHeight(500);
		T.getStyleClass().add("background");
		
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
		elements.getChildren().addAll(l, Title, T, x);
		elements.setSpacing(20);
		
		elements.setAlignment(Pos.TOP_CENTER);
		elements.setStyle("-fx-background-color: #00DDDD");
		BookingScene = new Scene(elements, 1000, 600);		
		BookingScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(BookingScene);
		primaryStage.show();


	}
}