package dictionariesandhashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        int anagrams = 0;
        Map<String,Integer> map = new HashMap<>();
        String word = s;
        for (int start=0; start<word.length(); start++) {
            for (int end=start+1; end<=word.length(); end++) {
                String tmp = word.substring(start,end);
                tmp = sort(tmp);

                int count = map.getOrDefault(tmp, 0);

                if (count > 0) {
                    anagrams += count;
                }

                map.put(tmp, ++count);

            }
        }
        return anagrams;
    }


    static String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
        System.out.println(sherlockAndAnagrams("cdcd"));
    }
}
