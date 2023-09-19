
public class RemoveJunk {

	public static void main(String[] args) {
		
	String s1="Madhuri@#$Bhivaji1234%@$#@@@Waghmode%$#@";
	String s3=s1.replaceAll("[^a-zA-Z]", " " );
	System.out.println(s3);
	System.out.println("hello");
	}

}
