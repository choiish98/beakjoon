import java.util.*;
public class bj1259 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for(;;) {
			int a = s.nextInt(); int b = 0;	int temp = a;
			s.close();
			if(a == 0) break;
			while(temp != 0) {
		            b = b * 10 + temp % 10;
		            temp /= 10;
		    }
			if(a == b)
				System.out.println("yes");
			else if(a != b)
				System.out.println("no");
		}
	}
}
