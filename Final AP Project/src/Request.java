import java.util.*;
import java.io.Serializable;
import java.lang.*;

public class Request implements Serializable
{
	String purpose;
	String preferred_Room;
	int capacity;
	int duration;
	boolean approved; 
	String date;
	String time;
	String currentTime;
	
	public Request(String a, String b, int c, String d, String t, int duration, String c_t)
	{
		this.purpose = new String(a);
		this.preferred_Room = new String(b);
		this.capacity = c;
		this.date = new String(d);
		this.time = new String(t);
		this.duration = duration;
		this.currentTime = c_t;
		this.approved = false;
		
	}

	void setApproval(Boolean A)
	{
		approved = A;
	}
	
	boolean approved_room()
	{
		return approved;

	}
}
