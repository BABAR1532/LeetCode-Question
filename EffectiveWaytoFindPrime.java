import java.util.*;


class EffectiveWaytoFindPrime{

    public static void main(String[] args){

     Scanner scan = new Scanner(System.in);
     int n = scan.nextInt();


     // Removing Mutilple of 2
     while(n % 2 == 0){
         n = n / 2;
         System.out.println(2);
     }


     // Odd Number
     for(int i = 3; i * i <= n; i += 2){

        while(n % i == 0){

            n = n / i;
            System.out.println(i);
        }
     }

     // Remaing that will be prime nubmer
     if(n > 1){
       System.out.println(n);
     }
    }

}
