package Class1;
import java.util.*;
public class bj10952 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for(int i = 0;; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			if(a==0 && b==0) break;
			System.out.println(a + b);
		}
	}
}
