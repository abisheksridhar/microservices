package Revision;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapImpl {
    public static void main(String[] args) {
        HashMap<Integer, Double> hm = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            hm.put(i, Math.rint(i * 17));
        }
        HashMap<Integer, Double> hm2 = new HashMap<>(hm);
        Set<Map.Entry<Integer, Double>> set = hm.entrySet();

        for (Map.Entry<Integer, Double> e : set) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        System.out.println(hm.size());
        System.out.println(hm2.keySet());
        System.out.println(hm2.values());
        hm.clear();
        System.out.println(hm);
    }
}
