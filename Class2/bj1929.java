package Class2;
import java.util.*;

public class bj1929 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt(), b = s.nextInt(); s.close();
		
		boolean[] primeNum = new boolean[b+1];
		primeNum[1] = true;
		
		for(int i = 2; i < b+1; i ++) {			
			for(int j = 2; i*j < b+1; j++) {
				primeNum[i*j] = true;
			}
		}
		
		for(int i = a; i < b; i++)
			if(!primeNum[i]) System.out.println(i);
	}
}
