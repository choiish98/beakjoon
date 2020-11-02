package Class1;
import java.util.*;
public class bj2530 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a = s.nextLine().trim();
		s.close();
		
		if(a.isEmpty()) System.out.println(0);
		else System.out.println(a.split(" ").length);
	}
}
