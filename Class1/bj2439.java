package Class1;
import java.util.*;
public class bj2439 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		for(int i = 1; i < a+1; i++) {
			for(int j = a; j > i; j--) {
				System.out.print(" ");
			}
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}
}
