public class ArithmeticProgression extends Progression {
    protected long increment;

    public ArithmeticProgression() {
        this(1, 0);
    }

    public ArithmeticProgression(long stepsize) {
        this(stepsize, 0);
    }

    public ArithmeticProgression(long stepsize, long start) {
        // calls the parent class's constructor with the param 'start',
        // = Progression(start);   set the current to start
        super(start);   
        increment = stepsize;
    }

    // Override the original function
    protected void advance() {
        current += increment;
    }
}