import java.util.*;
public class bj1018 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);		
		int m = s.nextInt();
		int n = s.nextInt();
		char[][] board = new char[m][n];
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < m; i++)
				board[i] = s.next().toCharArray();
		s.close();
		
		for(int i = 0; i < m-7; i++) {
			for(int j = 0; j < n-7; j++) {
				int cnt1 = 0; int cnt2 = 0;
					for(int l = 0; l < 8; l++) {
					if(l%2 == 0) {
						for(int k = 0; k < 8; k++) {
							if(k%2 == 0)
								if(board[l][k] != 'W') cnt1++;
							if(k%2 == 1)
								if(board[l][k] != 'B') cnt1++;
						}
					}
					if(l%2 == 1) {
						for(int k = 0; k < 8; k++) {
							if(k%2 == 0)
								if(board[l][k] != 'B') cnt1++;
							if(k%2 == 1)
								if(board[l][k] != 'W') cnt1++;
						}
					}
				}
				
				for(int l = 0; l < 8; l++) {
					if(l%2 == 0) {
						for(int k = 0; k < 8; k++) {
							if(k%2 == 0)
								if(board[l][k] != 'W') cnt2++;
							if(k%2 == 1)
								if(board[l][k] != 'B') cnt2++;
						}
					}
					if(l%2 == 1) {
						for(int k = 0; k < 8; k++) {
							if(k%2 == 0)
								if(board[l][k] != 'B') cnt2++;
							if(k%2 == 1)
								if(board[l][k] != 'W') cnt2++;
						}
					}
				}
				
				min = Math.min(min, Math.min(cnt1, cnt2));
			}
		}		
		System.out.println(min);
	}
}
