package Class1;
import java.util.*;
public class bj11720 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String a = s.next();
		int sum = 0;
		String arr[] = new String[a.length()];
		arr = a.split("");
		for(int i = 0; i < arr.length; i++) {			
			sum += Integer.parseInt(arr[i]);
		}		
		System.out.println(sum);
	}
}
