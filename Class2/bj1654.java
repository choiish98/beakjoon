import java.util.*;
public class bj1654 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		int n = s.nextInt();
		
		int arr[] = new int[k];
		for(int i = 0; i < k; i++) {
			arr[i] = s.nextInt();
		} s.close();
		
		Arrays.sort(arr); long left = 1; long right = arr[k-1];
		 
		while(left <= right) {
			long ans = 0;
			long middle = (left+right)/2;
					
			for(int i = 0; i < k; i++) {
				ans += arr[i] / middle;
			}
			if(ans < n)
				right = middle - 1;
			else if(ans >= n)
				left = middle + 1;
		}
		
		System.out.println(right);
	}
}
