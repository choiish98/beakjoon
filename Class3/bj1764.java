import java.io.*;
import java.util.*;

public class bj1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> hs = new HashSet<String>();
        ArrayList<String> al = new ArrayList<String>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (hs.contains(s))
                al.add(s);
        }

        // al.sort();
        System.out.println(al.size());
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }
}