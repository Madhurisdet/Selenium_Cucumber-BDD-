package ServletPackage;

public class SingaltonDemo {
	
	private  String str="Hello...Welcome to java";
	//1st step
	private static SingaltonDemo sobj =null;
	//2nd step
	private  SingaltonDemo() {}
	
	
	//3rd step
	public static SingaltonDemo getObject() 
	{
		if(null==sobj)
		{
			sobj=new SingaltonDemo();
		}
		return sobj;
	}
	
	public String getData()
	{
		return str;
	}
}
