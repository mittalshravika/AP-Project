
/**
 * <h1> IIITD Classroom Booking System </h1>
 * The App class initialises all the static lists for database of courses, core courses, userlist, roomlist, adminrequestlist
 * 
 * <b>It contains the serialise and deserialise methods also for the above mentioned lists</b>
 * 
 * @author Yajur Ahuja - 2016121
 * @author Shravika Mittal - 2016093
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
	static List<User> user_List = new ArrayList<>();
	static List<Course> course_List = new ArrayList<>();
	static List<Course> core_Course_List = new ArrayList<>();
	static List<actual_Room> actual_Room_List = new ArrayList<>();
	static User obj;
	static List<Request> admin_List = new ArrayList<>();
	static List<request_Object_Identity> request = new ArrayList<>();
	static List<Prereq> prereqlist = new ArrayList();

	/**
	 * 
	 * This is a getter function for user_List
	 * 
	 * @param unused
	 * @return user_List that contains all the users signed up in the system
	 */
	public static List<User> getUser_List() {
		return user_List;
	}

	/**
	 * This is a getter function for course_List
	 * 
	 * @param unused
	 * @return course_List that contains information about all the CSE courses
	 *         offered to second year students in monsoon semester
	 */
	public static List<Course> getCourse_List() {
		return course_List;
	}

	/**
	 * This is a getter function for admin_List
	 * 
	 * @param unused
	 * @return admin_List that contains the requests made by students to the admin
	 *         for room booking
	 */
	public static List<Request> getAdmin_List() {
		return admin_List;
	}

	/**
	 * 
	 * @param A
	 *            describing which list to deserialize
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void deserialize(String A) throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try {
			if (A.equals("UserList")) {
				user_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						User Input = (User) in.readObject();
						user_List.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			} else if (A.equals("courselist")) {
				course_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						Course Input = (Course) in.readObject();
						course_List.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			} else if (A.equals("corecourselist")) {
				core_Course_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						Course Input = (Course) in.readObject();
						core_Course_List.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			} else if (A.equals("roomlist")) {
				actual_Room_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						actual_Room Input = (actual_Room) in.readObject();
						actual_Room_List.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			}

			else if (A.equals(obj.getEmail_id())) {
				obj.bookings = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						cancel_Booking Input = (cancel_Booking) in.readObject();
						obj.bookings.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			} else if (A.equals("adminrequestlist")) {
				admin_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						Request Input = (Request) in.readObject();
						admin_List.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			} else if (A.equals(obj.getEmail_id() + "new")) {
				obj.newcourse_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						Course Input = (Course) in.readObject();
						obj.newcourse_List.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			}

			else if (A.equals("requestlist")) {
				App.request = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						request_Object_Identity Input = (request_Object_Identity) in.readObject();
						App.request.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			}
			
			else if (A.equals("prereqlist")) {
				App.prereqlist = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./" + A + ".ser"));
				while (true) {
					try {
						Prereq Input = (Prereq) in.readObject();
						App.prereqlist.add(Input);
					} catch (Exception e) {
						break;
					}
				}
			}

		} finally {
			in.close();
		}
	}

	/**
	 * 
	 * @param current
	 *            - which is the student user whose request list has to be
	 *            deserialized
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void deserializeRequests(User current) throws FileNotFoundException, IOException {
		current.MyRequests = new ArrayList<>();
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("./" + current.getEmail_id() + "Requests" + ".ser"));
		while (true) {
			try {
				Request Input = (Request) in.readObject();
				current.MyRequests.add(Input);
			} catch (Exception e) {
				break;
			}
		}

	}

	/**
	 * 
	 * @param current
	 *            - which is the student user whose request list has to be
	 *            serialized
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void serializeRequests(User current) throws FileNotFoundException, IOException {
		Request Output5;
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("./" + current.getEmail_id() + "Requests" + ".ser"));
		for (int i = 0; i < current.MyRequests.size(); i++) {
			Output5 = current.MyRequests.get(i);
			out.writeObject(Output5);
		}
	}

	/**
	 * 
	 * @param A
	 *            which is the name of the list to be serialised
	 * @param B
	 *            tells which list has to be serialized
	 * @throws IOException
	 */
	public static void serialize(String A, String B) throws IOException {
		User Output;
		Course Output2;
		actual_Room Output3;
		cancel_Booking Output4;
		Request Output5;
		Course Output6;
		request_Object_Identity Output7;
		Prereq Output8;
		ObjectOutputStream out = null;
		try {
			if (B.equals("user")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < user_List.size(); i++) {
					Output = user_List.get(i);
					out.writeObject(Output);
				}
			} else if (B.equals("course")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < course_List.size(); i++) {
					Output2 = course_List.get(i);
					out.writeObject(Output2);
				}
			} else if (B.equals("corecourse")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < core_Course_List.size(); i++) {
					Output2 = core_Course_List.get(i);
					out.writeObject(Output2);
				}
			} else if (B.equals("room")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < actual_Room_List.size(); i++) {
					Output3 = actual_Room_List.get(i);
					out.writeObject(Output3);
				}
			}

			else if (B.equals("book")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < obj.bookings.size(); i++) {
					Output4 = obj.bookings.get(i);
					out.writeObject(Output4);
				}
			} else if (B.equals("adminrequest")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < admin_List.size(); i++) {
					Output5 = admin_List.get(i);
					out.writeObject(Output5);
				}
			} else if (B.equals("register")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < obj.newcourse_List.size(); i++) {
					Output6 = obj.newcourse_List.get(i);
					out.writeObject(Output6);
				}
			}

			else if (B.equals("request")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < App.request.size(); i++) {
					Output7 = App.request.get(i);
					out.writeObject(Output7);
				}
			}
			
			else if (B.equals("prereq")) {
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for (int i = 0; i < App.prereqlist.size(); i++) {
					Output8 = App.prereqlist.get(i);
					out.writeObject(Output8);
				}
			}
		} finally {
			out.close();
		}

	}
}