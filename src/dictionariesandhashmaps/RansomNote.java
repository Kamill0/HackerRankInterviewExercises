package dictionariesandhashmaps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Long> dictionary = Arrays.stream(magazine)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String word: note) {
           if (dictionary.containsKey(word)) {
               Long count = dictionary.get(word);
               if (count >=1) {
                 dictionary.put(word, --count);
               } else {
                   System.out.println("No");
                   return;
               }
           } else {
               System.out.println("No");
               return;
           }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand" ,"today"};
        checkMagazine(magazine, note);
    }
}

