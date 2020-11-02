package Class1;
import java.util.*;
public class bj2884 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
		int m = s.nextInt();
		
		if(m - 45 < 0) {
			h--;
			if(h < 0) h = 23;
			m = 60 + (m - 45);
			System.out.println(h + " " + m);
		}
		
		else System.out.println(h + " " + (m - 45));
	}
}
