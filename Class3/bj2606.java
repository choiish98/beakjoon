import java.io.*;
import java.util.*;

public class bj2606 {

    static int node[][];
    static int check[];

    static void bfs(int start) {
        Queue<Integer> queue = new Queue<>();

        check[start] = 1;
        queue.offer(start);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i < node.length; i++) {
                if (node[x][i] == 1 && check[i] != 1) {
                    queue.offer(i);
                    check[i] = 1;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n_t = Integer.parseInt(br.readLine());

        node = new int[t + 1][t + 1];
        check = new int[t + 1];

        for (int i = 0; i < n_t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
        }

        bfs(1);

    }

}