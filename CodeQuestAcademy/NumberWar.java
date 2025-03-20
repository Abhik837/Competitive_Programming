import java.util.*;

public class NumberWar {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        int cases = Integer.parseInt(in.nextLine());
        for(int i = 0; i < cases; i++)
        {
            String input = in.nextLine();
            String[] numsAll = input.split(" ");
            ArrayList<Integer> numsA = new ArrayList<>();
            for(int j = 0; j < 3; j++)
            {
                numsA.add(Integer.parseInt(numsAll[j]));
            }
            Collections.sort(numsA);
            ArrayList<Integer> numsB = new ArrayList<>();
            for(int k = 3; k < 6; k++)
            {
                numsB.add(Integer.parseInt(numsAll[k]));
            }
            Collections.sort(numsB);
            String highA1 = "" + numsA.get(numsA.size() - 1);
            String lowA1 = "" + numsA.get(numsA.size() - 2);
            String A = "" + highA1 + lowA1;
            String highB1 = "" + numsB.get(numsB.size() - 1);
            String lowB1 = "" + numsB.get(numsB.size() - 2);
            String B = ""+ highB1 + lowB1;
            if(Integer.parseInt(A) > Integer.parseInt(B))
            {
                System.out.println("PLAYER 1");
            }
            else if(Integer.parseInt(B) > Integer.parseInt(A))
            {
                System.out.println("PLAYER 2");
            }
            else
            {
                System.out.println("WAR!");
            }
        }
    }
}
