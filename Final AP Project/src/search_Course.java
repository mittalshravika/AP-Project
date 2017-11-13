import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class search_Course {
	
	private String search_Keywords;
	private String add_Course;
	private List<Course> all_Courses;
	static List<Course> course_Search_List = new ArrayList<Course>();
	private HashMap<Course, Integer> h = new HashMap<Course, Integer>();
	private User current_User;

	public search_Course(String search_Keywords, List<Course> all_Courses, User student_User) throws ClassNotFoundException, IOException {
		
		current_User = student_User;
		current_User.obj = new time_Table(current_User);
		current_User.obj.core_Courses();
		this.search_Keywords = search_Keywords;
		this.all_Courses = all_Courses;
		course_Search_List.clear();
		search_Post_Condition(search_Keywords, all_Courses);
	}
	
	public List<Course> getCourse_Search_List()
	{
		return course_Search_List;
	}

	public void help_Hash_Map(List<Course> all_Courses)
	{
		for(int i = 0 ; i<all_Courses.size() ; i++)
		{
			h.put(all_Courses.get(i), 0);
		}
	}
	
	void search_Post_Condition(String keyword, List<Course> all_Courses)
	{
		help_Hash_Map(all_Courses);
		String[] arr = keyword.split(" ");
		for(int j = 0 ; j<arr.length ; j++)
		{
			for(int i = 0 ; i<all_Courses.size() ; i++)
			{
				boolean flag = true;
				Course object = all_Courses.get(i);
				String[] arrpost = object.getPostconditions().split(";");
				for(int k = 0 ; k<arrpost.length ; k++)
				{
					String post1 = arrpost[k];
					String[] wordarr = post1.split(" ");
					for(int l = 0 ; l<wordarr.length ; l++)
					{
						if(flag == false)
						{
							break;
						}
						String word = wordarr[l];
						word = word.replace(",", "");
						word = word.replace("\"", "");
						word = word.replace(".", "");
						word = word.replace("(", "");
						word = word.replace(")", "");
						if(word.equalsIgnoreCase(arr[j]))
						{
							for(int p = 0 ; p<App.course_List.size() ; p++)
							{
								if(App.course_List.get(p).getCoursename().equals(object.getCoursename()) && (h.get(object)==0))
								{
									add_Course(App.course_List.get(p));
									h.put(object, 1);
									break;
								}
							}
							flag = false;
							break;
						}
					}
				}
			}
		}
	}
	
	boolean check_Course(Course c, ArrayList<ArrayList<Boolean>> student_Time_Table)
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
		
		if(!(c.getMon().equals("-")))
		{
			String str = c.getMon();
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
	        
	        int s = h.indexOf(time[0]);
	        int limit = s + (slots/30);
	        
	        for(int j = s ; j<limit ; j++)
	        {
	        	if(student_Time_Table.get(0).get(j) == true)
	        	{
	        		return false;
	        	}
	        }
		
		}
		
		if(!(c.getTue().equals("-")))
		{
			String str = c.getTue();
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
	        
	        int s = h.indexOf(time[0]);
	        int limit = s + (slots/30);
	        
	        for(int j = s ; j<limit ; j++)
	        {
	        	if(student_Time_Table.get(1).get(j) == true)
	        	{
	        		return false;
	        	}
	        }
		
		}
		
		if(!(c.getWed().equals("-")))
		{
			String str = c.getWed();
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
	        
	        int s = h.indexOf(time[0]);
	        int limit = s + (slots/30);
	        
	        for(int j = s ; j<limit ; j++)
	        {
	        	if(student_Time_Table.get(2).get(j) == true)
	        	{
	        		return false;
	        	}
	        }
		
		}
		
		if(!(c.getThurs().equals("-")))
		{
			String str = c.getThurs();
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
	        
	        int s = h.indexOf(time[0]);
	        int limit = s + (slots/30);
	        
	        for(int j = s ; j<limit ; j++)
	        {
	        	if(student_Time_Table.get(3).get(j) == true)
	        	{
	        		return false;
	        	}
	        }
		
		}
		
		if(!(c.getFri().equals("-")))
		{
			String str = c.getFri();
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
	        
	        int s = h.indexOf(time[0]);
	        int limit = s + (slots/30);
	        
	        for(int j = s ; j<limit ; j++)
	        {
	        	if(student_Time_Table.get(4).get(j) == true)
	        	{
	        		return false;
	        	}
	        }
		
		}
	
		return true;
	}
	
	void add_Course(Course c)
	{
		if(check_Course(c, current_User.obj.student_Time_Table))
		{
			course_Search_List.add(c);	
		}
	}
	
	void deserialise()
	{
		
	}
}