import java.util.Stack;

public class reverse_array {
    public static <E> void reverse(E[] data) {
        Stack<E> buffer = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            buffer.push(data[i]);
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = buffer.pop();
        }
    }
}