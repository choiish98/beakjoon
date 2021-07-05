import java.io.*;
import java.util.*;

public class bj1780 {
  static int[] cnt = new int[3];
  static int[][] paper;

  static void divide(int n, int x, int y) {
    for (int i = y; i < y + n; i++) {
      for (int j = x; j < x + n; j++) {
        if (paper[i][j] != paper[y][x]) {
          divide(n / 3, y, x);
          divide(n / 3, y + n / 3, x);
          divide(n / 3, y, x + n / 3);
          divide(n / 3, y + n / 3, x + n / 3);

          return;
        }
      }
    }

    cnt[paper[y][x]]++;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new Inp
    tStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    divide(N, 0, 0);
    for(int n : cnt) System.out.println(n);
  }
}