package Class2;
import java.util.*;
public class bj1181 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = Integer.parseInt(sc.nextLine());
		
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < N ; i++)
			set.add(sc.nextLine());
		
		ArrayList<String> list = new ArrayList<String>(set);
		
		Collections.sort(list, new Comparator<String>() {

			public int compare(String o1, String o2) {
            
				if(o1.length() > o2.length())
					return 1;
				else if(o1.length() < o2.length())
					return -1;
				else
					return o1.compareTo(o2);
			}
		});
		
		for(String s : list)
			System.out.println(s);
	}
}
