package Class1;
import java.util.*;
public class bj10809 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next(); s.close();
		int[] alpha = new int[26]; Arrays.fill(alpha, -1);
		
		for(int i = 0; i < str.length(); i ++){
			for(int j = 0; j < alpha.length; j ++) {
				if(alpha[j] == -1)
					if(str.charAt(i) == 97 + j) 
						alpha[j] = i;
			}
		}
		
		for(int i = 0; i < alpha.length; i ++)
			System.out.print(alpha[i] + " ");
	}
}
