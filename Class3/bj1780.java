import java.io.*;
import java.util.*;

public class bj1780 {
  static int first = 0;
  static int second = 0;
  static int third = 0;
  static int[][] paper;

  static boolean check(int n, int x, int y) {
    int color = paper[x][y];

    for(int i = x; i < x + n; i++) {
      for(int j = y; j < y + n; j++) {
        if(color != paper[i][j]) return false;
      }
    }

    return true;
  }

  static void partition(int n, int x, int y) {
    if(check(n, x, y)) {
      if(paper[x][y] == -1) first++;
      else if(paper[x][y] == 0) second++;
      else third++;

      return;
    }

    int dSize = n / 3;
    partition(dSize, x, y);
    partition(dSize, x + dSize, y);
    partition(dSize, x + 2 * dSize, y);

    partition(dSize, x, y + dSize);
    partition(dSize, x, y + 2 * dSize);
    partition(dSize, x + dSize, y + dSize);
    
    partition(dSize, x + 2 * dSize, y + dSize);
    partition(dSize, x + dSize, y + 2 * dSize);
    partition(dSize, x + 2 * dSize, y + 2 * dSize);

    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    partition(N, 0, 0);
    System.out.println(first);
    System.out.println(second);
    System.out.println(third);
  }
}