import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Week class used for booking slots for a particular room
 * 
 * @author Yajur
 * @author Shravika
 *
 */
public class Week implements Serializable {

	private List<Day> week_List = new ArrayList<Day>(7);
	private String name;

	/**
	 * Constructor
	 * @param week_List - for the room
	 * @param name - of the room
	 */
	public Week(List<Day> week_List, String name) {
		this.week_List = week_List;
		this.name = name;
	}

	/**
	 * Initialising the week list for all the rooms
	 */
	public Week() {
		for (int i = 0; i < 7; i++) {
			this.week_List.add(new Day());
		}
	}

	/**
	 * getter function for week_List of a particular room
	 * @return week list of the room
	 */
	public List<Day> getWeek_List() {
		return week_List;
	}

	/**
	 * getter function for name of the room whose week list is being accessed
	 * @return name of the room
	 */
	String get_Name() {
		return name;
	}

	/**
	 * Main method for testing booking of slots
	 * @param args
	 */
	public static void main(String[] args) {
		Week obj = new Week();
	}
}