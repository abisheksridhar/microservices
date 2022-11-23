package Revision;

import java.util.TreeMap;
import java.util.Set;
import java.util.Map;

public class TreeMapImple {
    public static void main(String[] args) {
        TreeMap<String, Double> tm = new TreeMap<>();
        tm.put("e", 1090.98);
        tm.put("d", 100.98);
        tm.put("f", 1300.98);
        tm.put("h", 10020.98);
        tm.put("r", 1020.98);
        System.out.println(tm.ceilingEntry("h"));
        System.out.println(tm.descendingKeySet());
        System.out.println(tm.descendingMap());
        tm.remove("f");
        Set<Map.Entry<String, Double>> set = tm.entrySet();
        for (Map.Entry<String, Double> entrySet : set) {
            System.out.println(entrySet.getKey());
        }
    }
}
