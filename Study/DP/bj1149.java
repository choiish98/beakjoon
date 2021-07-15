import java.util.*;
import java.io.*;

public class bj1149 {
    static int[][] cost;
    static int[][] lowCost;

    static int dp(int index, int color) {
        if (index == 0) {
            return cost[index][color];
        } else if (lowCost[index][color] != 0) {
            return lowCost[index][color];
        } else {
            if (color == 0)
                lowCost[index][0] = Math.min(dp(index - 1, 1), dp(index - 1, 2)) + cost[index][0];
            if (color == 1)
                lowCost[index][1] = Math.min(dp(index - 1, 0), dp(index - 1, 2)) + cost[index][1];
            if (color == 2)
                lowCost[index][2] = Math.min(dp(index - 1, 0), dp(index - 1, 1)) + cost[index][2];
            return lowCost[index][color];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        lowCost = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.min(dp(N - 1, 0), Math.min(dp(N - 1, 1), dp(N - 1, 2))));
    }
}