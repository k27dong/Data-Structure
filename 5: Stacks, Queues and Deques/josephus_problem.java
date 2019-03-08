/**
 * This is an implementation on the Josephus Problem using the CircularQueue class
 * Done in a simialr way was CircularLinkedList
 */

public class josephus_problem {

    public static class josephus {
        private CircularlyQueue<String> c;

        public josephus(int capacity) {
            c = new CircularlyQueue<>(capacity);
        }

        public void fill(int option) throws IllegalArgumentException{
            if (option == 1) {
                // fill with labeled integer
                for (int i = 1; i <= c.length(); i ++) {
                    c.enqueue(Integer.toString(i));
                }
            }
            else if (option == 2) { /* FIX ME */
                // fill the array with random names
                throw new IllegalArgumentException("this feature has not been updated yet");
            }
            else {
                throw new IllegalArgumentException("Illegal argument!");
            }
        }

        public void roll(int n) {
            c.rotate(n);
            String temp = c.dequeue();
            System.out.println(temp + " was removed. " + c.size() + " items left.");
        }

        public void roll_all(int n) {
            while(c.size() != 1) {
                roll(n);
            }
            System.out.println("All but one is left: " + c.first());
        }

        public void print() {
            c.print();
        }
    }
    
    public static void main(String[] args) {    // test
        josephus j = new josephus(10);
        j.fill(1);
        j.print();
        j.roll_all(3);
    }
}