package Revision;

public class StaticExample {
    static {
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        System.out.println("Main Block");
        ab.printIt();// No object is used to refer the member function
    }
}