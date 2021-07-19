import java.util.*;
import java.io.*;

public class bj1584 {
    static int[][] warning;
    static int[][] death;

    static int dfs() {
        return 0;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        warning = new int[N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < warning.length; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                warning[j] = Integer.parseInt(st.nextToken());
            }
        }
        int M = Integer.parseInt(br.readLine());
        death = new int[M][4];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < warning.length; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                death[j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs());
    }
}
