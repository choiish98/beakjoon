import java.io.*;
import java.util.*;

public class bj1676 {
    public static void main(String[] args) throws IOException {
        // 수행시간 체크
        long beforetime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        System.out.println(count);

        // 수행시간 체크
        long aftertime = System.currentTimeMillis();
        long secDifftime = (aftertime - beforetime) / 1000;
        System.out.println("수행시간(m): " + secDifftime);
    }
}