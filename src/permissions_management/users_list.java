
import java.util.ArrayList;

public class users_list {
	public user_account curr_user;
	public ArrayList<user_account> users = new ArrayList<user_account>(); 
	private int count_admin = 0;
	
	users_list()
	{
		curr_user = new user_account("admin",true);
		users.add(curr_user);
		count_admin++;
	}
	
	public int find_user(String name)
	{
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).get_name()==name) return i;
		}
		return -1;
	}
	
	public void add_user(String name,boolean admin)
	{
		if(curr_user.is_admin())
		{
			if(find_user(name)==-1 && admin==false) 
			{
			users.add(new user_account(name));
			}
			if(find_user(name)==-1 && admin==true) 
			{
				users.add(new user_account(name,true));
				count_admin++;
			}
			System.out.println("utworzno konto: "+ name);
		}
		else System.out.println("Nie mo¿na utworzyc konta - brak uprawnien administratora");
	}
	
	public void delete_user(String name)
	{
		if(curr_user.is_admin())
		{
		int i = find_user(name);
		if(i!=-1)
			{
				if(users.get(i).is_admin()) 
					{
					if(count_admin != 1)
						{
						users.remove(i);
						count_admin--;
						}
					}
				System.out.println("Usunieto konto");
			}
		}
		else System.out.println("Nie mo¿na usunac konta - brak uprawnien administratora");
	}
	
	public void set_admin_mode(String name)
	{
		if(curr_user.is_admin())
		{
			int i = find_user(name);
			users.get(i).set_type(0);
		}
	}
	
	public void set_normal_mode(String name) //zdjecie admina 
	{
		if(curr_user.is_admin())
		{
			int i = find_user(name);
			users.get(i).set_type(1);
		}
	}
	
	public void login(String name)
	{
		if(curr_user==null)
		{
		int i = find_user(name);
		if(i!=-1)
			{
			curr_user = users.get(i);
			System.out.println("Zalogowano! Witamy " + name);
			}
		}
		else System.out.println("Uzykownik jest juz zalogowany");
		
	}
	
	//po wylogowaniu trzeba sie zalogowac, inaczej nikt nie moze nic zrobic
	public void logout() 
	{
		curr_user = null;
		System.out.println("Wylogowano");
	}
	
	public void show_curr_user()
	{
		System.out.println("Zalogowano jako: " + curr_user.get_name() + " " + ((curr_user.is_admin()) ? "(administrator)" : "" ));
	}
	
}
