import java.io.Serializable;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class actual_Room implements Serializable{
	
	private List<Week> list_Of_Weeks = new ArrayList<Week>(13);
	private String name;
	private int capacity;

	public List<Week> getList_Of_Weeks() {
		return list_Of_Weeks;
	}

	public actual_Room(String name, int capacity) 
	{
		this.name = name;
		this.capacity = capacity;
	}
	
	public actual_Room() {
		// TODO Auto-generated constructor stub
	}

	public String get_Name() {
		return name;
	}
	

	public int get_Capacity() {
		return capacity;
	}
	
	public void add_List_Of_Weeks(List<Week> list_Of_Weeks)
	{
		
	}
	
	public void add_Room(List<actual_Room> global_Room_List)
	{
		
	}
	
	public static void main(String[] args)
	{
		actual_Room obj = new actual_Room();
		for(int i = 0 ; i<obj.list_Of_Weeks.size() ; i++)
		{
			obj.list_Of_Weeks.add(new Week());
		}
	}
}