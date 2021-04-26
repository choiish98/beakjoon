import java.io.*;
import java.util.*;

public class bj9375 {
    static String clothes[][];
    static int species[];

    static void how_much() {
        int result = 1;

        for (int i = 0; i < clothes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (clothes[i][1].equals(clothes[j][1])) {
                    species[j]++;
                    species[i]--;
                    break;
                }
            }
        }

        for (int i = 0; i < species.length; i++) {
            if (species[i] == 0)
                continue;
            result *= (species[i] + 1);
        }

        System.out.println(result - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int b = Integer.parseInt(br.readLine());
            clothes = new String[b][2];
            species = new int[b];
            for (int j = 0; j < b; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                clothes[j][0] = st.nextToken();
                clothes[j][1] = st.nextToken();
                species[j]++;
            }

            how_much();
        }
    }
}