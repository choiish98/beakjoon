package Class1;
import java.util.*;
public class bj3052 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n[] = new int[10]; 
		int m[] = new int[42];
		int a = 0;
		
		for(int i = 0; i < n.length; i++) {
			n[i] = s.nextInt();
			n[i] = n[i] % 42;
		}
		
		for(int i = 0; i < n.length; i ++) {
			for(int j = 0; j < m.length; j ++) {
				if(n[i] == j) m[j]=1;
			}
		}
		
		for(int i = 0; i < m.length; i ++) if(m[i] == 1) a++;
		
		System.out.println(a);
	}
}
