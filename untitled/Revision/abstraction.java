package Revision;


public class abstraction extends a {
    void fun1() {
        System.out.println("inside fun1");
    }

    void fun2() {
        System.out.println("inside fun2");
    }
    public static void main(String[] args) {
        abstraction A = new abstraction();
        A.fun1();
        A.fun2();
    }
}
