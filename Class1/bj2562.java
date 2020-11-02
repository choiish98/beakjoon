package Class1;
import java.util.*;
public class bj2562 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a[] = new int[9]; int max = 0, k = 0;
		
		for(int i = 0; i < 9; i ++) {
			a[i] = s.nextInt();
			if(a[i] > max) {
				k = i;
				max = a[i];
			}
		}
		
		System.out.println(a[k] + "\n" + (k+1));
	}
}
