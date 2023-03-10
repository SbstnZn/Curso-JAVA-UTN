import java.util.Scanner;
public class Clase1_ejercicio1 {
  

 public static void main (String[] args){
   int num_i=5;
   int num_f=14;
   System.out.println("Ejercicio 1.a");
   while(num_i <= num_f) {
     System.out.println(num_i);
     num_i++;
   }
   System.out.println("\n");
   System.out.println("Ejercicio 1.b");
   num_i=5;
   while(num_i <= num_f) {
     if((num_i%2) == 0) {
       System.out.println(num_i);
     }
     num_i++;
   }
   System.out.println("\n");
   System.out.println("Ejercicio 1.c");
   num_i=5;
   Scanner opc = new Scanner(System.in);
   System.out.println("pares(0) - impares(1)");
   int opcion = opc.nextInt();
   if(opcion == 0){
      while(num_i <= num_f) {
        if((num_i%2) == 0) {
          System.out.println(num_i);
        }
      num_i++;
      }      
   } else {
      while(num_i <= num_f) {
        if((num_i%2) != 0) {
          System.out.println(num_i);
        }
      num_i++;
      }      
   }
   System.out.println("\n");
   System.out.println("Ejercicio 1.d");
   num_i=5;
   for(int i=14;i>num_i;i--){
     if((i%2) == 0){
       System.out.println(i);
     }
   }
  }
}