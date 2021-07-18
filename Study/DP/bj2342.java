import java.util.*;
import java.io.*;

public class bj2342 {
    static ArrayList<Integer> arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        dp = new int[arr.size()][5][5];
        System.out.println(step(0, 0, 0));
    }

    static int step(int index, int left, int right) {
        if (index == arr.size()) {
            return 0;
        } else if (dp[index][left][right] != 0) {
            return dp[index][left][right];
        } else {
            int leftFoot = step(index + 1, arr.get(index), right) + cal(left, arr.get(index));
            int rightFoot = step(index + 1, left, arr.get(index)) + cal(right, arr.get(index));
            dp[index][left][right] = Math.min(leftFoot, rightFoot);
            return dp[index][left][right];
        }
    }

    static int cal(int foot, int temp) {
        int result = 0;
        if (foot == 0)
            result = 2;
        else if (foot == temp)
            result = 1;
        else if (Math.abs(foot - temp) == 2)
            result = 4;
        else
            result = 3;
        return result;
    }
}
