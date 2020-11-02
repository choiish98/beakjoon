package Class2;
import java.util.*;

public class bj1920 {
	public static void main(String[] args) {		
		Scanner s = new Scanner(System.in);
		
		int[] arr_n = new int[s.nextInt()];		// A[n] 배열 입력 받기
		for(int i = 0; i < arr_n.length; i++) 
			arr_n[i] = s.nextInt();
		Arrays.sort(arr_n);						// 이진 탐색을 위한 정렬
		
		int m = s.nextInt();	
		for(int i =0 ; i < m; i++) 
			System.out.println(new bj1920().solution(arr_n, s.nextInt()));
	}

	private int solution(int[] arr_n, int num) {
		int high = arr_n.length-1, low = 0, mid = 0;
		
		while(low <= high) {				// 이진 탐색
			mid = (high + low) / 2;
			
			if(arr_n[mid] == num) return 1;
			else if (arr_n[mid] > num) high = mid - 1;
			else low = mid + 1;
		}
		
		return 0;
	}
}
