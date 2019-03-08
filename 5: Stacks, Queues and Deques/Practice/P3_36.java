import java.util.ArrayDeque;

public class P3_36 {

    public static class stock {
        private ArrayDeque<Integer> q;
        private int revenue;

        public stock() {
            q = new ArrayDeque<>();
            revenue = 0;
        }

        public void buy(int price, int number) {
            // add shares in the queue
            for (int i = 0; i < number; i++) {
                q.add(price);
            }
        }

        public void sell(int price, int number) {
            for (int i = 0; i < number; i++) {
                revenue += q.remove();
            }
        }

        public void money() {
            System.out.println("Money earned: $" + revenue);
        }
    }
    
    public static void main(String[] args) {
        stock s = new stock();

        s.buy(10, 10);
        s.sell(20, 5);
        s.money();
    }
}