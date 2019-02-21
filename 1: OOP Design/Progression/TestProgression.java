public class TestProgression {
    public static void main(String[] args) {
        Progression prog;   // initialte an instance of the parent class

        // Arithmetic Testing:
        System.out.println("Arithmetric: ");
        prog = new ArithmeticProgression();     // stepsize = 1, start = 0 (default)
        prog.printProgression(10);

        prog = new ArithmeticProgression(5);    // stepsize = 5, start = 0
        prog.printProgression(10);

        prog = new ArithmeticProgression(3, 9); // stepsize = 3, start = 9
        prog.printProgression(10);

        // Geometric Testing:
        System.out.println("\nGeometric: ");
        prog = new GeometricProgression();      // base = 2, start = 1 (default)
        prog.printProgression(10); 
        
        prog = new GeometricProgression(3);     // base = 3, start = 1
        prog.printProgression(10);

        prog = new GeometricProgression(2, 5);  // base = 2, start = 5
        prog.printProgression(10);

        // Fibonacci Testing:
        System.out.println("\nFibonacci: ");
        prog = new FibonacciProgression();      // current = 1, prev = 0 (default)
        prog.printProgression(10);

        prog = new FibonacciProgression(3, 2);  // current = 2, prev = 3
        prog.printProgression(10);
    }
}