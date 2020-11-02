package Class1;
import java.util.*;
public class bj2675 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt(); int r;
		
		for(int i = 0; i < t; i ++) {
			r = s.nextInt();
			String str = s.next();
			char[] qwe = new char[str.length()];
			for(int j = 0; j < str.length(); j++) {
				qwe[j] = str.charAt(j);
				for(int k = 0; k < r; k++)
					System.out.print(qwe[j]);
			}
			System.out.println();
		}
		
	}
}
