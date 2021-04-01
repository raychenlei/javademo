package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenlei
 * @version 1.0
 * @description
 * @date 2021/3/8 8:56 PM
 **/
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0;
        int valid = 0;
        List<Integer> result = new ArrayList<>();
        while (end < s.length()) {
            char rightChar = s.charAt(end);
            end++;
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (need.get(rightChar).equals(window.get(rightChar))) {
                    valid++;
                }
            }

            while (end - start >= p.length()) {
                if (valid == need.size()) {
                    result.add(start);
                }
                char leftChar = s.charAt(start);
                start++;
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) {
                        valid--;
                    }

                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                }
            }
        }
        return result;
    }

}
