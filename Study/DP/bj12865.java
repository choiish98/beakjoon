import java.io.*;
import java.util.*;

public class bj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); 

		int[][] dp = new int[N+1][K+1];
		int[] weight = new int[N];
		int[] value = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
        
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(weight[i-1]<=j)
					dp[i][j] = Math.max(value[i-1]+dp[i-1][j-weight[i-1]], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
				max = Math.max(dp[i][j], max);
			}
		}
		System.out.println(max);
    }
}
