import java.io.Serializable;

import java.util.*;
import java.lang.*;

public class User implements Serializable
{
	private String name;
	private String type_of_user;
	private String email_id;
	private String password;
	private user_Page page;
	
	public User(String A, String B, String C, String D)
	{
		this.name = new String(A);
		this.type_of_user = new String(B);
		this.email_id = new String(C);
		this.password = new String(D);
		this.page = null;
	}
	
	static boolean Sign_Up(String Name, String Email, String Type, String Pass1, String Pass2)
	{
		boolean check = true;
		if(Name == null || Name.equals("") );
		{
			System.out.println("Enter a valid name");
			check = false;
			
		}
		if(Email == null || Email.equals(""))
		{
			System.out.println("Enter a valid Email ID");
			check = false;
			
		}
		else
		{
			check = enter_Email_Id(Email);
			
		}
		if(Pass1 == null || Pass1.equals(""))
		{
			System.out.println("Enter the password");
			check = false;
		}
		return check = check_Password(Pass1, Pass2);
		
		
		
	}
 

	static boolean enter_Email_Id(String A)
	{
		int size = A.length();
		boolean flag = true;
		String check = new String("@iiitd.ac.in");
		if(size < 13)
			return false;
		for(int i = 0; i < 12; i++)
		{
			if(A.charAt(size-13 + i) != check.charAt(i))
				return false;
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
		
		return false;
		
	}
	boolean encrypt() 
	{
		/* bonus */
		return true;
	} 

	boolean user_Login()
	{
		return true;
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

}