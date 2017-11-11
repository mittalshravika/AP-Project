import java.io.Serializable;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class actual_Room implements Serializable{
	
	private List<Week> list_Of_Weeks;
	private String name;
	private int capacity;

	public actual_Room(String name, int capacity) 
	{
		this.name = name;
		this.capacity = capacity;
	}
	
	public actual_Room(String name, int capacity)
	{
		this.name =new String(name);
		this.capacity = capacity;
		list_Of_Weeks = new ArrayList<Week>();
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
}