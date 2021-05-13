import java.io.*;
import java.util.*;

public class anUnfinishedRunner {
    public static void main(String[] args) throws IOException {
        String[] participant = { "asdf", "asdf" };
        String[] completion = { "asdf", "asdf" };

        Solution solution = new Solution(participant, completion);

        System.out.println(solution);
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        int a = 0;

        for (String pt : participant)
            map.put(pt, map.getOrDefault(pt, 0) + 1);
        for (String cp : completion)
            map.put(cp, map.get(cp) - 1);

        for (String key : map.keySet()) {
            if (map.get(key) != 0)
                answer = key;
        }
        return answer;
    }
}