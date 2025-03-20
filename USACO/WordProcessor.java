//Program for USACO 2020 January Contest, Bronze Problem 1. Word Processor
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class WordProcessor
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

    public static FastReader sc = new FastReader("word.in");
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
        PrintWriter pw;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int amtWords = sc.nextInt();
        int maxLen = sc.nextInt();
        String[] words = sc.nextLine().split(" ");
        int currLen = 0;

        for(int i = 0; i < amtWords; i++)
        {
            if(currLen + words[i].length() > maxLen)
            {
                pw.println(out.toString().trim());
                currLen = 0;
                out.setLength(0);
            }
            out.append(words[i].trim() + " ");
            currLen += words[i].length();
        }
        
        if(out.length() > 0)
        {
            pw.println(out.toString().trim());
        }

        pw.close();
    }
}
