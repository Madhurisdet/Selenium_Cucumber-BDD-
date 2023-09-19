

import java.util.LinkedList;
import java.util.ListIterator;


public class LinkedListIteratorDemo {

	public static void main(String[] args) {
		
	LinkedList<String> list	=new LinkedList<String>();
	 //adding elements in a list

		list.add("Maddy");
		list.add("Kiran");
		list.add("Aparna");
		list.add("Ajay");
		list.add("Daya");
		
	System.out.println("LinkedList:" +list);
	//setting the ListIterator
	ListIterator LI=list.listIterator(1);
	while(LI.hasNext()==true) {
	System.out.println(LI.next() );
	}
	} 

}
