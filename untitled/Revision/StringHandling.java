package Revision;

public class StringHandling {

    public static void main(String[] args) {

        String first = "Java ";
        System.out.println("First String: " + first);
        StringBuffer buff = new StringBuffer(first);
        buff.append("hello");
        buff.append(false);
        System.out.println((char) buff.codePointBefore(2));
        System.out.println(buff);
        // create second
        String second = "Programming";
        System.out.println("Second String: " + second);

        // join two strings
        String joinedString = first.concat(second);
        System.out.println("Joined String: " + joinedString);

        String third = "python programming";
        String fourth = "java programming";

        // compare first and second strings
        boolean result1 = first.equals(second);
        System.out.println("Strings first and second are equal: " + result1);

        // compare first and third strings
        boolean result2 = third.equals(fourth);
        System.out.println("Strings first and third are equal: " + result2);
    }

}
