import java.io.*;

public class bj9461 {
    static Long dp[];

    static Long p(int n) {
        if (dp[n] == null) {
            dp[n] = p(n - 2) + p(n - 3);
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp = new Long[101];

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        for (int i = 0; i < t; i++) {
            System.out.println(p(Integer.parseInt(br.readLine())));
        }
    }
}