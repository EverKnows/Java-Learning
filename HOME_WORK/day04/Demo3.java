package com.zzxx;

import java.util.Iterator;

public class Demo3 implements Iterable<Object>{
    private Node head = new Node();
    private int size = 0;
    private int modCount = 0;
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
        modCount++;
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
        modCount++;
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
        modCount++;
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
        modCount++;
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
        modCount++;
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
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            int cursor = 1;
            int expectedModeCount = modCount;
            @Override
            public boolean hasNext() {
                try {
                    if (expectedModeCount != modCount) {
                        throw new Exception("线程不安全！");
                    }
                    return cursor <= size();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return cursor <= size();
            }

            @Override
            public Object next() {
                try {
                    if (expectedModeCount != modCount) {
                        throw new Exception("线程不安全！");
                    }
                    if (hasNext()) {
                        Object obj = get(cursor);
                        cursor++;
                        return obj;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }
}
