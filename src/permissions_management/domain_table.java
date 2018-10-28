package permissions_management;
import java.util.ArrayList;



public class domain_table {

	public ArrayList<ArrayList<user_account>> table = new ArrayList<ArrayList<user_account>>();
	
	domain_table()
	{
		table.add(new ArrayList<user_account>());
	}
	
	public void add_domain()
	{
		table.add(new ArrayList<user_account>());
	}
	
	public void add_control_domain(user_account controller, user_account controlling)
	{
		int n = table.get(0);
		if(!table.get(n).contains(controlling)) table.get(n).add(controlling);
	}
	
	public boolean can_control(user_account controller, user_account controlling)
	{
		return true;
	}
	
}
