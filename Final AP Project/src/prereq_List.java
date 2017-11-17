import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * 
 * prereq_list.java is used for reading the .csv for prereq Details
 * and storing them
 * 
 * @author Yajur Ahuja - 2016121
 * @author Shravika Mittal - 2016093
 *
 */
public class prereq_List {

	/**
	 * Adds a Prereq object to the static list for prerequisites database
	 * 
	 * @param global_prereq_List
	 *            - static list that contains prereq objects which have the
	 *            prerequisite subject details
	 * @param obj
	 *            - prereq object to be added to the list
	 */
	static void add_course(List<Prereq> global_prereq_List, Prereq obj) {
		global_prereq_List.add(obj);
	}

	/**
	 * This is the main method which makes the use of add_course method to make
	 * the static App.prereqlist
	 * 
	 * @param args
	 *            - unused
	 * @throws IOException - Exception for serialising
	 */
	public static void main(String args[]) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\sm_06\\Desktop\\prereq.csv"));

			String line = "";
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] prereqDetails = line.split(",");

				if (prereqDetails.length > 0) {
					
					Prereq obj = new Prereq();
					obj.coursename = prereqDetails[1];
					String[] arr = prereqDetails[2].split(";");
					for(int i = 0 ; i<arr.length ; i++)
					{
						obj.courses.add(arr[i]);
					}
					for(int j = 0 ; j<obj.courses.size() ; j++)
					{
						System.out.println(obj.courses.get(j));
					}
					add_course(App.prereqlist, obj);
				}
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}

		App.serialize("prereqlist", "prereq");
	}

}
