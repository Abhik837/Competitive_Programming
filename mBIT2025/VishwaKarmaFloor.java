import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class VishwaKarmaFloor
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

    public static void solve(int num_tc) {
        while (num_tc-- > 0) {
            int red = sc.nextInt();
            int blue = sc.nextInt();
            int total = red + blue;
            boolean found = false;

            for (int length = 1; length * length <= total; length++) {
                if (total % length != 0) continue;
                int width = total / length;

                for (int[] pair : new int[][]{{length, width}, {width, length}}) {
                    int l = pair[0], w = pair[1];

                    if (l < 1 || w < 1) continue;

                    int area = l * w;
                    int innerTiles = 0;
                    int borderTiles;

                    if (l >= 3 && w >= 3) {
                        innerTiles = (l - 2) * (w - 2);
                        borderTiles = area - innerTiles;
                    } else {
                        innerTiles = 0;
                        borderTiles = area;
                    }

                    if (borderTiles == red && innerTiles == blue) {
                        out.append(l).append(" ").append(w).append("\n");
                        found = true;
                        break;
                    }
                }

                if (found) break;
            }

            if (!found) {
                out.append("-1\n");
            }
        }
    }

    public static void main(String[] args) {
        int t = 1;
        solve(t);
        System.out.println(out.toString());
    }
}
