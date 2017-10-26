import java.io.Serializable;

public class Lecture implements Serializable{
	
	private String day;
	private String start_Time;
	private int duration;
	private String room;
	private int capacity;
	private int audience;

	boolean comapre_Clash(Lecture other)
	{
		return false;
	}
	
	void show()
	{
		
	}

	public String getDay() {
		return day;
	}

	public String getStart_Time() {
		return start_Time;
	}

	public int getDuration() {
		return duration;
	}

	public String getRoom() {
		return room;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getAudience() {
		return audience;
	}	
}