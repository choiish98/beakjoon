package Class1;
import java.util.*;
public class bj1546 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		double b[] = new double[a]; double max = 0, sum = 0;
		
		for(int i = 0; i < a; i ++) {
			b[i] = s.nextInt();
			if(max < b[i]) max = b[i];
		}
		
		for(int i = 0; i < a; i ++) {
			if(b[i] <= max) b[i] =  b[i] / max * 100;
			sum += b[i];
		}
		
		System.out.println(sum / a);

	}
}
