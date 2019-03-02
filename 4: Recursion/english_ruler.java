public class english_ruler {
    public static void draw_ruler(int n_inches, int major_length) {
        draw_line(major_length, 0);
        for (int i = 1; i <= n_inches; i++) {
            draw_interval(major_length -1);
            draw_line(major_length, i);
        }
    }
    
    public static void draw_interval(int central_length) {
        if (central_length >= 1) {
            draw_interval(central_length - 1);
            draw_line(central_length);
            draw_interval(central_length - 1);
        }
    }

    public static void draw_line(int tick_length, int tick_label) {
        for (int i = 0; i < tick_length; i++) {
            System.out.print("-");
        }
        if (tick_label >= 0) {
            System.out.print(" " + tick_label);
        }
        System.out.print("\n");
    }

    public static void draw_line(int tick_length) {
        draw_line(tick_length, -1);
    }

    public static void main(String[] args) {
        draw_ruler(10, 5);
    }
}