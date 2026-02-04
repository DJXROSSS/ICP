package Week4.CodeChef;

import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int data;
        Node next, child;
        Node(int x) {
            data = x;
            next = null;
            child = null;
        }
    }

    static Node flatten(Node head) {
        return head;
    }

    static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.next != null) System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int T = fs.nextInt();

        while (T-- > 0) {
            int N = fs.nextInt();

            HashMap<Integer, Node> map = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                map.put(i, new Node(i));
            }

            HashSet<Integer> hasParent = new HashSet<>();

            for (int i = 0; i < N - 1; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                int type = fs.nextInt();

                Node U = map.get(u);
                Node V = map.get(v);

                if (type == 0) {
                    U.next = V;
                } else {
                    U.child = V;
                }
                hasParent.add(v);
            }

            Node head = null;
            for (int i = 1; i <= N; i++) {
                if (!hasParent.contains(i)) {
                    head = map.get(i);
                    break;
                }
            }
            head = flatten(head);
            printList(head);
        }
    }

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}

