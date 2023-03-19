package round4;

public class Problem4 {
    public static void main(String[] args) {
        print(5);
    }

    static void print(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n-i; j > 0; j--) {
                System.out.print("  ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }

            for (int j = 0; j < i-1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        for (int i = n-1; i > 0; i--) {
            for (int j = n-i; j > 0; j--) {
                System.out.print("  ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }

            for (int j = 0; j < i-1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
