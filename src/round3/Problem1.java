package round3;

public class Problem1 {
    public static void main(String[] args) {
//        String s = ""
        System.out.println(fun("polishredder"));
    }

    static boolean fun(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length-1;
        boolean isPalindrome;
        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++; end--;
        }
        isPalindrome = true;
        return isPalindrome;
    }
}
