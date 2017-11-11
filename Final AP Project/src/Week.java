import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Week implements Serializable{

	private List<Day> week_List = new ArrayList<Day>(7);
	private String name;
	
	public Week(List<Day> week_List, String name) 
	{
		this.week_List = week_List;
		this.name = name;
	}
	
	public Week() 
	{
		for(int i = 0 ; i<this.week_List.size() ; i++)
		{
			this.week_List.add(new Day());
		}
	}

	public List<Day> getWeek_List() {
		return week_List;
	}

	
	String get_Name()
	{
		return name;	
	}
	
	void add_Week_List(List<Day> week_List)
	{
		
	}
	
	public static void main(String[] args)
	{
		Week obj = new Week();
	}
}