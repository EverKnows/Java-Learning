package com.zzxx.Test;

class Test extends Person{
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }

    public Test() {
        super();
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        Test  test = new Test();
    }
}

class Person{
    static{
        System.out.println("person static");
    }
    public Person() {
        this("deaflut");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}


class MyClass extends Test {
    Person person = new Person("MyClass");
    static{
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}