package Class1;
import java.util.*;
public class bj10871 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x = s.nextInt(); s.close();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			if(arr[i] < x) System.out.print(arr[i] + " ");
		}			
	}
}
