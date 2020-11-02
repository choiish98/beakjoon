package Class1;
import java.util.*;
public class bj2577 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		s.close();
		
		String d = Integer.toString(a * b * c);
		int e[] = new int[d.length()];
		int f[] = new int[10];
		
		for(int i = 0; i < d.length(); i++)
			e[i] = Character.getNumericValue(d.charAt(i));;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < e.length; j++)
				if(i == e[j]) f[i]++;
		}

		for(int i = 0; i < f.length; i++)
			System.out.println(f[i]);
	}
}
