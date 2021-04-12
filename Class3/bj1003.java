import java.io.*;
import java.util.*;

public class bj1003 {

    static Integer[][] dp = new Integer[41][2];

    public static Integer[] fibo(Integer n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            dp[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < t; i++) {
            Integer[] arr = fibo(Integer.parseInt(br.readLine()));
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}