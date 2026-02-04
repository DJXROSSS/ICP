package Week4.CodeChef;

import java.io.*;
class Main {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // static Node reverseMSizeGroups(Node head, int M) {
    // Node ans = new Node(0);
    // Node ansPointer = ans;
    // int count = 1;
    // Node temp = new Node(head.data);
    // Node tempPointer = temp;
    // head = head.next;
    // while (head != null) {
    // if(count == M){
    // Node rev = reverse(temp);
    // ansPointer.next = rev;
    // while(ansPointer != null) ansPointer = ansPointer.next;
    // count = 1;
    // temp = new Node(head.data);
    // tempPointer = temp;
    // } else{
    // tempPointer.next = new Node(head.data);
    // tempPointer = tempPointer.next;
    // count++;
    // }
    // head = head.next;
    // }
    // return ans.next;
    // }

    // static Node reverse(Node head){
    // Node temp = head;
    // Node prev = null;
    // Node next = null;
    // while (temp != null) {
    // next = temp.next;
    // temp.next = prev;
    // prev = temp;
    // temp = next;
    // }
    // printList(prev);
    // return prev;
    // }

    static Node reverseMSizeGroups(Node head, int M) {

        Node ans = new Node(0);
        Node ansPointer = ans;

        while (head != null) {

            Node tempHead = null, tempTail = null;
            int count = 0;

            while (count < M && head != null) {
                Node next = head.next; 
                head.next = null; 

                if (tempHead == null) {
                    tempHead = head;
                    tempTail = head;
                } else {
                    tempTail.next = head;
                    tempTail = head;
                }

                head = next;
                count++;
            }

            Node rev = reverse(tempHead);

            ansPointer.next = rev;

            while (ansPointer.next != null) {
                ansPointer = ansPointer.next;
            }
        }

        return ans.next;
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int T = fs.nextInt();
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            int N = fs.nextInt();
            int M = fs.nextInt();

            Node head = null, tail = null;

            for (int i = 0; i < N; i++) {
                int x = fs.nextInt();
                Node node = new Node(x);
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }

            head = reverseMSizeGroups(head, M);

            Node cur = head;
            while (cur != null) {
                out.append(cur.data);
                if (cur.next != null)
                    out.append(" ");
                cur = cur.next;
            }
            out.append('\n');
        }

        System.out.print(out.toString());
    }

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ')
                ;
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
