import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class search_Course {
	
	private String search_Keywords;
	private String add_Course;
	private List<Course> all_Courses;
	static List<Course> course_Search_List = new ArrayList<Course>();
	private HashMap<Course, Integer> h = new HashMap<Course, Integer>();
	private User s;

	public search_Course(String search_Keywords, List<Course> all_Courses) {
		
		this.search_Keywords = search_Keywords;
		this.all_Courses = all_Courses;
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
				String[] arrpost = object.postconditions.split(";");
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
								if(App.course_List.get(p).coursename.equals(object.coursename) && (h.get(object)==0))
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
	
	boolean check_Course()
	{
		return false;
	}
	
	void add_Course(Course c)
	{
		course_Search_List.add(c);	
	}
	
	void deserialise()
	{
		
	}
}