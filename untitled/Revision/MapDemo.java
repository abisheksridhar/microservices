package Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Double> hm = new HashMap<>();
        hm.put("a", 100.1);
        hm.put("b", 140.1);
        hm.put("e", 150.1);
        hm.put("d", 120.1);
        hm.put("c", 110.1);
        System.out.println(hm);

        Set<Map.Entry<String, Double>> set = hm.entrySet();
        for (Map.Entry<String, Double> a : set) {
            System.out.println(a.getKey());
            System.out.println(a.getValue());
        }

        HashMap<String, Double> hm2 = new HashMap<>();
        hm2 = (HashMap) hm.clone();
        System.out.println(hm2);
        hm2.merge("a", 100.0, (a, b) -> a + b);
        System.out.println(hm.containsKey("a"));
        System.out.println(hm.containsValue(100.1));
        System.out.println(hm2.get("a"));
        System.out.println(hm2);
    }
}
