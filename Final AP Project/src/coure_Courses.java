import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class coure_Courses {
	
	static void add_Course(List<Course> global_Course_List, Course obj)
	{
		global_Course_List.add(obj);
	}
	
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("C:\\Users\\sm_06\\Desktop\\corecourses.csv"));
            
            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null) 
            {
                int a = line.indexOf("\"");
                if(a>0)
                {
                	String str = line.substring(a, line.length());
                	String str2 = str.replace(",", "|");
                	line = line.substring(0, a) + str2;
                }
                
                String[] courseDetails = line.split(",");
                
                if(courseDetails.length > 0 )
                {
                	String str = courseDetails[12].replace("|", ",");
                    Course newcourse = new Course(courseDetails[1], courseDetails[2], courseDetails[3], courseDetails[4], courseDetails[5], courseDetails[6], courseDetails[7], courseDetails[8], courseDetails[9], courseDetails[10], courseDetails[11], str);
                    add_Course(App.core_Course_List, newcourse);
                }
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        App.serialize("corecourselist", "corecourse");
    }

}
