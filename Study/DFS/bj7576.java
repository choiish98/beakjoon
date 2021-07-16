import java.io.*;
import java.util.*;

class Tomato {
    int x;
    int y;

    Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class bj7576 {
    static int N;
    static int M;
    static Queue<Tomato> queue;
    static int[][] board;
    static int dx[] = { 1, 0, -1, 0};
    static int dy[] = { 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        queue = new LinkedList<Tomato>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) queue.add(new Tomato(i, j));
            }
        }
        
        System.out.println(bfs());
    }

    static int bfs() {
        while(!queue.isEmpty()) {
            Tomato temp = queue.remove();
    
            for(int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                
                if(x >= 0 && y >= 0 && x < N && y < M) {
                    if(board[x][y] == 0) {
                        queue.add(new Tomato(x, y));
                        board[x][y] = board[temp.x][temp.y] + 1;
                    } 
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(board[i][j] == 0) return -1;
                    result = Math.max(result, board[i][j]);
                }
            }
    
            if(result == 1)    return 0;
            else return result - 1;
    }
}
