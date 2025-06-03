package Pack;

public class Demo {

	public Demo a()
	{
		System.out.println("Execute method a");
		return new Demo();
	}
	
	public Demo b()
	{
		System.out.println("Execute method b");
		return new Demo();
	}
	
	public Demo2 c()
	{
		System.out.println("Execute method c");
		return new Demo2();
	}
}
