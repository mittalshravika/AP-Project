import java.io.IOException;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Day implements Serializable{
	
	private List<Boolean> day_List = new ArrayList<Boolean>();
	private String name;
	
	public Day(String name) 
	{
		this.name = name;
	}
	
	public Day(List<Boolean> day_List, String name)
	{
		this.day_List = day_List;
		this.name = name;
	}
	
	public Day() {
		for(int i = 0 ; i<20 ; i++)
		{
			this.day_List.add(false);
		}
	}
	
	public List<Boolean> getday_List()
	{
		return day_List;
	}

	void time_Convertr(String duration)
	{
		
	}
	
	void book_Slots() throws ClassNotFoundException, IOException
	{
		
		Day mon = new Day("Monday");
		
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
		
		mon.day_List = new ArrayList<Boolean>();
		
		for(int j = 0 ; j<20 ; j++)
		{
			mon.day_List.add(false);
		}
		
		App.deserialize("courselist");
		
		actual_Room.main(null);
		Week.main(null);
		
		for(int i = 0 ; i<App.course_List.size() ; i++)
		{
			if(!(App.course_List.get(i).getMon().equals("-")))
			{
				String str = App.course_List.get(i).getMon();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String[] room = timevenue[1].split(" ");
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
		        
		        int s = h.indexOf(time[0]);
		        int limit = s + (slots/30);

		        App.deserialize("roomlist");
		        
		        for(int j = 0 ; j<App.actual_Room_List.size() ; j++)
		        {
		        	for(int m = 0 ; m<room.length ; m++)
		        	{
			        	if(App.actual_Room_List.get(j).get_Name().equals(room[m]))
			        	{
			        		for(int k = 0 ; k<13 ; k++)
			        		{
			        			for(int l = s ; l<limit ; l++)
			    		        {
			        				App.actual_Room_List.get(j).getList_Of_Weeks().get(k).getWeek_List().get(0).day_List.set(l, true);
			    		        }
			        		}
			        	}
		        	}
		        }
		        App.serialize("roomlist", "room");
			}
			if(!(App.course_List.get(i).getTue().equals("-")))
			{
				String str = App.course_List.get(i).getTue();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String[] room = timevenue[1].split(" ");
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
		        
		        int s = h.indexOf(time[0]);
		        int limit = s + (slots/30);

		        App.deserialize("roomlist");
		        
		        for(int j = 0 ; j<App.actual_Room_List.size() ; j++)
		        {
		        	for(int m = 0 ; m<room.length ; m++)
		        	{
			        	if(App.actual_Room_List.get(j).get_Name().equals(room[m]))
			        	{
			        		for(int k = 0 ; k<13 ; k++)
			        		{
			        			for(int l = s ; l<limit ; l++)
			    		        {
			        				App.actual_Room_List.get(j).getList_Of_Weeks().get(k).getWeek_List().get(1).day_List.set(l, true);
			    		        }
			        		}
			        	}
		        	}
		        }
		        App.serialize("roomlist", "room");
			}

			if(!(App.course_List.get(i).getWed().equals("-")))
			{
				String str = App.course_List.get(i).getWed();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String[] room = timevenue[1].split(" ");
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
		        
		        int s = h.indexOf(time[0]);
		        int limit = s + (slots/30);

		        App.deserialize("roomlist");
		        
		        for(int j = 0 ; j<App.actual_Room_List.size() ; j++)
		        {
		        	for(int m = 0 ; m<room.length ; m++)
		        	{
			        	if(App.actual_Room_List.get(j).get_Name().equals(room[m]))
			        	{
			        		for(int k = 0 ; k<13 ; k++)
			        		{
			        			for(int l = s ; l<limit ; l++)
			    		        {
			        				App.actual_Room_List.get(j).getList_Of_Weeks().get(k).getWeek_List().get(2).day_List.set(l, true);
			    		        }
			        		}
			        	}
		        	}
		        }
		        App.serialize("roomlist", "room");
			}
			

			if(!(App.course_List.get(i).getThurs().equals("-")))
			{
				String str = App.course_List.get(i).getThurs();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String[] room = timevenue[1].split(" ");
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
		        
		        int s = h.indexOf(time[0]);
		        int limit = s + (slots/30);

		        App.deserialize("roomlist");
		        
		        for(int j = 0 ; j<App.actual_Room_List.size() ; j++)
		        {
		        	for(int m = 0 ; m<room.length ; m++)
		        	{
			        	if(App.actual_Room_List.get(j).get_Name().equals(room[m]))
			        	{
			        		for(int k = 0 ; k<13 ; k++)
			        		{
			        			for(int l = s ; l<limit ; l++)
			    		        {
			        				App.actual_Room_List.get(j).getList_Of_Weeks().get(k).getWeek_List().get(3).day_List.set(l, true);
			    		        }
			        		}
			        	}
		        	}
		        }
		        App.serialize("roomlist", "room");
			}
			

			if(!(App.course_List.get(i).getFri().equals("-")))
			{
				String str = App.course_List.get(i).getFri();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String[] room = timevenue[1].split(" ");
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
		        
		        int s = h.indexOf(time[0]);
		        int limit = s + (slots/30);

		        App.deserialize("roomlist");
		        
		        for(int j = 0 ; j<App.actual_Room_List.size() ; j++)
		        {
		        	for(int m = 0 ; m<room.length ; m++)
		        	{
			        	if(App.actual_Room_List.get(j).get_Name().equals(room[m]))
			        	{
			        		for(int k = 0 ; k<13 ; k++)
			        		{
			        			for(int l = s ; l<limit ; l++)
			    		        {
			        				App.actual_Room_List.get(j).getList_Of_Weeks().get(k).getWeek_List().get(4).day_List.set(l, true);
			    		        }
			        		}
			        	}
		        	}
		        }
		        App.serialize("roomlist", "room");
			}

		}
	}

	String get_Name()
	{
		return name;
	}
	
	void add_Day_List(List<Boolean> day_List)
	{
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		Day obj = new Day();
		obj.book_Slots();
	}

}