import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * actual_Room.java contains the attributes that each room object should have
 * 
 * It also initialises the 20 weeks long list_Of_Weeks for each room present in
 * the University
 * 
 * @author Yajur Ahuja 2016121
 * @author Shravika Mittal - 2016093
 *
 */
public class actual_Room implements Serializable {

	private List<Week> list_Of_Weeks = new ArrayList<Week>(20);
	private String name;
	private int capacity;

	/**
	 * 
	 * Constructor for actual_Room.java
	 * 
	 * @param name
	 *            of the room
	 * @param capacity
	 *            of the room
	 */
	public actual_Room(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		add_List_Of_Weeks(this.list_Of_Weeks);
	}

	/**
	 * default constructor for actual_Room.java
	 */
	public actual_Room() {
		for (int i = 0; i < 20; i++) {
			this.list_Of_Weeks.add(new Week());
		}
	}

	/**
	 * This is a getter function for lilst_Of_Weeks
	 * 
	 * @return list_Of_Weeks for each actual_Room(room) object
	 */
	public List<Week> getList_Of_Weeks() {
		return list_Of_Weeks;
	}

	/**
	 * This is the getter function for name of the room
	 * 
	 * @return name(String) of the room
	 */
	public String get_Name() {
		return name;
	}

	/**
	 * This is the getter function for capacity of the room
	 * 
	 * @return capacity(int) of the room
	 */
	public int get_Capacity() {
		return capacity;
	}

	/**
	 * 
	 * This is for initialising the 20 weeks for each actual_Room object by
	 * adding new Week() objects
	 * 
	 * @param list_Of_Weeks - week list for every room
	 */
	public void add_List_Of_Weeks(List<Week> list_Of_Weeks) {
		for (int i = 0; i < 20; i++) {
			list_Of_Weeks.add(new Week());
		}
	}

	/**
	 * This is the main method added for object creation testing purposes
	 * 
	 * @param args - unused
	 */
	public static void main(String[] args) {
		actual_Room obj = new actual_Room();
	}
}