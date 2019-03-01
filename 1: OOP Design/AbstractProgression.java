public abstract class AbstractProgression {
    protected long current;

    public AbstractProgression() {  // constructor
        this(0);    // same as Progression(0), set the default current to 0
    }

    public AbstractProgression(long start) {
        current = start;
    }

    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }

    // only signature here, to use this, subclasses must provide the 
    // code. It is initiated as abstract because it is designed to be
    // overriden
    protected abstract void advance();  

    public void printProgression(int n) {
        System.out.print(nextValue());
        for (int i = 1; i < n; i++) {
            System.out.print(" " + nextValue());
        }
        System.out.println();
    }    
}