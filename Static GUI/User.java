import java.io.Serializable;

import java.util.*;
import java.lang.*;

public class User implements Serializable
{
	private String type_of_user;
	private String email_id;
	private String password;
	private user_Page page;
	
	public User(String A, String B, String C)
	{
		this.type_of_user = new String(A);
		this.email_id = new String(B);
		this.password = new String(C);
		this.page = null;
	}
	
	static boolean Sign_Up(String Name, String Email, String Type, String Pass1, String Pass2)
	{
		return false;
		
	}
 

	boolean enter_Email_Id(String A)
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

	boolean add_User(/*User List*/)
	{
		return true;
	}

}