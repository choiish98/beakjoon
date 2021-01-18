import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.printf("list = %s\n", list.toString());
        list.add(4);
        list.add(8);
        list.add(12);
        System.out.printf("list = %s\n", list.toString());
        list.add(1, 10);
        list.add(1, 100);
        System.out.printf("list = %s\n", list.toString());
        list.remove(2);
        list.remove(3);
        System.out.printf("list = %s\n", list.toString());
        System.out.printf("size: %d\n", list.size());
    }
}