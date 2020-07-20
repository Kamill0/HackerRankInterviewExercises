package dictionariesandhashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    private static boolean checkIfAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] a_freq = getFreqArray(a);
        int[] b_freq = getFreqArray(b);

        for (int i=0; i<26;++i) {
            if (a_freq[i] != b_freq[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getFreqArray(String a) {
        int [] freq = new int[26];
        for (int i=0; i<a.length(); ++i) {
            char c = a.charAt(i);
            int value = c - 'a';
            freq[value]++;
        }
        return freq;
    }

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

        //System.out.println(checkIfAnagram("abba", "bbba"));
    }
}
