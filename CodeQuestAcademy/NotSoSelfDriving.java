import java.util.*;

public class NotSoSelfDriving {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int cases = Integer.parseInt(in.nextLine());
        for(int i = 0; i < cases; i++)
        {
            String input = "";
            input = in.nextLine();
            double speed = Double.parseDouble(input.substring(0,input.indexOf(':')));
            double distance = Double.parseDouble(input.substring(input.indexOf(':') + 1));
            double collison = distance/speed;
            if(collison <= 1)
            {
                System.out.println("SWERVE");
            }
            else if(collison <= 5)
            {
                System.out.println("BRAKE");
            }
            else
            {
                System.out.println("SAFE");
            }
        }
    }
}
