//USACO 2017 December Contest, Bronze Problem 2. The Bovine Shuffle
import java.io.*;
import java.util.*;

public class BovineShuffle
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

    public static FastReader sc = new FastReader("shuffle.in");

    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int cows = sc.nextInt();
        int[] shuffle = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] finalPos = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for(int shuffles = 0; shuffles < 3; shuffles++)
        {
            int[] reverse = new int[cows];
            for(int k = 0; k < cows; k++)
                reverse[k] = finalPos[shuffle[k] - 1];
            finalPos = reverse;
        }

        for(int i = 0; i < finalPos.length; i++)
        {
            pw.println(finalPos[i]);
        }

        pw.close();
    }
}
