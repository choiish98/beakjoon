import java.io.*;

public class bj2579 {
    static int arr[];
    static Integer dp[];

    static int findMax(int t) {
        if (dp[t] == null) {
            dp[t] = Math.max(findMax(t - 2), findMax(t - 3) + arr[t - 1]) + arr[t];
        }
        return dp[t];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        arr = new int[t + 1];
        dp = new Integer[t + 1];

        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (t >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(findMax(t));
    }
}