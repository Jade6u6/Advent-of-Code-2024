import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D1Historian_Hysteria {
    public int answer(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        int ans = 0;
        Collections.sort(list1);
        Collections.sort(list2);

        for(int i = 0; i<list1.size(); i++)
        {
            if(list1.get(i) > list2.get(i))
                ans += (list1.get(i) - list2.get(i));
            else
                ans += (list2.get(i) - list1.get(i));
        }
        return ans;
    }
    public static void main(String[] args)
    {
        String filePath = "D:\\jdk\\Advent-of-code\\D1.txt";
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] numbers = line.split("\\s+");
                try
                {
                    int a = Integer.parseInt(numbers[0].trim());
                    int b = Integer.parseInt(numbers[1].trim());

                    A.add(a);
                    B.add(b);
                }
                catch(NumberFormatException | ArrayIndexOutOfBoundsException ae)
                {
                    System.out.println("Error");
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        D1Historian_Hysteria historian = new D1Historian_Hysteria();
        System.out.println(historian.answer(A,B));
    }
    
}
