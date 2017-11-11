import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
	static List<User> user_List = new ArrayList<>();
	static List<Course> course_List = new ArrayList<>();
	static List<Course> core_Course_List = new ArrayList<>();
	static List<actual_Room> actual_Room_List = new ArrayList<>();
	
	public static List<User> getUser_List() {
		return user_List;
	}

	public static List<Course> getCourse_List() {
		return course_List;
	}

	public static void deserialize(String A) 
	throws IOException, ClassNotFoundException
	{
		//System.out.println(A);
		ObjectInputStream in = null;
		try
		{
			if(A.equals("UserList"))
			{
				user_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./"+ A + ".ser"));
				//System.out.println("Check2");
				while(true)
				{	try
					{	
						User Input = (User)in.readObject();
						user_List.add(Input);
					}
					catch (Exception e)
					{
						break;
					}
				}
			}
			else if(A.equals("courselist"))
			{
				course_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./"+ A + ".ser"));
				//System.out.println("Check2");
				while(true)
				{	try
					{	
						Course Input = (Course)in.readObject();
						course_List.add(Input);
					}
					catch (Exception e)
					{
						break;
					}
				}
			}
			else if(A.equals("corecourselist"))
			{
				core_Course_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./"+ A + ".ser"));
				//System.out.println("Check2");
				while(true)
				{	try
					{	
						Course Input = (Course)in.readObject();
						core_Course_List.add(Input);
					}
					catch (Exception e)
					{
						break;
					}
				}
			}
			else if(A.equals("RoomList"))
			{
				
			}
		}
		finally
		{
			in.close();
		}
	}	
	
	public static void serialize(String A, String B)
	throws IOException
	{
		User Output;
		Course Output2;
		actual_Room Output3;
		ObjectOutputStream out = null;
		try
		{
			if(B.equals("user"))
			{
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for(int i = 0; i < user_List.size(); i++)
				{
					Output = user_List.get(i);
					out.writeObject(Output);
				}
			}
			else if(B.equals("course"))
			{
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for(int i = 0; i < course_List.size(); i++)
				{
					Output2 = course_List.get(i);
					out.writeObject(Output2);
				}
			}
			else if(B.equals("corecourse"))
			{
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for(int i = 0; i < core_Course_List.size(); i++)
				{
					Output2 = core_Course_List.get(i);
					out.writeObject(Output2);
				}
			}
			else if(B.equals("room"))
			{
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for(int i = 0; i < actual_Room_List.size(); i++)
				{
					Output3 = actual_Room_List.get(i);
					out.writeObject(Output3);
				}
			}
		}
		finally
		{
			out.close();
		}

	}
}