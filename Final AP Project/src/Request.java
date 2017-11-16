import java.util.*;
import java.io.Serializable;
import java.lang.*;

public class Request implements Serializable
{
	User RequestUser;
	String purpose;
	String preferred_Room;
	@Override
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
	
	public Request(User User1, String a, String b, int c, String d, String t, int duration, String c_t)
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
	}

	void setApproval(Boolean A)
	{
		Approved = A;
	}
	
	boolean approved_room()
	{
		return Approved;

	}
}
