package Class1;
import java.util.*;
public class bj10818 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); s.close();
		int max = -1000001; int min = 1000001; 
		for(int i = 0; i < n; i ++) {
			int a = s.nextInt();
			if(a > max) max = a;
			else if(a < min) min = a;
		}
		System.out.println(min + " " + max);
	}
}
