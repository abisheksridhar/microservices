package Revision;

import java.util.HashSet;
import java.util.function.Predicate;

public class setExamples {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(100);
        hs.add(200);
        hs.add(201);
        System.out.println(hs.add(200));
        System.out.println(hs);
        System.out.println(hs.contains(200));
        System.out.println(hs.isEmpty());
        hs.remove(200);
        System.out.println(hs.size());
        HashSet<Integer> hSet = new HashSet<>();
        hSet.addAll(hs);
        hs.clear();
        System.out.println(hs);
        hSet.add(300);
        Predicate<Integer> pr = a -> a > 200;
        hSet.removeIf((pr));
        System.out.println(hSet);
        HashSet<Integer> hs2 = new HashSet<>(hSet);
        System.out.println(hs2);
    }
}
