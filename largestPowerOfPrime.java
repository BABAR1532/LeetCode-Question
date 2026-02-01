import java.util.*;


class largestPowerOfPrime{

   public static void main(String[] args){

      Scanner scan = new Scanner(System.in);

      int n = scan.nextInt();
      int p = scan.nextInt();


    int power = 0;

     while(n > 0){

       n /= p;
       power += n;

     }


     System.out.println(power);

   }

}



// Brute force

int power = 0;

while (factN % p == 0) {
    factN /= p;
    power++;
}

System.out.println(power);

