import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
	
	private List<String> post_Conditions;
	private String name;
	private User faculty; /* User Class */
	private String course_Number;
	private String type_Of_Course;
	private List<Lecture> timings; /* Lecture Class */
	
	public String get_Name() {
		return name;
	}

	public String get_Course_Number() {
		return course_Number;
	}
	
	public String get_Type_Of_Course() {
		return type_Of_Course;
	}


	void show()
	{
		return;
	}
	
	boolean search(String keywords)
	{
		
	}
	
	void add_Course(List<Course> global_Course_List)
	{
		
	}	
}
