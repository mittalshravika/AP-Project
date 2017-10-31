import java.util.List;

public class search_Course {
	
	private String search_Keywords;
	private String add_Course;
	private List<Course> all_Courses;
	private User s;
	
	public search_Course(String search_Keywords, List<Course> all_Courses) {
		
		this.search_Keywords = search_Keywords;
		this.all_Courses = all_Courses;
		search_Post_Condition(search_Keywords, all_Courses);
	}

	
	void search_Post_Condition(String keyword, List<Course> all_Courses)
	{
		for(int i = 0 ; i<all_Courses.size() ; i++)
		{
			Course object = all_Courses.get(i);
			System.out.println(object.postconditions);
			System.out.println(keyword);
		}
	}
	
	boolean check_Course()
	{
		return false;
	}
	
	void add_Course()
	{
		
	}
	
	void deserialise()
	{
		
	}
}