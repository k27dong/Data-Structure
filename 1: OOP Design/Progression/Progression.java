import java.util.*;

/*
- this() can be used in constructor to initialize variable without reference
their names but only the number of input
- inher

*/
public class Progression {
    protected long current;

    public Progression() {  // constructor
        this(0);    // same as Progression(0), set the default current to 0
    }

    public Progression(long start) {
        current = start;
    }

    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }

    protected void advance() {
        current++;
    }

    public void printProgression(int n) {
        System.out.print(nextValue());
        for (int i = 1; i < n; i++) {
            System.out.print(" " + nextValue());
        }
        System.out.println();
    }    
}