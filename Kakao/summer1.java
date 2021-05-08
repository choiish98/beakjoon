public class summer1 {

}

class Solution {
    static String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    static StringBuilder checksb = new StringBuilder("");

    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character >= 97 && character <= 122) {
                checksb.append(character);
                check(sb);
            } else {
                sb.append(character);
            }
        }

        answer = Integer.parseInt(sb.toString());

        return answer;
    }

    static void check(StringBuilder sb) {
        for (int i = 0; i < number.length; i++) {
            if (checksb.toString().equals(number[i])) {
                sb.append(i);
                checksb.setLength(0);
            }
        }
    }
}