import java.util.*;

public class aliceApple{

    Scanner scan = new Scanner(System.in);

    int sum = 0;
    int count = 0;

    int aliceApple = scan.nextInt();

    while(sum < aliceApple){

      count++;
      sum += 12 * count * count;

    }

    System.out.println(8 * count);

}
