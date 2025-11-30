import java.util.*;


class Marks{
 
    // Method for printing list value
    public static void print(ArrayList<String> list){

        for(String a: list){
            
            System.out.println(a + " ");
        }

        System.out.println();
    }



    public static void main(String[] args){
      
          Scanner scan = new Scanner(System.in);

          int size = scan.nextInt();

          ArrayList<String> list = new ArrayList<>(size);

          for(int i = 0; i  < size; i++){

             String value = scan.next();
             list.add(value);
          }

  
         int operations = scan.nextInt();
         
         
         for(int i = 0; i < operations; i++){

            String[] operation = scan.nextLine().trim().split(" ");
   
           
            if(operation[0].equals("ADD")){

                list.add(operation[1]);
                print(list);

            }

            else if(operation[0].equals("Remove")){

                 if(list.contains(operation[1])){
                     list.remove(operation[1]);
                     print(list);

                 } else{
                    System.out.println("Not found");
                 }
            }

            else if(operation[0].equals("SEARCH")){

                 if(list.contains(operation[1])){
                 
                     int index = list.indexOf(operation[1]);
                     System.out.println("Found! value is in index " + index);
                 }
                 else{
                    System.out.println("Not found!");
                 }
            }

            else if(operation[0].equals("PRINT")){
               
                 print(list);
            }

         }
   


         
    }
}
