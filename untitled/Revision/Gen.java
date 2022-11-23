package Revision;

public class Gen<T> {
    T ob;

    Gen(T ob) {
        this.ob = ob;
    }

    T getGen() {
        return this.ob;
    }
}
