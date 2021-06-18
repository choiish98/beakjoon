package com.example.bst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    final ArrayList<Integer> node_arr = new ArrayList<>();

    class Queue<T> {
        class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }

        private Node<T> first;
        private Node<T> last;

        public void enqueue(T item) {
            Node<T> t = new Node<T>(item);

            if(last != null) {
                last.next = t;
            }
            last = t;
            if(first == null) {
                first = last;
            }
        }

        public T dequeue() {
            if (first == null) {
               throw new NoSuchElementException();
            }

            T data = first.data;
            first = first.next;

            if(first == null) {
                last = null;
            }
            return data;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }

    class Tree {
        class Node {
            Integer data;
            Node left;
            Node right;
            Node() {
            }
            Node (Integer data) {
                this.data = data;
            }
        }
        Node root;
        public void makeTree(int[] a) {
            root = makeTreeR(a, 0, a.length-1);
        }
        public Node makeTreeR(int[] a, int start, int end) {
            if (start > end) return null;
            int mid = (start + end) / 2;
            Node node = new Node(a[mid]);
            node.left = makeTreeR(a, start, mid - 1);
            node.right = makeTreeR(a, mid + 1, end);
            return node;
        }
        void bfs(ArrayList<Integer> arr) {
            Queue<Node> queue = new Queue<Node>();
            queue.enqueue(root);
            Node null_node = new Node(null);
            null_node.left = null;
            null_node.right = null;
            while (!queue.isEmpty()) {
                Node r = queue.dequeue();
                if(r.data == null) {
                    arr.add(null);
                    continue;
                }
                if(r.left != null) {
                    queue.enqueue(r.left);
                }
                if(r.left == null) {
                    queue.enqueue(null_node);
                }
                if(r.right != null) {
                    queue.enqueue(r.right);
                }
                if(r.right == null) {
                    queue.enqueue(null_node);
                }
                visit(r.data, arr);
            }
        }
        void visit (Integer n, ArrayList < Integer > arr){
            arr.add(n);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputNumber = (EditText)findViewById(R.id.inputNumber);
        final Button pushButton = (Button)findViewById(R.id.pushNumber);
        final Button deleteButton = (Button)findViewById(R.id.deleteNumber);
        inputNumber.setInputType(0);
        Integer[] Rid_button = {
            R.id.node0, R.id.node1, R.id.node2, R.id.node3, R.id.node4,
            R.id.node5, R.id.node6, R.id.node7, R.id.node8, R.id.node9,
            R.id.node10, R.id.node11, R.id.node12, R.id.node13, R.id.node14,
            R.id.node15, R.id.node16, R.id.node17, R.id.node18, R.id.node19
        };
        final Button node[] = new Button[20];
        for(int i = 0; i < 20; i++){
            node[i] = (Button)findViewById(Rid_button[i]);
        }

        pushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node_arr.add(Integer.parseInt(inputNumber.getText().toString()));
                Collections.sort(node_arr);
                // 입력을 arraylist에 추가

                int[] arr = new int[node_arr.size()];
                int size = 0;
                for (int temp : node_arr) {
                    arr[size++] = temp;
                }
                Arrays.sort(arr);
                // arraylist를 array로 변환

                Tree t = new Tree();
                t.makeTree(arr);
                // 배열을 트리로 만들기

                ArrayList<Integer> gui_arrlist = new ArrayList<Integer>();
                t.bfs(gui_arrlist);
                // 트리에 맞게 그래프에 넣기, 그래프를 arraylist로 저장

                for (int i = 0; i < gui_arrlist.size(); i++) {
                    if(gui_arrlist.get(i) == null)
                        continue;
                    node[i].setText(String.valueOf(gui_arrlist.get(i)));
                }
                // 배열을 GUI에 넣기
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < node_arr.size(); i++) {
                    if (node_arr.get(i).equals(Integer.parseInt(inputNumber.getText().toString()))) {
                        node_arr.remove(i);
                    }
                }
                Collections.sort(node_arr);
                // 입력 값과 같은 노드를 삭제

                int[] arr = new int[node_arr.size()];
                int size = 0;
                for (int temp : node_arr) {
                    arr[size++] = temp;
                }
                Arrays.sort(arr);
                // arraylist를 array로 변환

                Tree t = new Tree();
                t.makeTree(arr);
                // 배열을 트리로 만들기

                ArrayList<Integer> gui_arrlist = new ArrayList<Integer>();
                t.bfs(gui_arrlist);
                // 트리에 맞게 그래프에 넣기, 그래프를 arraylist로 저장

                for(int i = 0; i < node.length; i++) {
                    node[i].setText(" ");
                }
                // 모든 노드 초기화

                for (int i = 0; i < gui_arrlist.size(); i++) {
                    if(gui_arrlist.get(i) == null)
                        continue;
                    node[i].setText(String.valueOf(gui_arrlist.get(i)));
                }
                // 배열을 GUI에 넣기
            }
        });
    }
}