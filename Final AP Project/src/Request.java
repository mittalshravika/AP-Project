import java.util.*;
import java.io.Serializable;
import java.lang.*;
import java.time.LocalDate;
/**
 * Request Class defined here
 * Cantains all details of the User's Request
 * 
 *  
 * @author Yajur - 2016121
 * @author Shravika - 2016093 
 * 
 */
public class Request implements Serializable
{
	User RequestUser;
	String purpose;
	String preferred_Room;
	@Override
	/**
	 * to String Function
	 * @return a string 
	 */
	public String toString() {
		return "Request [RequestUser=" + RequestUser + ", purpose=" + purpose + ", preferred_Room=" + preferred_Room
				+ ", capacity=" + capacity + ", duration=" + duration + ", Approved=" + Approved + ", Cancel=" + Cancel
				+ ", date=" + date + ", time=" + time + ", currentTime=" + currentTime + "]";
	}

	int capacity;
	int duration;
	boolean Approved; 
	boolean Cancel;
	String date;
	String time;
	String currentTime;
	static int ref = 0;
	int identify;
	LocalDate d;
	
	/**
	 * Constructor for the Request Details
	 * @param User1 The User(Student) who made the booking
	 * @param a Purpose for which the room is required
	 * @param b preferred room 
	 * @param c capacity
	 * @param d date of room requirement
	 * @param t time of room requirement
	 * @param duration max duration 
	 * @param c_t current time
	 * @param date current date
	 */
	public Request(User User1, String a, String b, int c, String d, String t, int duration, String c_t, LocalDate date)
	{
		this.RequestUser = User1;
		this.purpose = new String(a);
		this.preferred_Room = new String(b);
		this.capacity = c;
		this.date = new String(d);
		this.time = new String(t);
		this.duration = duration;
		this.currentTime = c_t;
		this.Approved = false;
		this.Cancel = false;
		ref = ref+1;
		this.identify = ref;
		this.d = date;
	}
	/**
	 * setter fuction for approval
	 * @param A Approving 
	 * @param B Canceling 
	 */
	void setApproval(Boolean A, Boolean B)
	{
		Approved = A;
		Cancel = B;
	}
	
	/**
	 * Getter function for approval
	 * @return returns a boolean for approval check
	 */
	boolean approved_room()
	{
		return Approved;

	}
}
