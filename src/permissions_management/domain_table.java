import java.util.ArrayList;



public class domain_table {

	public ArrayList<ArrayList<domain_access_list>> table = new ArrayList<ArrayList<domain_access_list>>();
	
	domain_table()
	{
		
	}
	
	public void add_domain()
	{
		table.add(new ArrayList<domain_access_list>());
	}
	
	public void add_control_domain(domain controller, domain controlling)
	{
		//int n = table.indexOf(controller);
		//if(table.get(n).contains(controlling)) table.get(n).add(controlling);
	}
	
	public void can_control(domain controller, domain controlling)
	{
		
	}
	
}
