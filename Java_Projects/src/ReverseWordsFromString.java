public class ReverseWordsFromString {

	public static void main(String[] args) {
	String str="Welcome To Java world";
	String[] words =str.split(" ");
	String reverse_String= " ";
	
	for(String w : words)
	{
		String reverse_Words="";
		for(int i=w.length()-1; i>=0;i--)
		{
			reverse_Words=reverse_Words+w.charAt(i);
		}
		
		reverse_String=reverse_String +reverse_Words+ " ";
	}
		System.out.println(reverse_String);
	}
	 
	}

	
                      