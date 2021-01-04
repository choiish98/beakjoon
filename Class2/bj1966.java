import java.util.*;
public class bj1966 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int test_case = s.nextInt();
		
		for(int i = 0; i < test_case ; i++) {
			int n = s.nextInt();
			
			int[] queue = new int[n];
			int[] imp = new int[n];
			
			int m = s.nextInt();
			for(int j = 0; j < n; j++) {
				queue[j] = j+1;
				imp[j] = s.nextInt();
			}
			s.close();
			
			sortQueue(queue, imp, m);// 큐를 순서대로 배열 하는 함수
			
			System.out.println(queue[m]);
		}
	}

	private static void sortQueue(int[] queue, int[] imp, int m) {
		for(int i = 0; i < imp.length; i++) {
			for(int j = 0; j < m; j++) {
				if(imp[i] <= imp[j]) { 		// 중요도가 큰 문서를 발견했을 경우, 맨 뒤로 보내기
					int a = imp[i];
					int b = queue[i];
					resort(imp, queue, i); 	// 맨 뒷자리 비우고 앞으로 다 댕기기
					imp[imp.length-1] = a;
					queue[queue.length-1] = b;
					i = 0; j = 0;
				}
			}
		}
		
	}

	private static void resort(int[] imp, int[] queue, int p) {
		for(int i = p; i < imp.length-1; i++) {
			change(imp, i);		// 앞뒤 자리 바꾸기
			change(queue, i);
		}
	}

	private static void change(int[] arr, int i) {
		int a = arr[i];
		arr[i] = arr[i+1];
		arr[i+1] = a;
	}
}
