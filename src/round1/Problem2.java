package round1;

public class Problem2 {
    public static void main(String[] args) {
        int a = 1250, b = 1898;
        System.out.println(sum(a, b));
    }

    static int sum(int a, int b) {
        int sum = 0;
        for (int i = a; i < b; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
