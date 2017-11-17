import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
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

public class ViewRoomStudent extends Application
{
	
	User current_User;
	
	public ViewRoomStudent(User current_User) 
	{
		this.current_User = current_User;
	}
	
	public static void main(String[] args)	
	{	
		launch(args);	
	}	
	@Override	
	public void start(Stage	primaryStage)	
	{	
		primaryStage.setTitle("Classroom Booking System");
		
		Button btn = new Button("View Details");
		btn.setAlignment(Pos.CENTER);
		btn.setPrefWidth(200);
		btn.setPrefHeight(15);
		Button btn2 = new Button("Submit Room Bookings");
		Button btn3 = new Button("Back");
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.CENTER_RIGHT);
		l.getStyleClass().add("labelIIITD");
		
		Map<String, Integer> DayOfWeek = new HashMap<>();
		DayOfWeek.put("MONDAY", 0);
		DayOfWeek.put("TUESDAY", 1);
		DayOfWeek.put("WEDNESDAY", 2);
		DayOfWeek.put("THURSDAY", 3);
		DayOfWeek.put("FRIDAY", 4);
		DayOfWeek.put("SATURDAY", 5);
		DayOfWeek.put("SUNDAY", 6);
		
		btn3.setOnAction(e -> {new student_Page(current_User).start(primaryStage);});
		
		Label Date = new Label("Date");
		DatePicker cal = new DatePicker();

		
		
		
		HBox x = new HBox();
		x.setSpacing(35);
		x.getChildren().addAll(Date, cal, btn);
		HBox x3 = new HBox();
		x3.getChildren().addAll(x, l);
		x3.setSpacing(250);
		
		
		HBox x2 = new HBox();
		x2.setSpacing(350);
		x2.getChildren().addAll(btn3, btn2);
		x2.setAlignment(Pos.TOP_LEFT);
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.getStyleClass().add("grid_pane");
		
		TextField t11 = new TextField("Day"); 
		t11.setDisable(true); t11.setAlignment(Pos.CENTER);
		TextField t12 = new TextField("8:00 - 8:30");
		t12.setDisable(true); t12.setAlignment(Pos.CENTER);
		TextField t13 = new TextField("8:30 - 9:00");
		t13.setDisable(true); t13.setAlignment(Pos.CENTER);
		TextField t14 = new TextField("9:00 - 9:30");
		t14.setDisable(true); t14.setAlignment(Pos.CENTER);
		TextField t15 = new TextField("9:30 - 10:00");
		t15.setDisable(true); t15.setAlignment(Pos.CENTER);
		TextField t16 = new TextField("10:00 - 10:30");
		t16.setDisable(true); t16.setAlignment(Pos.CENTER);
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
		t17.setDisable(true); t17.setAlignment(Pos.CENTER);
		t18.setDisable(true); t18.setAlignment(Pos.CENTER);
		t19.setDisable(true); t19.setAlignment(Pos.CENTER);
		t20.setDisable(true); t20.setAlignment(Pos.CENTER);
		t21.setDisable(true); t21.setAlignment(Pos.CENTER);
		t22.setDisable(true); t22.setAlignment(Pos.CENTER);
		t23.setDisable(true); t23.setAlignment(Pos.CENTER);
		t24.setDisable(true); t24.setAlignment(Pos.CENTER);
		t25.setDisable(true); t25.setAlignment(Pos.CENTER);
		t26.setDisable(true); t26.setAlignment(Pos.CENTER);
		t27.setDisable(true); t27.setAlignment(Pos.CENTER);
		t28.setDisable(true); t28.setAlignment(Pos.CENTER);
		t29.setDisable(true); t29.setAlignment(Pos.CENTER);
		t30.setDisable(true); t30.setAlignment(Pos.CENTER);
		t31.setDisable(true); t31.setAlignment(Pos.CENTER);
		
		TextField t1 = new TextField("C01");
		TextField t2 = new TextField("C02");
		TextField t3 = new TextField("C03");
		TextField t4 = new TextField("C04");
		TextField t5 = new TextField("C11");
		TextField t6 = new TextField("C12");
		TextField t7 = new TextField("C13");
		TextField t8 = new TextField("C14");
		TextField t9 = new TextField("C21");
		TextField ta = new TextField("C22");
		TextField tb = new TextField("C23");
		TextField tc = new TextField("C24");
		TextField td = new TextField("LR1");
		TextField te = new TextField("LR2");
		TextField tf = new TextField("LR3");
		TextField tg = new TextField("S01");
		TextField th = new TextField("S02");
		TextField ti = new TextField("L21");
		TextField tj = new TextField("L22");
		TextField tk = new TextField("L23");
		t1.setDisable(true); t1.setAlignment(Pos.CENTER);
		t2.setDisable(true); t2.setAlignment(Pos.CENTER);
		t3.setDisable(true); t3.setAlignment(Pos.CENTER);
		t4.setDisable(true); t4.setAlignment(Pos.CENTER);
		t5.setDisable(true); t5.setAlignment(Pos.CENTER);
		t6.setDisable(true); t6.setAlignment(Pos.CENTER);
		t7.setDisable(true); t7.setAlignment(Pos.CENTER);
		t8.setDisable(true); t8.setAlignment(Pos.CENTER);
		t9.setDisable(true); t9.setAlignment(Pos.CENTER);
		ta.setDisable(true); ta.setAlignment(Pos.CENTER);
		tb.setDisable(true); tb.setAlignment(Pos.CENTER);
		tc.setDisable(true); tc.setAlignment(Pos.CENTER);
		td.setDisable(true); td.setAlignment(Pos.CENTER);
		te.setDisable(true); te.setAlignment(Pos.CENTER);
		tf.setDisable(true); tf.setAlignment(Pos.CENTER);
		tg.setDisable(true); tg.setAlignment(Pos.CENTER);
		th.setDisable(true); th.setAlignment(Pos.CENTER);
		ti.setDisable(true); ti.setAlignment(Pos.CENTER);
		tj.setDisable(true); tj.setAlignment(Pos.CENTER);
		tk.setDisable(true); tk.setAlignment(Pos.CENTER);
		
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
				TextField Availability = new TextField("Available");
				Availability.setDisable(true);
				Availability.getStyleClass().add("available");
				Availability.setAlignment(Pos.CENTER);
				
				
				root.add(Availability, i, j, 1, 1);
			}
		}
		
		//root.setGridLinesVisible(true);
		ScrollPane sp = new ScrollPane();
		sp.setContent(root);
		
		
		sp.setVisible(false);
		btn2.setVisible(false);
		btn3.setVisible(false);
		
		btn.setOnAction(e	->	{	
			
			for (Node node : root.getChildren()) {
		        if ((GridPane.getColumnIndex(node)>0) && (GridPane.getRowIndex(node)>0)) {
		        	((TextField)node).setText("");
		        	((TextField)node).setText("Available");
		        	((TextField)node).setStyle("-fx-text-fill: #000000;");
		        	
		        }
		    }
			
			sp.setVisible(true);
		//	btn2.setVisible(true);
			btn3.setVisible(true);
			LocalDate date = cal.getValue(); // input from your date picker
			Locale locale = Locale.US;
			int weekOfYear = date.get(WeekFields.of(locale).weekOfWeekBasedYear());
			String Day = new String(date.getDayOfWeek().toString());
			System.out.println("WEEK: " + weekOfYear  +" DAY: " + Day);
			int day = DayOfWeek.get(new String(date.getDayOfWeek().toString()));
			System.out.println(weekOfYear);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			
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
					        	((TextField)node).setText("");
					        	((TextField)node).setText("Not Available");
					        	((TextField)node).getStyleClass().add("not_available");	
					        }
					    }
					}
				}
			}
			
			
			
			
			
		});	
		
		VBox y = new VBox();
		y.setSpacing(30);
		y.getChildren().addAll(x3, sp, x2);
		y.setPadding(new Insets(20));
		
		y.getStyleClass().add("background");
		
		Scene scene	= new Scene(y, 1000, 600);					
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());	
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}