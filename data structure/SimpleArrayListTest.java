public class SimpleArrayListTest {
    public static void main(String[] args) {
        SimpleArrayList list = new SimpleArrayList();
        System.out.println(list);
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        System.out.println(list);
    }
}

class SimpleArrayList {
    int[] elements;
    int size;

    public SimpleArrayList() {
        this.elements = new int[10];
        this.size = 0;
    }

    public void add(int data) {
        this.elements[this.size] = data;
        this.size++;
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer("list = ");
        for (int i = 0; i < size; i++) {
            sbuf.append(elements[i] + " ");
        }
        return sbuf.toString();
    }
}