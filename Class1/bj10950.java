package Class1;
import java.util.*;
public class bj10950 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt(); 
		int[] a = new int[t];
		int[] b = new int[t];
		
		for(int i = 0; i < t; i++) {
			a[i] = s.nextInt();
			b[i] = s.nextInt();
		}		
		
		for(int i = 0; i < t; i++) {
			System.out.println(a[i] + b[i]);
		}
	}
}
