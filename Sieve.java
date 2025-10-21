/*

 * Sieve.java: Sieve of Erastosthenes example, adapted from
 * https://www.tutorialspoint.com/Sieve-of-Eratosthenes-in-java
 * 
 */

import java.util.Scanner;

public class Sieve  {
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a number");
      int num = sc.nextInt();
      boolean[] bool = new boolean[num];
     
      for (int i = 0; i< bool.length; i++) {
         bool[i] = true;
      }
      for (int i = 2; i< Math.sqrt(num); i++) {
         if(bool[i] == true) {
            for(int j = (i*i); j<num; j = j+i) {
               bool[j] = false;
            }
         }
      }
      System.out.println("List of prime numbers up to the given number are : ");
      int nums = 0;
      for (int i = 2; i< bool.length; i++) {
            if(bool[i]==true) {
               System.out.print(i + "\t");
               nums++;
               if (nums == 10) {
                  System.out.println();
                  nums = 0;
            }
         }
      }
      sc.close();
   }
}