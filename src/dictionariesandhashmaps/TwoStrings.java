package dictionariesandhashmaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        Set<String> s1Set = new HashSet<>(Arrays.asList(s1.split("")));
        for(String s2Letter: s2.split("")) {
            if(s1Set.contains(s2Letter)) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }
}
