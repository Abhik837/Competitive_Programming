//USACO 2016 January Contest, Bronze Problem 1. Promotion Counting
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class PromotionCounting
{
    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader(String fileName) {
            try {
                b = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Input file not found");
            }
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

        int nextInt() {
            try {
                return Integer.parseInt(next());
            } catch (NumberFormatException e) {
                throw new InputMismatchException("Invalid integer input");
            }
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (s != null && s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static FastReader sc = new FastReader("promote.in");
    public static StringBuilder out = new StringBuilder();
    public static DecimalFormat round = new DecimalFormat("#.00");
    public static double EPS = 1e-6;
    public static int MOD = (int) (1e9 + 7);
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };

    public static void dbg(String varName, Object value) {
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        System.err.println(lineNumber + ": " + varName + " = " + value);
    }

    public static void dbg(String varName, Object[] arr) {
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        System.err.println(lineNumber + ": " + varName + " = " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] start = new int[4];
        int[] end = new int[4];
        for(int i = 0; i < 4; i++)
        {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        int goldPlat = end[3] - start[3];
        int silverGold = (end[2] - start[2]) + goldPlat;
        int bronzeSilver = (end[1] - start[1]) + silverGold;

        pw.println(bronzeSilver);
        pw.println(silverGold);
        pw.println(goldPlat);
        
        pw.close();
    }
}
