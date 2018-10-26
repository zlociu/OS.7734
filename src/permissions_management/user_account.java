
public class user_account {

	private String user_name;
	//private String password;
	private int type; //admin = 0, normal = 1,2,3,4, ....
	
	
	public user_account(String name) 
	{
		  this.user_name = name;
		  ///this.user_name = password;
	}
	
	public user_account(String name, boolean admin) 
	{
		  this.user_name = name;
		 /// this.user_name = password;
		  if(admin == true) this.type = 0;
		  else this.type = 1;
	}
	
	public String get_name()
	{
		return this.user_name;
	}
	
	public void set_name(String new_name)
	{
		user_name = new_name;
	}
	
	public void set_type(int value)
	{
		this.type = value;
	}
	
	
	public boolean is_admin()
	{
		if(type==0) return true;
		return false;
	}
	
}
