import java.io.Serializable;

public class cancel_Booking implements Serializable{
	
	String date;
	String time;
	int duration;
	String room;
	int capacity;
	int week;
	int day;
	
	public cancel_Booking(String date, String time, int duration, String room, int capacity, int week, int day) 
	{
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.room = room;
		this.capacity = capacity;
		this.week = week;
		this.day = day;
	}

	@Override
	public String toString() {
		return "cancel_Booking [date=" + date + ", time=" + time + ", duration=" + duration + ", room=" + room
				+ ", capacity=" + capacity + ", week=" + week + ", day=" + day + "]";
	} 
	
}
