import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Course.java creates the course objects for all the courses offered to CSE 2nd
 * year students static list for course list created using serialisation
 * 
 * @author Yajur Ahuja - 2016121
 * @author Shravika Mittal - 2016093
 *
 */
public class Course implements Serializable {

	/* Database variables */
	private String coursetype;
	private String coursename;
	private String coursecode;
	private String instructorname;
	private String credits;
	private String acronym;
	private String mon;
	private String tue;
	private String wed;
	private String thurs;
	private String fri;
	private String postconditions;

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for Course.java
	 * 
	 * @param coursetype
	 * @param coursename
	 * @param coursecode
	 * @param instructorname
	 * @param credits
	 * @param acronym
	 * @param mon
	 * @param tue
	 * @param wed
	 * @param thurs
	 * @param fri
	 * @param postconditions
	 */
	public Course(String coursetype, String coursename, String coursecode, String instructorname, String credits,
			String acronym, String mon, String tue, String wed, String thurs, String fri, String postconditions) {
		this.coursetype = coursetype;
		this.coursename = coursename;
		this.coursecode = coursecode;
		this.instructorname = instructorname;
		this.credits = credits;
		this.acronym = acronym;
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thurs = thurs;
		this.fri = fri;
		this.postconditions = postconditions;
	}

	/**
	 * Getter function for Course Type
	 * 
	 * @return coursetype(String) - Mandatory or Elective
	 */
	public String getCoursetype() {
		return coursetype;
	}

	/**
	 * Getter function for course name
	 * 
	 * @return coursename(String) - Name of the course
	 */
	public String getCoursename() {
		return coursename;
	}

	/**
	 * Getter function for Course Code
	 * 
	 * @return coursecode(String) - Course Number
	 */
	public String getCoursecode() {
		return coursecode;
	}

	/**
	 * Getter function for Instructor of the course
	 * 
	 * @return instructorname(String) - Name of the instructor
	 */
	public String getInstructorname() {
		return instructorname;
	}

	/**
	 * Getter function for course credits
	 * 
	 * @return credits(String) - Course credits
	 */
	public String getCredits() {
		return credits;
	}

	/**
	 * Getter function for course acronym
	 * 
	 * @return acronym(String)
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * Getter function for course time and venue on monday
	 * 
	 * @return mon(String)
	 */
	public String getMon() {
		return mon;
	}

	/**
	 * Getter function for course time and venue on tuesday
	 * 
	 * @return tue(String)
	 */
	public String getTue() {
		return tue;
	}

	/**
	 * Getter function for course time and venue on wednesday
	 * 
	 * @return wed(String)
	 */
	public String getWed() {
		return wed;
	}

	/**
	 * Getter function for course time and venue on thursday
	 * 
	 * @return thurs(String)
	 */
	public String getThurs() {
		return thurs;
	}

	/**
	 * Getter function for course time and venue on friday
	 * 
	 * @return fri(String)
	 */
	public String getFri() {
		return fri;
	}

	/**
	 * Getter function for course post-condtions
	 * 
	 * @return postconditions(String)
	 */
	public String getPostconditions() {
		return postconditions;
	}

	/**
	 * Getter function for SerialVersionUID
	 * 
	 * @return serialVersionUID(long)
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * toString() method for printing the contents of Course objects
	 * 
	 * @return string for course details
	 */
	@Override
	public String toString() {
		return "Course [coursetype=" + coursetype + ", coursename=" + coursename + ", coursecode=" + coursecode
				+ ", instructorname=" + instructorname + ", credits=" + credits + ", acronym=" + acronym + ", mon="
				+ mon + ", tue=" + tue + ", wed=" + wed + ", thurs=" + thurs + ", fri=" + fri + ", postconditions="
				+ postconditions + "]";
	}

	void show() {
		return;
	}

	boolean search(String keywords) {
		return false;
	}

	/**
	 * Adds an Course object to the static list for Course list database
	 * 
	 * @param global_Course_List
	 *            - static list that contains Course objects which have the
	 *            course details
	 * @param obj
	 *            - Course object to be added to the list
	 */
	static void add_Course(List<Course> global_Course_List, Course obj) {
		global_Course_List.add(obj);
	}

	/**
	 * Prints the course details for all the courses
	 * 
	 * @param global_Course_List
	 *            - static list that contains Course objects which have the
	 *            course details
	 */
	static void print_Course(List<Course> global_Course_List) {
		for (int i = 0; i < global_Course_List.size(); i++) {
			System.out.println(global_Course_List.get(i).toString());
		}
	}

	/**
	 * This is the main method which makes the use of add_Course method to make
	 * the static App.course_List
	 * 
	 * @param unused
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\sm_06\\Desktop\\Database.csv"));

			String line = "";
			br.readLine();
			while ((line = br.readLine()) != null) {
				int a = line.indexOf("\"");
				if (a > 0) {
					String str = line.substring(a, line.length());
					String str2 = str.replace(",", "|");
					line = line.substring(0, a) + str2;
				}

				String[] courseDetails = line.split(",");

				if (courseDetails.length > 0) {
					String str = courseDetails[12].replace("|", ",");
					Course newcourse = new Course(courseDetails[1], courseDetails[2], courseDetails[3],
							courseDetails[4], courseDetails[5], courseDetails[6], courseDetails[7], courseDetails[8],
							courseDetails[9], courseDetails[10], courseDetails[11], str);
					add_Course(App.course_List, newcourse);
				}
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		App.serialize("courselist", "course");

		request_Object_Identity obj = new request_Object_Identity();
		obj.ref = 1;
		App.request.add(obj);
		App.serialize("requestlist", "request");

	}
}
