import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        scan.nextLine();

        int[] arr = new int[size];

        for(int i = 0; i < size; i++){

           int num = scan.nextInt();

           // Taking input in array
           arr[i] = num;
        }








    }








}
