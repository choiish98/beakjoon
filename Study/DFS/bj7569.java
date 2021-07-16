import java.io.*;
import java.util.*;

class Tomato {
    int x;
    int y;
    int z;

    Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class bj7569 {
    static int N;
    static int M;
    static int H;
    static Queue<Tomato> queue;
    static int[][][] board;
    static int dx[] = { -1, 0, 1, 0, 0, 0};
    static int dy[] = { 0, 1, 0, -1, 0, 0};
    static int dz[] = { 0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        
        board = new int[H][N][M];
        queue = new LinkedList<Tomato>();
        
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    board[i][j][k] = sc.nextInt();
                    if(board[i][j][k] == 1) queue.add(new Tomato(i, j, k));
                }
            }
        }
        
        System.out.println(bfs());
    }

    static int bfs() {
        while(!queue.isEmpty()) {
            Tomato temp = queue.remove();
    
            for(int i = 0; i < 6; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                int z = temp.z + dz[i];
                
                if(x >= 0 && y >= 0 && z >= 0 && x < N && y < M  && z < H) {
                    if(board[z][x][y] == 0) {
                        queue.add(new Tomato(z, x, y));
                        board[z][x][y] = board[temp.z][temp.x][temp.y] + 1;
                    } 
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
            
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < M; k++) {
                        if(board[i][j][k] == 0) return -1;
                        result = Math.max(result, board[i][j][k]);
                    }
                }
            }
    
            if(result == 1) return 0;
            else return result - 1;
    }
}
