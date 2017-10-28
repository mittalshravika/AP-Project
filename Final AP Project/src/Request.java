import java.util.*;
import java.io.Serializable;
import java.lang.*;

public class Request implements Serializable
{
	String purpose;
	String preferred_Room;
	int capacity;
	boolean approved;

	boolean approved_room()
	{
		return approved;

	}
}
