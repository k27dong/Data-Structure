import java.util.Stack;

public class html_matched {
    public static boolean is_html_match (String html) {
        Stack<String> buffer = new Stack<>();
        int j = html.indexOf('<');
        while (j != -1) {   // while there're still more left tags in the string
            int k = html.indexOf('>', j + 1);
            if (k == -1) {
                // if there'are no more right tags later in the string
                return false;
            }

            // by this point, we have a full tag '< ... >' located
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) {
                // if this is a opening
                buffer.push(tag);
            }
            else {
                if (buffer.isEmpty()) {
                    // if the stack has nothing to pop
                    return false;
                }
                if (!tag.substring(1).equals(buffer.pop())) {
                    // if the popped element doesn't match the detected element
                    return false;
                }
            }
            j = html.indexOf('<', k + 1);   // starts to find the next tag, this process repeats
        }
        // if the loop safely reaches through the end of the loop
        // then everything matches
        return true;
    }
}