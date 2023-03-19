package round1;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = "good bye world";
        System.out.println(findCommon(s1, s2));
    }

    static Set<Character> findCommon(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char c: s1.toCharArray()) {
            if (!isVowel(c) && s2.contains(c + "") && c != ' ') {
                set.add(c);
            }
        }
        return set;
    }

    static boolean isVowel(char c) {
        return (c == 'A' || c == 'a' || c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U');
    }
}
