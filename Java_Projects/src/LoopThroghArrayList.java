import java.util.ArrayList;
import java.util.Collections;

public class LoopThroghArrayList {

	public static void main(String[] args) {
		
	ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		cars.add("Honda");
		/*for (int i = 0; i < cars.size(); i++)
		{
			System.out.println(cars.get(i));
		}*/
		
		//to sort an ArrayList
		Collections.sort(cars);
	    for(String c: cars)
		{
		System.out.println(c);
		}
 	}
}


