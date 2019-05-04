package com.zzxx;

import java.util.Arrays;

public class Demo2 {
    private Object[] arr = new Object[10];
    private int index = 0;
    public int size = 10;

    public void add(Object obj) {
        if (index == size) {
            arr = Arrays.copyOf(arr, size + 10);
            size = size + 10;
        }
        arr[index++] = obj;
    }

    public void insert(int index, Object obj) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("非法下标");
        }
        if (this.index == size) {
            arr = Arrays.copyOf(arr, size + 10);
            size = size + 10;
        }
        for (int i = this.index; i > index; i++) {
            arr[i] = arr[i - 1];
        }
        this.index++;
        arr[index] = obj;
    }

    public int size() {
        return this.index;
    }

    public Object get(int index) {
        if (index >= this.index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("非法下标");
        }
        return arr[index];
    }

    public Object set(int index, Object obj) {
        if (index >= this.index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("非法下标");
        }
        Object temp = arr[index];
        arr[index] = obj;
        return temp;
    }

    public Object remove(int index) {
        if (index >= this.index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("非法下标");
        }
        Object temp = arr[index];
        for (int i = index; i < this.index; i++) {
            arr[i] = arr[i + 1];
        }
        this.index--;
        return temp;
    }

    @Override
    public String toString() {
        Object obj[] = new Object[this.index];
        int countNew = 0;
        int countOld = 0;
        while (countOld < this.index) {
            if (this.arr[countOld] != null) {
                obj[countNew++] = this.arr[countOld++];
            } else {
                countOld++;
            }
        }
        obj = Arrays.copyOf(obj, countNew);
        return Arrays.toString(obj);
    }

    public boolean isEmpty() {
        return this.index == 0;
    }

    public void remove(Object obj) {
        for (int i = 0; i < this.index; i++) {
            if (arr[this.index].equals(obj)) {
                remove(i);
                break;
            }
        }
    }
    public boolean contain(Object obj) {
        for (int i = 0; i < this.index; i++) {
            if (arr[this.index].equals(obj)) {
                return true;
            }
        }
        return false;
    }
}
