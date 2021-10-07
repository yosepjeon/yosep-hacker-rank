package strings.mars_exploration;

public class Practice {
    public static void main(String[] args) {
        String s= "SOSSPSSQSSOR";

        int index = s.indexOf("SOS");
        System.out.println(index);
        System.out.println(s.substring(index + 3));

        System.out.println(s.substring(s.length()).length());
    }
}
