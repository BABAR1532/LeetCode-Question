 public static int divisors(int n) {
    // Write your code here

       if(n % 2 != 0) return 0;

       // Removing 2*multiple
       int k = 0;

       while(n % 2 == 0){
           n = n / 2;
           k++;
       }

       int count = 0;

       for(int i = 1; i * i <= n; i++){

           // Counting if n % i == 0 then n / i als divide n
             if(n % i == 0){
                 count += 2;
             }
       }

       // If perfect square
       long perfect = (long)Math.sqrt(n);s

       if(perfect * perfect == n){
          count--;
       }


     return k * count;

    }
