package permissions_management;
import java.util.ArrayList;

public class process {

	public String proc_name;
	public ArrayList <domain_access_list> lista = new ArrayList<domain_access_list>();
	
	process()
	{
		
	}
	
	process(String name)
	{
		this.proc_name = name;
	}
	
	public boolean exist_name(String name)
	{
		for(domain_access_list e : lista)
			{
				if(e.user.get_name()==name) return true;
			}
		return false;
	}
	
	public void add_domain_own(user_account name)
	{
		if(!exist_name(name.get_name()))
			{
			lista.add(new domain_access_list(name,access_mode.OWNER));
			if(name.is_admin())
				{
					lista.get(lista.size()-1).add_right(access_mode.READ_COPY);
					lista.get(lista.size()-1).add_right(access_mode.WRITE_COPY);
					lista.get(lista.size()-1).add_right(access_mode.EXECUTE_COPY);
				}
			}
	}
	
	public void add_domain(user_account name)
	{
		if(!exist_name(name.get_name()))
			{
				lista.add(new domain_access_list(name));
				if(name.is_admin())
				{
					lista.get(lista.size()-1).add_right(access_mode.READ_COPY);
					lista.get(lista.size()-1).add_right(access_mode.WRITE_COPY);
					lista.get(lista.size()-1).add_right(access_mode.EXECUTE_COPY);
				}
			}
	}
	
	public void delete_domain(user_account name)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).get_name() == name.get_name())
			{
				lista.remove(i);
				break;
			}
		}
	}
	
	public boolean have_right(String name, access_mode value)
	{
		int n = -1;
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).get_name() == name)
			{
				n = i;
				break;
			}
		}
		if(n!=-1)
		{
			if(lista.get(n).access_collection.contains(value)) return false;
			else return false;
		}
		return false;
	}
	
	public void add_right(String name,access_mode value)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).get_name() == name)
			{
				lista.get(i).add_right(value);
				break;
			}
		}
	}
	
	public void copy_right(String name_from,String name_to,access_mode value)
	{
		int from = -1;
		int to = -1;
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).get_name() == name_from)
			{
				from = i;
			}
			if(lista.get(i).get_name() == name_to)
			{
				to = i;
			}
		}
		switch(value)
		{
		case READ: 
		{
			if(lista.get(from).access_collection.contains(access_mode.READ_COPY))
			{
				//System.out.println(access_mode.READ_COPY);
				if(!lista.get(to).access_collection.contains(value)) lista.get(to).access_collection.add(value);
			}
		};break;
		case WRITE:
		{
			if(lista.get(from).access_collection.contains(access_mode.WRITE_COPY))
			{
				//System.out.println(access_mode.WRITE_COPY);
				if(!lista.get(to).access_collection.contains(value)) lista.get(to).access_collection.add(value);
			}
		};break;
		case EXECUTE:
		{
			if(lista.get(from).access_collection.contains(access_mode.EXECUTE_COPY))
			{
				//System.out.println(access_mode.EXECUTE_COPY);
				if(!lista.get(to).access_collection.contains(value)) lista.get(to).access_collection.add(value);
			}
		}
		default: break;
		}
	}
	
	public void move_right(String name_from,String name_to,access_mode value)
	{
		int from = -1;
		int to = -1;
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).get_name() == name_from)
			{
				from = i;
			}
			if(lista.get(i).get_name() == name_to)
			{
				to = i;
			}
		}
		switch(value)
		{
		case READ: 
		{
			if(lista.get(from).access_collection.contains(access_mode.READ_COPY))
			{
			//System.out.println(access_mode.READ_COPY);
				if(!lista.get(to).access_collection.contains(value))
					{
					lista.get(to).access_collection.add(value);
					lista.get(from).access_collection.remove(value);
					}
			}
		};break;
		case WRITE:
		{
			if(lista.get(from).access_collection.contains(access_mode.WRITE_COPY))
			{
				//System.out.println(access_mode.WRITE_COPY);
				if(!lista.get(to).access_collection.contains(value)) 
					{
					lista.get(to).access_collection.add(value);
					lista.get(from).access_collection.remove(value);
					}
			}
		};break;
		case EXECUTE:
		{
			if(lista.get(from).access_collection.contains(access_mode.EXECUTE_COPY))
			{
				//System.out.println(access_mode.EXECUTE_COPY);
				if(!lista.get(to).access_collection.contains(value))
					{
					lista.get(to).access_collection.add(value);
					lista.get(from).access_collection.remove(value);
					}
			}
		}
		default: break;
		}
	}
	
	public void delete_right(String name,access_mode value)
	{
		int n = -1;
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).get_name() == name)
			{
				n = i;
				break;
			}
		}
		if(n>=0) lista.get(n).remove_right(value);
	}
}
