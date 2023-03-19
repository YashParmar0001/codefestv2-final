package round4;

import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
//        int n = 10;
        printPyramid(8);
    }

    static void printPyramid(int n) {
        int primeCount = (n * (n+1))/2;
        int[] prime = new int[primeCount+1];

        int num = 1;
        int index = 1;
        while (true) {
            if (index >= prime.length) {
                break;
            }else {
                if (isPrime(num)) {
                    prime[index] = num;
                    index++;
                }
            }
            num++;
        }

        index = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(prime[index] + " ");
                index++;
            }
            System.out.println();
        }

//        System.out.println(Arrays.toString(prime));
    }

    static boolean isPrime(int n) {
        if (n == 1) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
