package warmup;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int seaLevel = 0;
        int valleys = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == 'D') {
                seaLevel--;
            }

            if (s.charAt(i) == 'U') {
                seaLevel++;
                if (seaLevel == 0) {
                    valleys++;
                }
            }
        }
        return valleys;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
    }
}
