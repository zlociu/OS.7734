import java.util.ArrayList;
import java.util.List;


public class process_list {
	public List<process> proc_list = new ArrayList<process>();
	
	process_list()
	{
		
	}
	
	process_list(process p1)
	{
		proc_list.add(p1);
	}
	
	public int find_process_index(String name)
	{
		for(int i=0;i<proc_list.size();i++)
		{
			if(proc_list.get(i).proc_name == name) return i;
		}
		return -1;
	}
	
	public void add(process p1)
	{
		proc_list.add(p1);
		System.out.println("Dodano proces "+ p1.proc_name);
	}
	
	public void delete(process p1)
	{
		int i = proc_list.indexOf(p1);
		if(i!=-1) 
			{
				proc_list.remove(i);
				System.out.println("Usunieto proces");
			}

	}
	
	public void show_process_list()
	{
		for(process e : proc_list)
		{
			System.out.println(e.proc_name);
			
			for(domain_access_list f : e.lista)
			{
				System.out.println("  " + f.get_name());
				System.out.println("    " + f.access_collection);
			}
		}
	}
	
}
