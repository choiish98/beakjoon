package Class2;
import java.util.*;
public class bj1085 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int y = s.nextInt();
		int w = s.nextInt();
		int h = s.nextInt(); s.close();
		
		System.out.println(Math.min(Math.min(x, (w-x)), Math.min(y, h-y)));
	}
}
