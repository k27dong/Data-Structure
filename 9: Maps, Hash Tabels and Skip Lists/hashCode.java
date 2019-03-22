public class hashCode {

    public static int hash_code(String s) {
        int h = 0;

        for (int i = 0; i < s.length(); i++) {
            h = (h << 5) | (h >> 27);
            h += (int) s.charAt(i);
        }

        return h;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(hash_code(s));
    }
}