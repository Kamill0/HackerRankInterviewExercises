import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;


class Result {


    /*
     * Complete the "stringAnagram" function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY dictionary
     *  2. STRING_ARRAY query
     */

    private static boolean checkIfAnagram(int[] original, int[] candidate) {
        for (int i = 0; i < 26; i++) {
            if (original[i] != candidate[i]) {
                return false;
            }
        }

        return true;
    }

    private static Integer verifySingleString(int[] word, List<int[]> dictionary) {
        int anagrams = 0;

        for (int[] dictionaryEntry : dictionary) {
            if (checkIfAnagram(word, dictionaryEntry)) {
                anagrams++;
            }
        }
        return anagrams;
    }


    private static List<int[]> calcCharFreq(List<String> query) {
        List<int[]> frequenciesList = new ArrayList<>();

        for (String queryEntry : query) {
            int[] frequencies = new int[26];
            for (int i = 0; i < queryEntry.length(); i++) {
                char currentChar = queryEntry.charAt(i);
                int index = currentChar - 'a';
                frequencies[index]++;
            }
            frequenciesList.add(frequencies);
        }
        return frequenciesList;
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> anagrams = new ArrayList<>();

        List<int[]> queryFrequencies = calcCharFreq(query);
        List<int[]> dictionaryFrequencies = calcCharFreq(dictionary);


        for (int[] queryEntry : queryFrequencies) {
            anagrams.add(verifySingleString(queryEntry, dictionaryFrequencies));
        }
        return anagrams;
    }

}


public class Tests {

    // Functions from a different test, left it here for reference

/*    public static List<String> mostActive(List<String> customers) {
        return customers.stream()
                .sorted()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .collect(toMap(Map.Entry::getKey, entry -> getDealsPercentage(customers, entry)))
                .entrySet().stream().filter(stringDoubleEntry -> stringDoubleEntry.getValue() >= 0.05)
                .map(Map.Entry::getKey)
                .sorted().collect(toList());
    }

    private static double getDealsPercentage(List<String> customers, Map.Entry<String, Long> entry) {
        return entry.getValue() / (double) customers.size();
    }*/


    public static void main(String[] args) throws IOException {
        List<String> dictionary = Arrays.asList("heater", "cold", "clod", "reheat", "docl");
        List<String> query = Arrays.asList("codl", "heater", "abcd");
        System.out.println(Result.stringAnagram(dictionary, query));
    }
}
