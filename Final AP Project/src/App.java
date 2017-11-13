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
	static User obj;
	static List<Request> admin_List = new ArrayList<>();
	
	public static List<User> getUser_List() {
		return user_List;
	}

	public static List<Course> getCourse_List() {
		return course_List;
	}
	
	public static List<Request> getAdmin_List(){
		return admin_List;
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
			else if(A.equals("roomlist"))
			{
				actual_Room_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./"+ A + ".ser"));
				//System.out.println("Check2");
				while(true)
				{	try
					{	
						actual_Room Input = (actual_Room)in.readObject();
						actual_Room_List.add(Input);
					}
					catch (Exception e)
					{
						break;
					}
				}
			}

			else if(A.equals(obj.getEmail_id()))
			{
				obj.bookings = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./"+ A + ".ser"));
				//System.out.println("Check2");
				while(true)
				{	try
					{	
						cancel_Booking Input = (cancel_Booking)in.readObject();
						obj.bookings.add(Input);
					}
					catch (Exception e)
					{
						break;
					}
				}
			}
			else if(A.equals("adminrequestlist"))
			{
				admin_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./"+ A + ".ser"));
				//System.out.println("Check2");
				while(true)
				{	try
					{	
						Request Input = (Request)in.readObject();
						admin_List.add(Input);
					}
					catch (Exception e)
					{
						break;
					}
				}
			}
			else if(A.equals(obj.getEmail_id()+"new"))
			{
				obj.newcourse_List = new ArrayList<>();
				in = new ObjectInputStream(new FileInputStream("./"+ A + ".ser"));
				//System.out.println("Check2");
				while(true)
				{	try
					{	
						Course Input = (Course)in.readObject();
						obj.newcourse_List.add(Input);
					}
					catch (Exception e)
					{
						break;
					}
				}
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
		cancel_Booking Output4;
		Request Output5;
		Course Output6;
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

			else if(B.equals("book"))
			{
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for(int i = 0; i < obj.bookings.size(); i++)
				{
					Output4 = obj.bookings.get(i);
					out.writeObject(Output4);
				}
			}
			else if(B.equals("adminrequest"))
			{
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				for(int i = 0; i < admin_List.size(); i++)
				{
					Output5 = admin_List.get(i);
					out.writeObject(Output5);
				}
			}
			else if(B.equals("register"))
			{
				out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
				System.out.print(obj);
				for(int i = 0; i < obj.newcourse_List.size(); i++)
				{
					Output6 = obj.newcourse_List.get(i);
					out.writeObject(Output6);
				}
			}
		}
		finally
		{
			out.close();
		}

	}
}