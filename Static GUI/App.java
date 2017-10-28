import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class App {
	static List<User> user_List = new ArrayList<>();
	
	public static void deserialize(String A) 
	throws IOException, ClassNotFoundException
	{
		//System.out.println(A);
		ObjectInputStream in = null;
		try
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
		finally
		{
			in.close();
		}
	}	
	
	public static void serialize(String A)
	throws IOException
	{
		User Output;
		ObjectOutputStream out = null;
		try
		{
			out = new ObjectOutputStream(new FileOutputStream("./" + A + ".ser"));
			for(int i = 0; i < user_List.size(); i++)
			{
				Output = user_List.get(i);
				out.writeObject(Output);
			}
		}
		finally
		{
			out.close();
		}

	}
}
