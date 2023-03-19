package round1;

public class Problem1 {
    public static void main(String[] args) {
        int[] nums = {102877, 99679, 99054, 88512, 91577};
        for (int e : nums) {
            System.out.println(isPrime(e));
        }
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
