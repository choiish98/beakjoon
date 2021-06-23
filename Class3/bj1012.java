import java.io.*;
import java.util.*;

public class Main {
  static int N, M, K;
  static int count;
  static int arr[][];
  static boolean check[][];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

  static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<int[]>();
    queue.add(new int[] {x, y});

    while(!queue.isEmpty()) {
      x = queue.peek()[0];
      y = queue.peek()[1];
      check[x][y] = true;
      queue.poll();

      for(int i = 0; i < 4; i++) {
        int cx = x + dx[i];
        int cy = y + dy[i];

        if(cx >= 0 && cy >= 0 && cx < N && cy < M) {
          if(arr[cx][cy] == 1 && !check[cx][cy]) {
            queue.add(new int[] {cx, cy});
            check[cx][cy] = true;
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int c = 0; c < T; c++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      count = 0;
      arr = new int[N][M];
      check = new boolean[N][M];

      for(int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr[a][b] = 1;
      }

      for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
          if(arr[i][j] == 1 && !check[i][j]) {
            bfs(i, j);
            count++;
          }
        }
      }

      System.out.println(count);
    }
  }
}