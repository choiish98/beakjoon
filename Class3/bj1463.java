import java.io.*;
import java.util.*;

public class bj1463 {
    static int[] arr;

    static int dp(int x) {
        if (x == 1)
            return 0;
        else if (x == 2)
            return 1;
        else if (x == 3)
            return 1;
        else {
            if (arr[x] > 0)
                return arr[x];
            else {
                if (x % 12 == 0) {
                    int temp = Math.min(dp(x / 3), dp(x / 2));
                    arr[x] = Math.min(temp, dp(x - 1)) + 1;
                } else if (x % 3 == 0) {
                    arr[x] = Math.min(dp(x / 3), dp(x - 1)) + 1;
                } else if (x % 2 == 0) {
                    arr[x] = Math.min(dp(x - 1), dp(x / 2)) + 1;
                } else {
                    arr[x] = dp(x - 1) + 1;
                }
                return arr[x];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        arr = new int[x + 1];

        System.out.println(dp(x));
    }
}