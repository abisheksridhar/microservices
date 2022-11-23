package Revision;

import java.util.ArrayList;
import java.util.function.Predicate;

public class listInterface {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("bcd");
        list.add("def");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.addAll(0, list);
        System.out.println(list2);
        list2.remove("abc");
        System.out.println(list2);
        list2.add(0, list.get(0));
        System.out.println(list2);
        System.out.println(list.contains("lkk"));
        list.set(2, "lkk");
        System.out.println(list);
        System.out.println(list.contains("lkk"));
        // Object list3 = new Object();
        // list3 = list2.clone();
        ArrayList<String> list3 = new ArrayList<>();
        list3 = (ArrayList) list2.clone();
        System.out.println(list3.getClass());
        System.out.println(list3);
        System.out.println(list.indexOf("abc"));
        Predicate<String> pr = str -> str.equalsIgnoreCase("abc");
        list3.removeIf(pr);
        System.out.println(list3);
    }

}
