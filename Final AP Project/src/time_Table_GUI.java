import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class time_Table_GUI extends Application
{
	
	User current_User;
	
	HashMap<Integer,String> Colours =new HashMap<Integer, String>(){{
		put(0, "#CD6155" );
		put(1, "#9B59B6");
		put(2, "#2980B9");
		put(3, "#117A65");
		put(4, "#F7DC6F" );
		put(5, "#ECF0F1");
		put(6, "#DAF7A6");
		put(8, "#ff3399");
		put(9, "#ccffff");
		put(10, "#66ffff");
		put(11, "#009900");
		put(12, "#ffff00");
		put(13, "#ff9933");
		put(14, "#cc6600");
		put(15, "#6699ff");
		put(16, "#33cccc");
		
	}};
	
	
	public time_Table_GUI(User current_User) 
	{
		this.current_User = current_User;
	}
	
	public static void main(String[] args)	
	{	
		launch(args);	
	}	
	@Override	
	public void start(Stage	primaryStage) throws ClassNotFoundException, IOException	
	{
		
		ArrayList<String> h = new ArrayList<String>();
		h.add("8:00");
		h.add("8:30");
		h.add("9:00");
		h.add("9:30");
		h.add("10:00");
		h.add("10:30");
		h.add("11:00");
		h.add("11:30");
		h.add("12:00");
		h.add("12:30");
		h.add("1:00");
		h.add("1:30");
		h.add("2:00");
		h.add("2:30");
		h.add("3:00");
		h.add("3:30");
		h.add("4:00");
		h.add("4:30");
		h.add("5:00");
		h.add("5:30");
		
		primaryStage.setTitle("Time Table");
		
		Label l1 = new Label("Time Table");
		
		GridPane root = new GridPane();
		
		HBox x = new HBox();
		x.setAlignment(Pos.BOTTOM_RIGHT);
		
		TextField t11 = new TextField("Day");
		t11.setPrefHeight(60);
		t11.setDisable(true);
		TextField t12 = new TextField("8:00 - 8:30");
		t12.setPrefHeight(60);
		t12.setDisable(true);
		TextField t13 = new TextField("8:30 - 9:00");
		t13.setPrefHeight(60);
		t13.setDisable(true);
		TextField t14 = new TextField("9:00 - 9:30");
		t14.setPrefHeight(60);
		t14.setDisable(true);
		TextField t15 = new TextField("9:30 - 10:00");
		t15.setPrefHeight(60);
		t15.setDisable(true);
		TextField t16 = new TextField("10:00 - 10:30");
		t16.setPrefHeight(60);
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
		t17.setDisable(true); t17.setPrefHeight(60);
		t18.setDisable(true); t18.setPrefHeight(60);
		t19.setDisable(true); t19.setPrefHeight(60);
		t20.setDisable(true); t20.setPrefHeight(60);
		t21.setDisable(true); t21.setPrefHeight(60);
		t22.setDisable(true); t22.setPrefHeight(60);
		t23.setDisable(true); t23.setPrefHeight(60);
		t24.setDisable(true); t24.setPrefHeight(60);
		t25.setDisable(true); t25.setPrefHeight(60);
		t26.setDisable(true); t26.setPrefHeight(60);
		t27.setDisable(true); t27.setPrefHeight(60);
		t28.setDisable(true); t28.setPrefHeight(60);
		t29.setDisable(true); t29.setPrefHeight(60);
		t30.setDisable(true); t30.setPrefHeight(60);
		t31.setDisable(true); t31.setPrefHeight(60);
		
		TextField t1 = new TextField("Mon");
		t1.setPrefHeight(60);
		t1.setDisable(true);
		
		TextField ta = new TextField("Tue");
		ta.setPrefHeight(60);
		ta.setDisable(true);
		
		TextField w1 = new TextField("Wed");
		w1.setPrefHeight(60);
		w1.setDisable(true);
		
		TextField th1 = new TextField("Thurs");
		th1.setPrefHeight(60);
		th1.setDisable(true);
		
		TextField f1 = new TextField("Fri");
		f1.setPrefHeight(60);
		f1.setDisable(true);
		
		App.deserialize("corecourselist");
		int j = 0;
		
		for(int i = 0; i<App.core_Course_List.size() ; i++)
		{
			if(!(App.core_Course_List.get(i).getMon().equals("-")))
			{
				String str = App.core_Course_List.get(i).getMon();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = App.core_Course_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setPrefHeight(60);
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
		        		a.setStyle("-fx-background-color:" + Colours.get(j));
		        		 a.setPrefHeight(60);
		        		a.setDisable(true);
			        
		        }
		        else
		        {
		        		a = new TextField(App.core_Course_List.get(i).getAcronym()+" "+room);
		        		a.setStyle("-fx-background-color:" + Colours.get(j));
		        		 a.setPrefHeight(60);
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 1, slots/30, 1);
				
			}
			
			if(!(App.core_Course_List.get(i).getTue().equals("-")))
			{
				String str = App.core_Course_List.get(i).getTue();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = App.core_Course_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(App.core_Course_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 2, slots/30, 1);
				
			}
			
			if(!(App.core_Course_List.get(i).getWed().equals("-")))
			{
				String str = App.core_Course_List.get(i).getWed();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = App.core_Course_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(App.core_Course_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 3, slots/30, 1);
				
			}
			
			if(!(App.core_Course_List.get(i).getThurs().equals("-")))
			{
				String str = App.core_Course_List.get(i).getThurs();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = App.core_Course_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(App.core_Course_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 4, slots/30, 1);
				
			}
			
			if(!(App.core_Course_List.get(i).getFri().equals("-")))
			{
				String str = App.core_Course_List.get(i).getFri();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = App.core_Course_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+App.core_Course_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(App.core_Course_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 5, slots/30, 1);
				
			}
			
			j++;
			
			
		}
		
		
		try {
			App.deserialize(current_User.getEmail_id()+"new");
	} catch (NullPointerException e) {
		System.out.println("New File");
	}
		
		 j++;
		 
		for(int i = 0 ; i<current_User.newcourse_List.size() ; i++)
		{
			if(!(current_User.newcourse_List.get(i).getMon().equals("-")))
			{
				String str = current_User.newcourse_List.get(i).getMon();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = current_User.newcourse_List.get(i).getCoursename().split(";");
		        System.out.println(name[0]);
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 1, slots/30, 1);
				
			}
			
			if(!(current_User.newcourse_List.get(i).getTue().equals("-")))
			{
				String str = current_User.newcourse_List.get(i).getTue();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = current_User.newcourse_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 2, slots/30, 1);
				
			}
			
			if(!(current_User.newcourse_List.get(i).getWed().equals("-")))
			{
				String str = current_User.newcourse_List.get(i).getWed();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = current_User.newcourse_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 3, slots/30, 1);
				
			}
			
			if(!(current_User.newcourse_List.get(i).getThurs().equals("-")))
			{
				String str = current_User.newcourse_List.get(i).getThurs();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = current_User.newcourse_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 4, slots/30, 1);
				
			}
			
			if(!(current_User.newcourse_List.get(i).getFri().equals("-")))
			{
				String str = current_User.newcourse_List.get(i).getFri();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");
				
				if(Integer.parseInt(start[0])!=8 && Integer.parseInt(start[0])!=9 && Integer.parseInt(start[0])!=10 && Integer.parseInt(start[0])!=11)
				{
					starttime = starttime + " PM";
				}
				else
				{
					starttime = starttime + " AM";
				}
				
				if(Integer.parseInt(end[0])!=8 && Integer.parseInt(end[0])!=9 && Integer.parseInt(end[0])!=10 && Integer.parseInt(end[0])!=11)
				{
					endtime = endtime + " PM";
				}
				else
				{
					endtime = endtime + " AM";
				}
				
				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		        LocalTime time1 = LocalTime.parse(starttime, format);
		        LocalTime time2 = LocalTime.parse(endtime, format);
		        Duration duration1 = Duration.between(time1, time2);
		        int slots = (int) Math.abs(duration1.getSeconds() / 60);
		        
		        TextField a = null;
		        
		        String[] name = current_User.newcourse_List.get(i).getCoursename().split(";");
		        
		        if(name[0].equals("TUT"))
		        {
			        a = new TextField("TUT"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
			        a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else if(name[0].equals("LAB"))
		        {
		        	a = new TextField("LAB"+" "+current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        else
		        {
		        	a = new TextField(current_User.newcourse_List.get(i).getAcronym()+" "+room);
		        	a.setStyle("-fx-background-color:" + Colours.get(j));
			        a.setDisable(true);
		        }
		        
		        int s = h.indexOf(time[0]);
		        a.setPrefHeight(60);
		        root.add(a, s+1, 5, slots/30, 1);
				
			}
			
			j++;
			
			
		}
		
		
		try {
			if(current_User.newcourse_List.size()>0)
			{
				App.serialize(current_User.getEmail_id()+"new", "register");
				System.out.println("A");
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
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
		
		root.add(ta, 0, 2, 1, 1);
		
		root.add(w1, 0, 3, 1, 1);
		
		root.add(th1, 0, 4, 1, 1);
		
		root.add(f1, 0, 5, 1, 1);
		
				
		ScrollPane sp = new ScrollPane();
		sp.setContent(root);
		
		sp.setPrefHeight(580);
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		x.getChildren().addAll(l, l1);
		x.setSpacing(550);
		
		Button btn6 = new Button("Back");
		
		btn6.setOnAction(e -> {new student_Page(current_User).start(primaryStage);});
		
		HBox x2 = new HBox();
		x2.setSpacing(300);
		x2.getChildren().addAll(btn6);
		x2.setAlignment(Pos.TOP_LEFT);
		
		VBox y = new VBox();
		y.setAlignment(Pos.TOP_CENTER);
		y.setSpacing(30);
		y.getChildren().addAll(x, sp, btn6);
		
		y.setPadding(new Insets(20));

		y.getStyleClass().add("background");
		
		Scene scene	= new Scene(y, 1000, 600);					
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}