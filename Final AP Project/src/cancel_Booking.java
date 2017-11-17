import java.io.Serializable;

/**
 * cancel_ Booking.java is used for creating the book room objects for faculty
 * and admin
 * 
 * @author Yajur Ahuja - 2016121
 * @author Shravika Mittal - 2016093
 *
 */
public class cancel_Booking implements Serializable {

	String date;
	String time;
	int duration;
	String room;
	int capacity;
	int week;
	int day;
	String name;

	/**
	 * Constructor for cancel_Booking.java
	 * 
	 * @param date
	 * @param time
	 * @param duration
	 * @param room
	 * @param capacity
	 * @param week
	 * @param day
	 */
	public cancel_Booking(String date, String time, int duration, String room, int capacity, int week, int day,
			String name) {
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.room = room;
		this.capacity = capacity;
		this.week = week;
		this.day = day;
		this.name = name;
	}

	/**
	 * toString() method for printing the contents of cancel_Booking objects
	 * 
	 * @return string for booking details
	 */
	@Override
	public String toString() {
		return "cancel_Booking [date=" + date + ", time=" + time + ", duration=" + duration + ", room=" + room
				+ ", capacity=" + capacity + ", week=" + week + ", day=" + day + "]";
	}

}
