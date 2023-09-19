package ServletPackage;

public class SingaltonMainClass {

	public static void main(String[] args) {
		
		SingaltonDemo obj1= SingaltonDemo.getObject();
		System.out.println(obj1.getData());

	}

}
