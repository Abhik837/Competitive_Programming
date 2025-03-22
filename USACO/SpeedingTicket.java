//USACO 2015 December Contest, Bronze Problem 2. Speeding Ticket
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SpeedingTicket
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

    public static FastReader sc = new FastReader("speeding.in");
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
            pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int nSegmentAmt = sc.nextInt();
        int mSegmentAmt = sc.nextInt();
        int[] nSpeedLimits = new int[100];
        int[] mSpeeds = new int[100];
        int maxInfraction = 0;
        int index = 0;

        for(int i = 0; i < nSegmentAmt; i++)
        {
            int length = sc.nextInt();
            int limit = sc.nextInt();
            for(int k = 0; k < length; k++)
            {
                nSpeedLimits[index] = limit;
                index++;
            }
        }
        index = 0;
        for(int j = 0; j < mSegmentAmt; j++)
        {
            int length = sc.nextInt();
            int speed = sc.nextInt();
            for(int l = 0; l < length; l++)
            {
                mSpeeds[index] = speed;
                index++;
            }
        }

        for(int h = 0; h < 100; h++)
        {
            if(mSpeeds[h] > nSpeedLimits[h] && (mSpeeds[h] - nSpeedLimits[h]) > maxInfraction)
                maxInfraction = mSpeeds[h] - nSpeedLimits[h];
        }

        pw.println(maxInfraction);
        pw.close();
    }
}
