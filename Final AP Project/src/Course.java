import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable{
	 
	/* private List<String> post_Conditions;
	private User faculty; 
	private String type_Of_Course;
	private List<Lecture> timings;  */

	private static final long serialVersionUID = 1L;
	/* Database variables */
	private String coursetype;
	String coursename;
	private String coursecode;
	private String instructorname;
	private String credits;
	private String acronym;
	private String mon;
	private String tue;
	private String wed;
	private String thurs;
	private String fri;
	String postconditions;
	
	public Course(String coursetype, String coursename, String coursecode, String instructorname, String credits, String acronym, String mon, String tue, String wed, String thurs, String fri, String postconditions) 
	{
		this.coursetype = coursetype;
		this.coursename = coursename;
		this.coursecode = coursecode;
		this.instructorname = instructorname;
		this.credits = credits;
		this.acronym = acronym;
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thurs = thurs;
		this.fri = fri;
		this.postconditions = postconditions;
	}
	
	

	@Override
	public String toString() {
		return "Course [coursetype=" + coursetype + ", coursename=" + coursename + ", coursecode=" + coursecode + ", instructorname=" + instructorname + ", credits=" + credits + ", acronym=" + acronym + ", mon=" + mon + ", tue=" + tue + ", wed=" + wed + ", thurs=" + thurs + ", fri=" + fri + ", postconditions=" + postconditions + "]";
	}

	void show()
	{
		return;
	}
	
	boolean search(String keywords)
	{
		return false;
	}
	
	static void add_Course(List<Course> global_Course_List, Course obj)
	{
		global_Course_List.add(obj);
	}	
	
	static void print_Course(List<Course> global_Course_List)
	{
		for(int i = 0 ; i<global_Course_List.size() ; i++)
		{
			System.out.println(global_Course_List.get(i).toString());
		}
	}
	
	 public static void main(String args[]) throws IOException
	    {
	        BufferedReader br = null;
	        try
	        {
	            br = new BufferedReader(new FileReader("C:\\Users\\sm_06\\Desktop\\Database.csv"));
	            
	            String line = "";
	            br.readLine();
	            while ((line = br.readLine()) != null) 
	            {
	                int a = line.indexOf("\"");
	                if(a>0)
	                {
	                	String str = line.substring(a, line.length());
	                	String str2 = str.replace(",", "|");
	                	line = line.substring(0, a) + str2;
	                }
	                
	                String[] courseDetails = line.split(",");
	                
	                if(courseDetails.length > 0 )
	                {
	                	String str = courseDetails[12].replace("|", ",");
	                    Course newcourse = new Course(courseDetails[1], courseDetails[2], courseDetails[3], courseDetails[4], courseDetails[5], courseDetails[6], courseDetails[7], courseDetails[8], courseDetails[9], courseDetails[10], courseDetails[11], str);
	                    add_Course(App.course_List, newcourse);
	                }
	            }
	        }
	        catch(Exception ee)
	        {
	            ee.printStackTrace();
	        }
	        App.serialize("courselist", "course");
	    }
}
