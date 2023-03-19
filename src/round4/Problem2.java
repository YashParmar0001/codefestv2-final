package round4;

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        print(4);
    }

    static void print(int n) {
        int count = (n * (n+1))/2;
        int index = 1;
        int[] nums = new int[count+1];

        int num = 1;
        while (true) {
            if (index >= nums.length) {
                break;
            }else {
                if (num % 3 == 0 && num % 5 == 0) {
                    nums[index] = num;
                    index++;
                }
            }
            num++;
        }

        index = 1;
        for (int i = 0; i <= n; i++) {

            for (int j = n-i; j > 0; j--) {
                if (i <= 3) System.out.print("    ");
                else System.out.print("    ");
            }

            for (int j = 0; j < i; j++) {
                if (i <= 3) System.out.print(nums[index] + "  ");
                else System.out.print(nums[index] + " ");
                index++;
            }
            System.out.println();
        }
//        System.out.println(Arrays.toString(nums));
    }
}
