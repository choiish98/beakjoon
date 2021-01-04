import java.io.*;
public class bj1436 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int i;

		for(i = 0; i < 10000; i++) {
			if(String.valueOf(i).contains("666"))
				count ++;
			if(count == n) break;
		}
		
		System.out.print(i);
	}
}
