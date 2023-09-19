//import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchInArray {

	public static void main(String[] args) {
		//approach 1:
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number that you want to search:");
		int key = sc.nextInt(); 
		int arr[]= {1,2,3,4,5,6,7,8,9,10};  //Array should be in Sorted order..if not we need to sort it first
		int l=0;
		int h=arr.length;
		boolean flag=false;  //we set to false...means elements is not present in array 
		while(l<h)
		{
			
			for(int i=0; i<arr.length; i++)
			{ 
				int mid=(l+h)/2;

				if(key==mid)
				{
					System.out.println("Found number..."+i);
					flag =true;
					break;
				}
				if(key>mid)
				{
					l=mid+1;
				}
				
				if(key<mid)
				{
					h=mid-1; 
				}
			}
			if(flag==false)
		   {
			System.out.println("element not found");
		   }}
		 
		//approach 2:
		//System.out.println(Arrays.binarySearch(arr, 7));
		
	}}


