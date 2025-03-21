//USACO 2019 US Open Contest, Bronze Problem 1. Bucket Brigade
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class BucketBrigade
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

    public static FastReader sc = new FastReader("buckets.in");
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
            pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int barnx = 0;
        int barny = 0;
        int rockx = 0;
        int rocky = 0;
        int lakex = 0;
        int lakey = 0;

        String[] input = new String[10];

        for(int row = 0; row < 10; row++)
        {
            input[row] = sc.nextLine();
            for(int col = 0; col < 10; col++)
            {
                if(input[row].charAt(col) == 'B')
                {
                    barnx = row;
                    barny = col;
                }
                else if (input[row].charAt(col) == 'R')
                {
                    rockx = row;
                    rocky = col;
                }
                else if(input[row].charAt(col) == 'L')
                {
                    lakex = row;
                    lakey = col;
                }
            }
        }

        int cows = Math.abs(barnx - lakex) + Math.abs(barny - lakey) - 1;
        if(lakex == barnx && rockx == lakex)
        {
            if(Math.min(lakey, barny) < rocky && rocky < Math.max(lakey, barny))
                cows += 2;
        }
        if(lakey == barny && lakey == rocky )
        {
            if(Math.min(lakex, barnx) < rockx && rockx < Math.max(lakex, barnx))
                cows += 2;
        }

        pw.println(cows);
        pw.close();
    }
}
