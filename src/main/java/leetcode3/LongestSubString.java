package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(longestSubStringCount(""));
    }

    public static int longestSubStringCount(String s) {
        int length = 0;
        String[] strings = s.split("");
        List<String> result = new ArrayList<>();
        if (s.length() != 0) {
            for (String singleWord : strings
            ) {
                if (result.contains(singleWord)) {
                    if (result.size() > length) {
                        length = result.size();
                    }
                    result = result.subList(result.indexOf(singleWord) + 1, result.size());
                }
                result.add(singleWord);
            }
            length = Math.max(length, result.size());
        }
        return length;
    }
}
