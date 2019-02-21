public class FibonacciProgression extends Progression {
    // prev stores the difference between the current position and
    // the number before it
    protected long prev;    

    public FibonacciProgression() {
        this (0, 1);
    }

    public FibonacciProgression(long first, long second) {
        super(first);
        prev = second - first;
    }

    protected void advance() {
        long temp = current + prev;
        prev = current;
        current = temp;
    }
}