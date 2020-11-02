package Class1;
import java.util.*;
public class bj8958 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i = 0; i < t; i ++) { 
			int sum = 0; int score = 0;
			String c = s.next();
			
			String arr[] = new String[c.length()];
			arr = c.split("X");
			
			for(int j = 0; j < arr.length; j++) {
				score = 0;
				for(int k = 0; k < arr[j].length(); k++) {
					score += 1;
					sum += score;
				}
			}
			
			System.out.println(sum);
		}		
	}
}
