package round4;

import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {
        print(10);
    }

    static void print(int n) {
        int count = 1;

        int size = 1;
        for (int i = 2; i <= n; i++) {
            size += 2;
            count += size;
        }
//        System.out.println(count);

        int index = 1;
        long[] nums = new long[count+1];
        long a = 1, b = 2;

        int num = 1;
        while (true) {
            if (index >= nums.length) {
                break;
            }else {
                if (num == 1 || num == 2) {
                    nums[index] = num;
                }else {
                    long temp = b;
                    nums[index] = a + b;
                    a = temp;
                    b = nums[index];
                }
                index++;
            }
            num++;
        }
//        System.out.println(Arrays.toString(nums));
        index = 1;
        int noCount = 1;
        for (int i = 0; i < n; i++) {
            for (int j = n-i; j > 0; j--) {
                if (i == 0) System.out.print("               ");
                else if (i <= 1) System.out.print("               ");
                else if (i <= 2) System.out.print("                ");
                else if (i <= 3) System.out.print("                 ");
                else if (i <= 4) System.out.print("                  ");
                else if (i <= 5) System.out.print("                   ");
                else if (i <= 6) System.out.print("                     ");
                else System.out.print("  ");
            }

            for (int j = 0; j < noCount; j++) {
                if (i <= 1) System.out.print(nums[index] + "            ");
                else if (i == 2) System.out.print(nums[index]+"          ");
                else if (i == 3) System.out.print(nums[index]+"           ");
                else if (i == 4) System.out.print(nums[index]+"            ");
                else if (i == 5) System.out.print(nums[index]+"             ");
                else if (i == 6) System.out.print(nums[index]+"               ");
                else if (i == 7) System.out.print(nums[index]+"                 ");
                else System.out.print(nums[index]+"    ");
                index++;
            }
            noCount += 2;

            System.out.println();
        }
    }
}
