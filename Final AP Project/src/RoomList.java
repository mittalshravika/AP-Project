import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class RoomList {
	
	static void add_Room(List<actual_Room> global_Room_List, actual_Room obj)
	{
		global_Room_List.add(obj);
	}
	
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("RoomNames.csv"));
            
            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null) 
            {
                String[] details = line.split(",");
                add_Room(App.actual_Room_List, new actual_Room(details[0], Integer.parseInt(details[1])));
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        App.serialize("corecourselist", "corecourse");
    }

}


