import java.io.*;
import java.util.*;

public class ProblemEHulkNumber {
    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    String line = b.readLine();
                    if (line == null) {
                        throw new NoSuchElementException("No input available");
                    }
                    s = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return s.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }
    public static FastReader sc = new FastReader();
    public static void main(String[] args) {
        long input = sc.nextLong();
        long i = ((long) (Math.sqrt(input)));

        for (; i >= 1; i--) {
            if (input % i == 0) {
                long num1 = i;
                long num2 = input / i;
                if (((num1 + num2) % 3) == 0) {
                    System.out.println(Math.max(num1, num2) + " " + Math.min(num1, num2));
                    return;
                }
            }
        }
        System.out.println("-1");

    }
}
