package Revision;


public class GenericsDouble {
    public static void main(String[] args) {
        GenDouble<String,String> genDouble1 = new GenDouble<>("NewYork","california");
        genDouble1.show();
        GenDouble<Integer,Integer> genDouble2 = new GenDouble<>(100,200);
        genDouble2.show();
        GenDouble<String,Integer> genDouble3 = new GenDouble<>("Mexico",200);
        genDouble3.show();
    }
}
