import java.io.IOException;
import java.io.Serializable;

import java.util.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.lang.*;

class EnterValidNameException extends Exception {
	EnterValidNameException(String message) {
		super(message);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Please do not leave the required Name Field blank");
		alert.showAndWait();
	}
}

class AlreadyAUserException extends Exception {
	AlreadyAUserException(String message) {
		super(message);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("You are already a User");
		alert.showAndWait();
	}
}

class EnterValidEmailIDException extends Exception {
	EnterValidEmailIDException(String message) {
		super(message);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Enter a valid EmailID in the required field");
		alert.showAndWait();
	}
}

class EnterPasswordException extends Exception {
	EnterPasswordException(String message) {
		super(message);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Please do not leave the required Password Field blank");
		alert.showAndWait();
	}
}

class PasswordsDontMatchException extends Exception {
	PasswordsDontMatchException(String message) {
		super(message);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Password and confirmed password do not match");
		alert.showAndWait();
	}
}

public class User implements Serializable
{
	private String name;
	private String type_of_user;
	private String email_id;
	private String password;
	private user_Page page;
	public time_Table obj;
	ArrayList<cancel_Booking> bookings = new ArrayList<cancel_Booking>();
	ArrayList<Request> MyRequests = new ArrayList<Request>();
	ArrayList<Course> newcourse_List = new ArrayList<Course>();
	
	public String getName() {
		return name;
	}

	public String getType_of_user() {
		return type_of_user;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail_id() {
		return email_id;
	}
	
	public List<Request> getMyRequests()
	{
		return MyRequests;
	}
	
	public User(String A, String B, String C, String D)
	{
		this.name = new String(A);
		this.type_of_user = new String(B);
		this.email_id = new String(C);
		this.password = new String(D);
		this.page = null;
	}
	
	public User() {
		
	}

	static boolean Sign_Up(String Name, String Email, String Type, String Pass1, String Pass2) throws ClassNotFoundException, IOException 
	{
		
		
		boolean check = true;
		if(Name == null || Name.equals(""))
		{
			try {
				throw new EnterValidNameException("EnterValidNameException: Please do not leave the Name field blank");
			} catch (EnterValidNameException e) {
				System.out.println(e.getMessage());
			}
			check = false;
			
		}
		if(Email == null || Email.equals(""))
		{
			try {
				throw new EnterValidEmailIDException("EnterValidEmailIDException: Enter a valid EmailID in the required field");
			} catch (EnterValidEmailIDException e) {
				System.out.println(e.getMessage());
			}
			check = false;
			
		}
		else
		{
			check = enter_Email_Id(Email);
			if(check == false)
			{
				try {
					throw new EnterValidEmailIDException("EnterValidEmailIDException: Enter a valid EmailID in the required field");
				} catch (EnterValidEmailIDException e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
		
		App.deserialize("UserList");
		
		for(int j = 0 ; j<App.user_List.size() ; j++)
		{
			if(App.user_List.get(j).email_id.equals(Email))
			{
				check = false;
				try {
					throw new AlreadyAUserException("AlreadyAUserException: You are already a user");
				} catch (AlreadyAUserException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}
		
		App.serialize("UserList", "user");
		
		if(Pass1 == null || Pass1.equals(""))
		{
			try {
				throw new EnterPasswordException("EnterPasswordException: Please do not leave the required Password field blank");
			} catch (EnterPasswordException e) {
				System.out.println(e.getMessage());
			}
			check = false;
		}
		if(check)
			check = check_Password(Pass1, Pass2);
		
		return check;
		
		
		
	}
 

	static boolean enter_Email_Id(String A)
	{
		int size = A.length();
		boolean flag = true;
		String check = new String("@iiitd.ac.in");
		if(size < 13)
		{
			return false;
		}
		for(int i = 0; i < 12; i++)
		{
			
			if(A.charAt(size-12 + i) != check.charAt(i))
			{
				return false;
			}
		}
		return true;
	} 

	static boolean check_Password(String pass, String pass2)
	{
		if(pass.equals(pass2))
		{
			return true;
		}
		System.out.println("Passwords don't match");
		try {
			throw new PasswordsDontMatchException("PasswordsDontMatchException: Enter a valid EmailID (@iiitd.ac.in) in the required field");
		} catch (PasswordsDontMatchException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
		
	}
	boolean encrypt() 
	{
		/* bonus */
		return true;
	} 

	static boolean Login(String Email, String Pass)
	{
		boolean check = true;
		if(Email == null || Email.equals(""))
		{
			System.out.println("Enter a valid Email ID");
			check = false;
			
		}
		else if(check)
		{
			check = enter_Email_Id(Email);
			
		}
		if(check)
		{
			
			check = false;
			for(int i = 0; i < App.getUser_List().size(); i++)
			{

				
				if(App.getUser_List().get(i).getEmail_id().equals(Email))
				{
					//System.out.println("YOLO");
					if(App.getUser_List().get(i).getPassword().equals(Pass))
					{
						//System.out.println("YO");
						check = true;
						return check;
					}
				}
			}
		}
		
			
		return check;
	}

	boolean user_Logout()
	{
		return true;
	}

	boolean user_Signup()
	{
		return true;
	}

	boolean user_Page()
	{
		return true;
	}

	static boolean add_User(List<User> A, User B)
	{
		A.add(B);
		return true;
	}
	
	void check()
	{
		for(int i = 0 ; i<bookings.size() ; i++)
		{
			System.out.println(bookings.get(i).toString());
		}
	}
}