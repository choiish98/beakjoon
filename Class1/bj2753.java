package Class1;
import java.util.*;
public class bj2753 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int y = s.nextInt(); s.close();
		
		if(y % 4 == 0 && y % 100 != 0) System.out.println("1");
		else if(y % 400 == 0) System.out.println("1");
		else System.out.println("0");
	}
}
