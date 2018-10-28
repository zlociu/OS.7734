package permissions_management;

public class permission_management
{
	
	public void testy()
	{
		users_list ulist = new users_list();
		process_list p1 =  new process_list();
		process f1 = new process("File1");
		process f2 = new process("File2");
		p1.add(f1);
		p1.add(f2);
		for(process e : p1.proc_list)
		{
			e.add_domain_own(ulist.curr_user);
			if(ulist.curr_user.is_admin())
			{
				e.add_right(ulist.curr_user.get_name(),access_mode.PRINT);
			}
		}
		p1.show_process_list();
	}
	
	
}
