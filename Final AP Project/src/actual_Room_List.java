import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class actual_Room_List {
	
	static void add_Room(List<actual_Room> global_Room_List, actual_Room obj)
	{
		global_Room_List.add(obj);
	}
	
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("C:\\Users\\sm_06\\Desktop\\RoomNames.csv"));
            
            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null) 
            {
                String[] roomDetails = line.split(",");
                
                if(roomDetails.length > 0 )
                {
                    actual_Room newroom = new actual_Room(roomDetails[0], Integer.parseInt(roomDetails[1]));
                    add_Room(App.actual_Room_List, newroom);
                }
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        App.serialize("roomlist", "room");
    }

}
