package com.zzxx;

public class Demo3 {
    private Node head = new Node();
    private int size = 0;
    public class Node {
        public Node next;
        public Object data;
        public Node(Object obj) {
            this.next = null;
            this.data = obj;
        }
        public Node() {

        }
    }

    public void add(Object obj) {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(obj);
        size++;
    }

    public void insert(int index, Object obj) {
        Node p = head;
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("非法下标");
        }
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node newNode = new Node(obj);
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    public void remove(Object obj) {
        Node p = head;
        Node q = p;
        while (p.next != null) {
            q = p;
            p = p.next;
            if(p.data.equals(obj)) {
                q.next = p.next;
                return;
            }
        }
        size--;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("非法下标");
        }

        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        size--;
    }

    public int size() {
        return this.size;
    }

    public void set(int index, Object obj) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("非法下标");
        }

        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next.data = obj;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contain(Object obj) {
        Node p = head;
        while(p.next != null) {
            p = p.next;
            if (p.data.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public Object get(int index) {
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.next.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        while(p.next != null) {
            p = p.next;
            sb.append(p.data);
            if (p.next != null) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
