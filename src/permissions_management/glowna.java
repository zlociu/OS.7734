
public class glowna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process_list p1 = new process_list();
		users_list ulist1 = new users_list();
		ulist1.add_user("Marcin",false);
		ulist1.show_curr_user();
		ulist1.set_admin_mode("Marcin");
		ulist1.logout();
		ulist1.login("Marcin");
		ulist1.show_curr_user();
		
		//domain_table dt1 = new domain_table();
		p1.add(new process("file1"));
		p1.add(new process("file2"));
		p1.add(new process("file3"));
		p1.add(new process("printer"));
		int idx = p1.find_process_index("file1");
		if(idx>=0)
		{
			p1.proc_list.get(idx).add_domain(ulist1.users.get(ulist1.find_user("Marcin")));
			p1.proc_list.get(idx).add_domain(ulist1.users.get(ulist1.find_user("admin")));
			p1.proc_list.get(idx).add_right("admin", access_mode.OWNER);
			p1.proc_list.get(idx).add_right("admin", access_mode.WRITE);
			p1.proc_list.get(idx).add_right("admin", access_mode.READ);
			p1.proc_list.get(idx).add_right("Marcin", access_mode.WRITE);
			//p1.proc_list.get(idx).add_right("uzyt1", access_mode.READ);
			p1.proc_list.get(idx).copy_right("admin", "Marcin", access_mode.READ);
		}
		idx = p1.find_process_index("file2");
		if(idx>=0)
		{
			p1.proc_list.get(idx).add_domain(ulist1.users.get(ulist1.find_user("Marcin")));
			p1.proc_list.get(idx).add_domain(ulist1.users.get(ulist1.find_user("admin")));
			p1.proc_list.get(idx).add_right("admin", access_mode.OWNER);
			p1.proc_list.get(idx).add_right("admin", access_mode.WRITE_COPY);
			p1.proc_list.get(idx).add_right("admin", access_mode.READ_COPY);
			p1.proc_list.get(idx).copy_right("admin", "Marcin", access_mode.READ);
		}
		idx = p1.find_process_index("printer");
		if(idx>=0)
		{
			p1.proc_list.get(idx).add_domain(ulist1.users.get(ulist1.find_user("Marcin")));
			p1.proc_list.get(idx).add_domain(ulist1.users.get(ulist1.find_user("admin")));
			p1.proc_list.get(idx).add_right("admin", access_mode.PRINT);
			p1.proc_list.get(idx).add_right("Marcin", access_mode.PRINT);
		}
		p1.show_process_list();
		System.out.println("");
		idx = p1.find_process_index("file2");
		if(idx>=0)
		{
			
			p1.proc_list.get(idx).delete_right("admin", access_mode.READ_COPY);
			p1.proc_list.get(idx).copy_right("admin", "Marcin", access_mode.READ);
		}
		p1.show_process_list();
	}

}
