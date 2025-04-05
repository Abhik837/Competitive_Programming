import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.*;

public class ProblemDBattle {
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

    public static FastReader sc = new FastReader();
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

    public static int calcStrength(ArrayList<Integer> formation)
    {
        int strength = 0;
        for(int i = 0; i < formation.size(); i++)
        {
            strength += formation.get(i);
        }
        return strength;
    }
    public static void main(String[] args) {
        int soldiers = sc.nextInt();
        ArrayList<Integer> formation = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> reserves = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        int maxStrength = calcStrength(formation);

        for(int i = 0; i < soldiers; i++)
        {
            formation.remove(i);
            formation.add(i, reserves.get(i));
            int currStrength = calcStrength(formation);
            if(currStrength > maxStrength)
                maxStrength = currStrength;
        }

        out.append(maxStrength);
        System.out.println(out.toString());
    }
}
