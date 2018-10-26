import java.util.ArrayList;



public class domain_access_list {
	
	public user_account user;
	public ArrayList<access_mode> access_collection = new ArrayList<access_mode>();
	
	domain_access_list(user_account name)
	{
		this.user = name;
	}
	domain_access_list(user_account name, ArrayList<access_mode> l)
	{
		this.user =  name;
		this.access_collection = l;
	}
	domain_access_list(user_account name, access_mode mode)
	{
		this.user = name;
		this.access_collection.add(mode);
	}
	
	public String get_name()
	{
		return this.user.get_name();
	}
	
	public void add_right(access_mode right)
	{
		if(!access_collection.contains(right)) access_collection.add(right);
	}
	
	public void remove_right(access_mode right)
	{
		if(access_collection.contains(right)) access_collection.remove(right);
	}
	
	public void show_right()
	{
		for(access_mode e : access_collection)
		{
			System.out.println(e.value);
		}
	}
}
