import java.util.*;

public class FlexTime {

   private static Scanner in = new Scanner(System.in);
     
   public static void main(String[] args){
     
      int cases = Integer.parseInt(in.nextLine());
     
      for(int i = 0; i < cases; i++)
      {
         int proj = Integer.parseInt(in.nextLine());
         ArrayList<Integer> arr1 = new ArrayList<Integer>();
         int total = 0;
         for(int n = 0; n < proj; n++)
         {
            String input = in.nextLine();
            String[] strings = input.split(" ");
            for(int j = 0; j < strings.length; j++)
            {
                if(Integer.parseInt(strings[j]) != 0)
                    arr1.add(Integer.parseInt(strings[j]));
            }
         }
         for(int k = 0; k < arr1.size(); k++)
         {
            total += arr1.get(k);
         }
         System.out.println(total - 40);
      }
   }
}
