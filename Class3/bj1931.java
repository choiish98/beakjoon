import java.util.*;
import java.io.*;

public class bj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] start, int[] end) {
                if(start[1] == end[1])
                    return Integer.compare(start[0], end[0]);
                return Integer.compare(start[1], end[1]);
            }
        });

        int count = 0;
        int end = -1;
        for(int i = 0; i < N; i++) {
            if(arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
