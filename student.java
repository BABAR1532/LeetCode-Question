import java.util.*;

public class student{

   public static void main(String[] args){

       Scanner scan = new Scanner(System.in);

       ArrayList<Student> list = new ArrayList<>();

       list.add(new Student(24,"Ankit kumar",34.5));
       list.add(new Student(25,"Shibu",67.8));
       list.add(new Student(26,"Lokesh",89.5));



       for(Student s: list){

        System.out.println(s);
        System.out.println("***********");

       }

       // Search student by name

       String searchStudent = scan.nextLine();
       boolean flag = false;

       for(Student s: list){

            if(searchStudent.equals(s.getname())){

              System.out.println("**********");
              System.out.println("Student Found");
              System.out.println(s);
              flag = true;
            }
       }

       if(!flag) System.out.println("Student Not Found");
      

       // Student with highest marks
       Student highMarks = list.get(0);

       for(Student a:list){
    
           if(a.getMarks() > highMarks.getMarks()){
                 highMarks = a;
           }
       }


       // Student with highest marks
        System.out.println("******* Student with high marks ******");
        System.out.println(highMarks);



        System.out.println("\nHow do you want to sort?");
        System.out.println("1. By Name");
        System.out.println("2. By Marks");
        System.out.print("Enter choice: ");
 
        int sortingType = scan.nextInt();

        switch(sortingType){
   
           case 1:
              Collections.sort(list,new sortByName());
              System.out.println("Sorted by name");
              break;

          case 2:
              Collections.sort(list,new sortByMarks());
              System.out.println("Sorted by Marks");
              break;    

        }


        System.out.println("*************");


        for(Student a: list){
           System.out.println(a);
           System.out.println("*************");
        }

   }



}

class sortByName implements Comparator<Student>{
     
    public int compare(Student a, Student b){
        
       return a.getname().compareToIgnoreCase(b.getname());
    }
}



class sortByMarks implements Comparator<Student>{
     
    public int compare(Student a, Student b){
        
        return Double.compare(a.getMarks(), b.getMarks());
    }
}







 class Student{

   int id;
   String name;
   double marks;


   public Student(int id,String name,double marks){

       this.id = id;
       this.name = name;
       this.marks = marks;
    }


   public String getname() {return this.name;}

   public int getId() {return this.id;}

   public double getMarks()  {return this.marks;}

   public String toString(){

      return this.id + "\n" + this.name + "\n" + this.marks;
   }


 }


