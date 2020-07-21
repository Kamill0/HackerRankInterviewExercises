package dictionariesandhashmaps;

import java.util.*;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < queries.size(); ++i) {
            int[] pair = queries.get(i);
            Integer y = pair[1];
            switch (pair[0]) {
                case 1:
                    Integer vi = freq.getOrDefault(y, 0);
                    Integer new_vi = vi + 1;
                    freq.put(y, new_vi);

                    Integer counter_val = counter.getOrDefault(new_vi, 0);
                    counter.put(new_vi, counter_val + 1);

                    if (vi > 0) {
                        counter.put(vi, counter.get(vi) - 1);
                    }

                    break;
                case 2:
                    Integer vd = freq.getOrDefault(y, 0);
                    if (vd > 0L) {
                        counter.put(vd, counter.get(vd) - 1);
                        int new_vd = vd - 1;
                        freq.put(y, new_vd);
                        if (vd > 1) {
                            counter.put(new_vd, counter.get(new_vd) + 1);
                        }
                    }
                    break;
                case 3:
                    if (counter.getOrDefault(y, 0) > 0) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("incorrect input");
            }
        }


        return result;
    }

/*    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\KLPY\\IdeaProjects\\TestProject\\src\\arrays\\input.txt"))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\KLPY\\IdeaProjects\\TestProject\\src\\arrays\\result.txt"))) {
                bufferedWriter.write(
                        ans.stream()
                                .map(Object::toString)
                                .collect(joining("\n"))
                                + "\n");
            }
        }
    }*/

    public static void main(String[] args) {
        System.out.println(freqQuery(Arrays.asList( // 0, 1
                new int[]{1, 5},
                new int[]{1, 6},
                new int[]{3, 2},
                new int[]{1, 10},
                new int[]{1, 10},
                new int[]{1, 6},
                new int[]{2, 5},
                new int[]{3, 2}
        )));

        System.out.println(freqQuery(Arrays.asList( // 0, 1
                new int[]{3, 4},
                new int[]{2, 1003},
                new int[]{1, 16},
                new int[]{3, 1}
        )));

        System.out.println(freqQuery(Arrays.asList( // 0, 1, 1
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{3, 2},
                new int[]{1, 4},
                new int[]{1, 5},
                new int[]{1, 5},
                new int[]{1, 4},
                new int[]{3, 2},
                new int[]{2, 4},
                new int[]{3, 2}
        )));
    }
}
