import java.util.Stack;

public class param_matched {
    public static boolean is_match (String expression) {
        final String opening = "({[";
        final String closing = ")}]";
    
        Stack<Character> buffer = new Stack<>();
    
        for (char c : expression.toCharArray()) {
            // for every character in this string
            if (opening.indexOf(c) != -1) {
                // this char is one of the opening delimiters
                buffer.push(c);
            }
            else if (closing.indexOf(c) != -1) {
                // this char is one of the closing delimiters
                if (buffer.isEmpty()) {
                    // nothing to pop / no matching left delimiter presents
                    return false;
                }
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    // the first delimiter on the stack doesn't match the receiving one
                    return false;
                }
            }
        }
        // if after the loop nothing is left in the stack, then the demiliters matched
        // else, there are things that doesn't match, which results in false
        return buffer.isEmpty();
    }
}