import java.util.*;
import java.lang.*;

public class user_Page_Admin extends user_Page_Super
{
	List<Request> requests;

	boolean approve_Request(Request obj)
	{
		return false;

	}
	boolean auto_Delete()
	{
		return false;

	}
	boolean delete_Request(Request obj)
	{
		return false;
		
	}
	List<Request> get_Request()
	{
		return requests;

	}
}
