import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


class date
{
	int week;
	int day;
	String date;
}

class help
{
	CheckBox cb;
	int i;
	int j;
}

public class book_Room extends Application
{
	static int type;
	User current_User;
	AdminRequestList object;
	Request obj;

	public book_Room(int a, User obj)
	{
		type = a;
		current_User = obj;
	}
	
	public book_Room(int i, User admin, AdminRequestList obj) {
		type = i;
		current_User = admin;
		object = obj;
	}
	
	public book_Room(int i, User admin, Request object2) {
		type = i;
		current_User = admin;
		obj = object2;
	}

public static void main(String[] args)	
	{	
		launch(args);	
	}	
	@Override	
	public void start(Stage	primaryStage) throws Exception	
	{	
		primaryStage.setTitle("Classroom Booking System");
		
		Map<String, Integer> DayOfWeek = new HashMap<>();
		DayOfWeek.put("MONDAY", 0);
		DayOfWeek.put("TUESDAY", 1);
		DayOfWeek.put("WEDNESDAY", 2);
		DayOfWeek.put("THURSDAY", 3);
		DayOfWeek.put("FRIDAY", 4);
		DayOfWeek.put("SATURDAY", 5);
		DayOfWeek.put("SUNDAY", 6);
		
		Button btn = new Button("View details");
		Button btn2 = new Button("Submit Room Bookings");
		Button btn3 = new Button("Back");
		Button btn4 = new Button("Student Request Details");
		
		btn4.setVisible(false);
		
		if(type==3)
		{
			
			btn4.setVisible(true);
			btn4.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					try {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Dialog");
						alert.setHeaderText("Student Request Details");
						alert.setContentText("Name: " + obj.RequestUser.getName() + "\n" + "Purpose: " + obj.purpose + "\n" + "Preferred Room: " + obj.preferred_Room + "\n" + "Date: " + obj.date + "\n" +"Time: " + obj.time + "\n" + "Duration: " + obj.duration);

						alert.showAndWait();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
		}
		
		if(type == 1)
		{
			btn3.setOnAction(e -> {new faculty_Page(current_User).start(primaryStage);});
		}
		else if(type == 2)
		{
			btn3.setOnAction(e -> {new admin_Page(current_User).start(primaryStage);});
		}
		else if(type==3)
		{
			btn3.setOnAction(e -> {
				try {
					new AdminRequestList(current_User).start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		}
		
		Label Date = new Label("Date:");
		DatePicker cal = new DatePicker();
		
		HBox x = new HBox();
		x.setSpacing(35);
		x.getChildren().addAll(Date, cal, btn, btn4);
		
		HBox x2 = new HBox();
		x2.setSpacing(300);
		x2.getChildren().addAll(btn3, btn2);
		x2.setAlignment(Pos.TOP_LEFT);
		
		GridPane root = new GridPane();
		
		TextField t11 = new TextField("Day");
		t11.setDisable(true);
		TextField t12 = new TextField("8:00 - 8:30");
		t12.setDisable(true);
		TextField t13 = new TextField("8:30 - 9:00");
		t13.setDisable(true);
		TextField t14 = new TextField("9:00 - 9:30");
		t14.setDisable(true);
		TextField t15 = new TextField("9:30 - 10:00");
		t15.setDisable(true);
		TextField t16 = new TextField("10:00 - 10:30");
		t16.setDisable(true);
		TextField t17 = new TextField("10:30 - 11:00");
		TextField t18 = new TextField("11:00 - 11:30");
		TextField t19 = new TextField("11:30 - 12:00");
		TextField t20 = new TextField("12:00 - 12:30");
		TextField t21 = new TextField("12:30 - 1:00");
		TextField t22 = new TextField("1:00 - 1:30");
		TextField t23 = new TextField("1:30 - 2:00");
		TextField t24 = new TextField("2:00 - 2:30");
		TextField t25 = new TextField("2:30 - 3:00");
		TextField t26 = new TextField("3:00 - 3:30");
		TextField t27 = new TextField("3:30 - 4:00");
		TextField t28 = new TextField("4:00 - 4:30");
		TextField t29 = new TextField("4:30 - 5:00");
		TextField t30 = new TextField("5:00 - 5:30");
		TextField t31 = new TextField("5:30 - 6:00");
		t17.setDisable(true);
		t18.setDisable(true);
		t19.setDisable(true);
		t20.setDisable(true);
		t21.setDisable(true);
		t22.setDisable(true);
		t23.setDisable(true);
		t24.setDisable(true);
		t25.setDisable(true);
		t26.setDisable(true);
		t27.setDisable(true);
		t28.setDisable(true);
		t29.setDisable(true);
		t30.setDisable(true);
		t31.setDisable(true);
		
		TextField t1 = new TextField("C01/180");
		TextField t2 = new TextField("C02/75");
		TextField t3 = new TextField("C03/35");
		TextField t4 = new TextField("C04/35");
		TextField t5 = new TextField("C11/180");
		TextField t6 = new TextField("C12/75");
		TextField t7 = new TextField("C13/35");
		TextField t8 = new TextField("C14/35");
		TextField t9 = new TextField("C21/180");
		TextField ta = new TextField("C22/75");
		TextField tb = new TextField("C23/35");
		TextField tc = new TextField("C24/35");
		TextField td = new TextField("LR1/30");
		TextField te = new TextField("LR2/30");
		TextField tf = new TextField("LR3/30");
		TextField tg = new TextField("S01/35");
		TextField th = new TextField("S02/35");
		TextField ti = new TextField("L21/40");
		TextField tj = new TextField("L22/40");
		TextField tk = new TextField("L23/40");
		t1.setDisable(true);
		t2.setDisable(true);
		t3.setDisable(true);
		t4.setDisable(true);
		t5.setDisable(true);
		t6.setDisable(true);
		t7.setDisable(true);
		t8.setDisable(true);
		t9.setDisable(true);
		ta.setDisable(true);
		tb.setDisable(true);
		tc.setDisable(true);
		td.setDisable(true);
		te.setDisable(true);
		tf.setDisable(true);
		tg.setDisable(true);
		th.setDisable(true);
		ti.setDisable(true);
		tj.setDisable(true);
		tk.setDisable(true);
		
		root.add(t11, 0, 0, 1, 1);
		root.add(t12, 1, 0, 1, 1);
		root.add(t13, 2, 0, 1, 1);
		root.add(t14, 3, 0, 1, 1);
		root.add(t15, 4, 0, 1, 1);
		root.add(t16, 5, 0, 1, 1);
		root.add(t17, 6, 0, 1, 1);
		root.add(t18, 7, 0, 1, 1);
		root.add(t19, 8, 0, 1, 1);
		root.add(t20, 9, 0, 1, 1);
		root.add(t21, 10, 0, 1, 1);
		root.add(t22, 11, 0, 1, 1);
		root.add(t23, 12, 0, 1, 1);
		root.add(t24, 13, 0, 1, 1);
		root.add(t25, 14, 0, 1, 1);
		root.add(t26, 15, 0, 1, 1);
		root.add(t27, 16, 0, 1, 1);
		root.add(t28, 17, 0, 1, 1);
		root.add(t29, 18, 0, 1, 1);
		root.add(t30, 19, 0, 1, 1);
		root.add(t31, 20, 0, 1, 1);
				
		root.add(t1, 0, 1, 1, 1);
		
		root.add(t2, 0, 2, 1, 1);
		root.add(t3, 0, 3, 1, 1);
		root.add(t4, 0, 4, 1, 1);
		root.add(t5, 0, 5, 1, 1);
		root.add(t6, 0, 6, 1, 1);
		root.add(t7, 0, 7, 1, 1);
		root.add(t8, 0, 8, 1, 1);
		root.add(t9, 0, 9, 1, 1);
		root.add(ta, 0, 10, 1, 1);
		root.add(tb, 0, 11, 1, 1);
		root.add(tc, 0, 12, 1, 1);
		root.add(td, 0, 13, 1, 1);
		root.add(te, 0, 14, 1, 1);
		root.add(tf, 0, 15, 1, 1);
		root.add(tg, 0, 16, 1, 1);
		root.add(th, 0, 17, 1, 1);
		root.add(ti, 0, 18, 1, 1);
		root.add(tj, 0, 19, 1, 1);
		root.add(tk, 0, 20, 1, 1);
		
		for(int j = 1 ; j<=20 ; j++)
		{
			for(int i = 1 ; i<=20 ; i++)
			{
				root.add(new CheckBox("Book"), i, j, 1, 1);
			}
		}
		
		/*
		for (Node node : root.getChildren()) {
	        if ((GridPane.getColumnIndex(node)%2==0 && GridPane.getColumnIndex(node)>0) && (GridPane.getRowIndex(node)%2==0 && GridPane.getRowIndex(node)>0)) {
	            node.setDisable(true);
	        }
	    }
	    */
			
		ScrollPane sp = new ScrollPane();
		sp.setContent(root);
		
		sp.setVisible(false);
		btn2.setVisible(false);
		btn3.setVisible(false);
		
		date obj1 = new date();
		
		btn.setOnAction(e	->	{	
			sp.setVisible(true);
			btn2.setVisible(true);
			btn3.setVisible(true);
			
			
			
			
			LocalDate date = cal.getValue(); // input from your date picker
			Locale locale = Locale.US;
			int weekOfYear = date.get(WeekFields.of(locale).weekOfWeekBasedYear());
			int day = DayOfWeek.get(new String(date.getDayOfWeek().toString()));
			System.out.println(weekOfYear);
			obj1.week = weekOfYear;
			obj1.day = day;
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			
			obj1.date = date.format(formatter);
			try {
				App.deserialize("roomlist");
				Day obj = new Day();
				//obj.book_Slots();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println();
			
			for(int i = 0; i < App.actual_Room_List.size(); i++)
			{
				for(int j = 0 ; j<20 ; j++)
				{
					if(App.actual_Room_List.get(i).getList_Of_Weeks().get(weekOfYear - 31).getWeek_List().get(day).getday_List().get(j))
					{
						for (Node node : root.getChildren()) {
					        if ((GridPane.getColumnIndex(node)==(j+1) && GridPane.getColumnIndex(node)>0) && (GridPane.getRowIndex(node)==(i+1) && GridPane.getRowIndex(node)>0)) {
					        	node.setDisable(true);
					        }
					    }
					}
				}
			}
			btn.setDisable(true);
		});	
		
		btn2.setOnAction(e -> {
			List<CheckBox> check_Box_List = new ArrayList<>();
			ArrayList<ArrayList<Integer>> h = new ArrayList<ArrayList<Integer>>();
			
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
			
			for(int i = 0 ; i<20 ; i++)
			{
				h.add(new ArrayList<Integer>());
			}
			for(Node node : root.getChildren())
			{
				if(node instanceof CheckBox)
				{
					check_Box_List.add((CheckBox)node);
				}
			}
			for(int i = 0 ; i<check_Box_List.size() ; i++)
			{
				if(check_Box_List.get(i).isSelected())
				{
					check_Box_List.get(i).setSelected(false);
					check_Box_List.get(i).setDisable(true);
					h.get(GridPane.getRowIndex((Node)check_Box_List.get(i)) - 1).add((GridPane.getColumnIndex((Node)check_Box_List.get(i)) - 1));
				}
			}
			for(int i = 0 ; i<h.size() ; i++)
			{
				if(h.get(i).size()>0)
				{
					for(int j = 0 ; j<h.get(i).size() ; j++)
					{
						try {
							App.deserialize("roomlist");
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}
						
						App.actual_Room_List.get(i).getList_Of_Weeks().get(obj1.week - 31).getWeek_List().get(obj1.day).getday_List().set(h.get(i).get(j), true);
						System.out.println(current_User.getEmail_id());
						
						try {
							if(current_User.bookings.size()>0)
							{
								App.deserialize(current_User.getEmail_id());
								System.out.println("A");
							}
						} catch (ClassNotFoundException | IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						String name = "";
						
						
						cancel_Booking booking = new cancel_Booking(obj1.date, h1.get(h.get(i).get(j)), 30, App.actual_Room_List.get(i).get_Name(), App.actual_Room_List.get(i).get_Capacity(), obj1.week, obj1.day, name);
						current_User.bookings.add(booking);
						System.out.println("size");
						System.out.println(current_User.bookings.size());
						
						try {
							App.serialize(current_User.getEmail_id(), "book");
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						try {
							App.serialize("roomlist", "room");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						System.out.println("Chal gaya");
					}
				}
			}
			
		});
		
		VBox y = new VBox();
		y.setSpacing(30);
		y.getChildren().addAll(x, sp, x2);
		y.setPadding(new Insets(20));
		
		y.setStyle("-fx-background-color: #00DDDD");
		
		Scene scene	= new Scene(y, 1000, 600);					
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());	
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}