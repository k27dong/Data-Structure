public class string_repeat {
    public static String repeat_1(int n, char c) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer +=  c;
        }
        return answer;
        /**
         * String is immutable.
         * Each time a char is added, a new String is created and reassigned to the variable
         * 
         * Thus, the overall time taken is:
         * 1 + 2 + ... + n = n * (n + 1) * 0.5 => only n^2 matters
         * 
         * running time is O(n^2)
         */
    }


    public static String repeat_2(int n, char c) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            sb.append(c);
        }
        return sb.toString();
        /**
         * running time is O(n)
         */
    }

    
}