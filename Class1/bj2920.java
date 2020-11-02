package Class1;
import java.util.*;
public class bj2920 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int note[] = new int[8]; int a = 0;
		
		for(int i = 0; i < note.length; i++)
			note[i] = s.nextInt();
		
		for(int i = 0; i < note.length-1; i++) {
			if(note[i] < note[i+1]) a++;
			else if(note[i] > note[i+1]) a--;
			else a=0;
		}
		
		if(a == 7) System.out.println("ascending");
		else if(a == -7) System.out.println("descending");
		else System.out.println("mixed");
	}
}
