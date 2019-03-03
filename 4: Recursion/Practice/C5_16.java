import java.util.Stack;

public class C5_16 {
    /**
     * pseudocode
     * - target pole: where the disks are moved to
     * - temp pole: the temporary storing pole
     * - store pole: where the disks are moved from
     * 
     * param: pole_target, pole_temp, pole_store, int n(# of disks)
     * 
     * if n == 2 (2 disks)
     * small disk [store -> temp]
     * large disk [store -> target]
     * small disk [temp -> target]
     * 
     * else (n >= 2)
     * (n - 1) disk [store -> temp]
     * large disk [store -> target]
     * (n - 1) disk [temp -> target]
     */ 

    public static class tower {
        private Stack<Integer> pole_target, pole_temp, pole_store;
        private int height;

        public tower(int n) {
            height = n;

            pole_store = new Stack<Integer>();
            pole_temp = new Stack<Integer>();
            pole_target = new Stack<Integer>();

            for (int i = height; i > 0; i--) {
                // push the storing pole with the current number fo disks
                pole_store.push(i);
            }
        }

        public Stack<Integer> target() {
            return pole_target;
        }

        public Stack<Integer> temp() {
            return pole_temp;
        }

        public Stack<Integer> store() {
            return pole_store;
        }

        public int height() {
            return height;
        }

        public void move(Stack<Integer> from, Stack<Integer> to) {
            // pop one number from the 'from' pole, and push
            // it to the 'to' pole
            to.push(from.pop());
            show();
        }

        public void show() {
            // display the current status of the three poles
            Object[] store = pole_store.toArray();
            Object[] temp = pole_temp.toArray();
            Object[] target = pole_target.toArray();

            System.out.print("temp:   ");
            print_array(temp, height);

            System.out.print("target: ");
            print_array(target, height);

            System.out.print("store:  ");
            print_array(store, height);

            System.out.print("\n");
        }

        public void print_array(Object[] obj, int h) {  // helper function
            for (int i = 0; i < h - obj.length; i++) {
                System.out.print("0  ");
            }
            for (int i = obj.length; i > 0; i--) {
                System.out.print(obj[i - 1] + "  ");
            }
            System.out.print("\n");
        }

        public void solve() {
            move(height, pole_store, pole_target, pole_temp);
        }

        // n: number of disks
        public void move(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> temp) {
            /* logic explained in the pseudocode */
            if (n == 2) {
                move(from, temp);
                move(from, to);
                move(temp, to);
            }
            else {
                move(n - 1, from, temp, to);
                move(from, to);
                move(n - 1, temp, to, from);
            }
        }
    }
    public static void main(String[] args) {
        tower t = new tower(5);
        t.show();

        t.solve();
    }
}