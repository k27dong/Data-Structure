public class C5_18 {
    public static boolean is_palindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        else {
            if (s.charAt(0) != s.charAt(s.length() - 1)) {
                return false;
            }
            else {
                return is_palindrome(s.substring(1, s.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        String s = "gohangasalamiimalasagnahog";
        String p = "somerandom";
        System.out.println(is_palindrome(s));
        System.out.println(is_palindrome(p));
    }
}