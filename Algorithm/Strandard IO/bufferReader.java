/*  bufferReader 사용법
    패키지 import
    import java.io.*; 
    
    br.readLIne 단위로 한 줄씩 읽음
    
    StringTokenizer 
    공백을 다 앞댕겨서 배열 단위로 String을 받음
*/

import java.io.*;
import java.util.*;

public class BufferedReader {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            String number = Integer.toString(i + 1);
            map.put(a, number);
            map.put(number, a);
        }

        for (int i = 0; i < M; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}
