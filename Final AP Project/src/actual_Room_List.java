import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * 
 * actual_Room_List.java is used for reading reading the .csv for Room Details
 * and storing them
 * 
 * @author Yajur Ahuja - 2016121
 * @author Shravika Mittal - 2016093
 *
 */
public class actual_Room_List {

	/**
	 * Adds an actual_Room object to the static list for room database
	 * 
	 * @param global_Room_List
	 *            - static list that contains actual_Room objects which have the
	 *            room details
	 * @param obj
	 *            - actual_Room object to be added to the list
	 */
	static void add_Room(List<actual_Room> global_Room_List, actual_Room obj) {
		global_Room_List.add(obj);
	}

	/**
	 * This is the main method which makes the use of add_Room method to make
	 * the static App.actual_Room_List
	 * 
	 * @param args
	 *            - unused
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\sm_06\\Desktop\\RoomNames.csv"));

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] roomDetails = line.split(",");

				if (roomDetails.length > 0) {
					actual_Room newroom = new actual_Room(roomDetails[0], Integer.parseInt(roomDetails[1]));
					add_Room(App.actual_Room_List, newroom);
				}
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}

		App.serialize("roomlist", "room");
	}

}
