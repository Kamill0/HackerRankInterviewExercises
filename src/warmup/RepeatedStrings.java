package warmup;

public class RepeatedStrings {
    static long countLetterA(String s) {
        return s.chars().filter(ch -> ch == 'a').count();
    }

    static long repeatedString(String s, long n) {
        long fullStrings = n / s.length();
        long rest = n % s.length();

        return (countLetterA(s) * fullStrings) + countLetterA(s.substring(0, (int) rest));
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000L));
    }
}
