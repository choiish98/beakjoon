import java.util.Scanner;
public class bj2231 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.close();
        int result = 0;

        for(int i = 0; i < num; i++) {
            int sum = i;
            int k = i;
            while(k > 0) {
                sum += k%10;
                k /= 10;
            }
            if(sum == num) {
                result = i;
                break;
            }
        }        

        System.out.println(result);
    }
}
