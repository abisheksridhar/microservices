package Revision;

public class GenDouble<o1,o2>{
    o1 a;
    o2 b;

    GenDouble(o1 a,o2 b){
        this.a= a;
        this.b = b;
    }

    o1 getA()
    {
        return a;
    }

    public o2 getB() {
        return b;
    }

    void show()
    {
        System.out.println("a is a "+a.getClass().getSimpleName());
        System.out.println("b is a "+b.getClass().getSimpleName());
    }
}