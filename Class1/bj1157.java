package Class1;
import java.util.Scanner;
public class bj1157 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String word = s.next().toUpperCase();
		int alpha[] = new int[26];
		int max = 0; char e = ' '; 
		
		for(int i = 0; i < word.length(); i ++) {
			alpha[word.charAt(i) - 65]++;
		}
		
		for(int i = 0; i < alpha.length; i ++) {
			if(max < alpha[i]) {
				e = (char) (65+i);
				max = alpha[i];
			}
			else if(max == alpha[i]) 
				e = '?';
		}
		
		System.out.println(e);
	}
}
