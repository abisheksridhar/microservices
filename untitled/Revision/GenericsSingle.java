package Revision;


public class GenericsSingle {
    public static void main(String[] args) {
        Gen<Integer> genInt = new Gen(100);
        Gen<Double> genDbl = new Gen(199.9);
        Gen<String> genStr = new Gen("hello");
        System.out.println(genInt.getGen());
        System.out.println(genDbl.getGen());
        System.out.println(genStr.getGen());

    }
}
