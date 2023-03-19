package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int target = 12;
        for (int[] pair: findPairs(arr, target)) {
            System.out.println(Arrays.toString(pair));
        }
    }

    static List<int[]> findPairs(int[] arr, int target) {
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]+arr[j]==target) ans.add(new int[]{arr[i], arr[j]});
            }
        }
        return ans;
    }
}
