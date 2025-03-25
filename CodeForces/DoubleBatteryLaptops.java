import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class DoubleBatteryLaptops
{

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

    public static void main(String[] args) {
        int bannedNum = sc.nextInt();
        int systemNum = sc.nextInt();
        String[] banned = sc.nextLine().split(" ");
        String[] system = sc.nextLine().split(" ");
        boolean jailbroke = false;

        for(int i = 0; i < bannedNum; i++)
        {
            for(int k = 0; k < systemNum; k++)
            {
                if(banned[i].equals(system[k]))
                {
                    System.out.println("YES");
                    jailbroke = true;
                    return;
                }
            }
        }
        if(jailbroke == false)
            System.out.println("NO");
    }
}
