import java.util.Arrays;
import java.util.Random;

public class RandomArrayTest {
    public static void main(String[] args) {
        int data[] = new int[10];
        Random rand = new Random();
        
        // seed = # of milliseconds since 1970/1/1
        rand.setSeed(System.currentTimeMillis());

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100);
            System.out.print(data[i] + ", ");
        }
        System.out.println();

        int[] orig = Arrays.copyOf(data, data.length);
        System.out.println(Arrays.equals(data, orig));
        
        Arrays.sort(data);
        for (int j = 0; j < data.length; j++) {
            System.out.print(data[j] + ", ");
        }
        System.out.println();

        System.out.println("Final Comparasion: ");

        System.out.println("orig = " + Arrays.toString(orig));
        System.out.println("data = " + Arrays.toString(data));
        
    }
}