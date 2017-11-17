import java.io.Serializable;
import java.util.*;

public class user_Page implements Serializable
{
	private List<Room> bookings;

	boolean cancel_Room(Room obj)
	{
		return true; 
	} 

	boolean view_Room_Availability()
	{
		return true;
	}
	boolean get_Bookings()
	{
		return true;
	}

}
