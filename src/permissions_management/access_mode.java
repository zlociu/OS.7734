


public enum access_mode {
	
NO_RIGHTS(0), READ(1), READ_COPY(6), WRITE(10), WRITE_COPY(15), EXECUTE(20), EXECUTE_COPY(25), PRINT(30),
PRINT_COPY(35), SWITCH(50), CONTROL(55), OWNER(100);
	
	int value;
	access_mode(int n)
	{
		this.value = n;
	}
}
