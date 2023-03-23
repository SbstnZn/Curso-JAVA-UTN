import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    //Ejercicio 1.a
        String palabra="league of legends";
        char letra = 'e';
        int cuantas_letras = contador_letras.cant_letras(palabra,letra);
        System.out.println("cantidad de \""+ letra + "\": " + cuantas_letras);
    //Ejercicio 1.b
        int a = 401, b = 5529, c = 10;
        Scanner opc = new Scanner(System.in);
        System.out.println("Ascendente (a) - Descendente (d)");
        String opcion = opc.next();
        Integer[] array_ordenado = ordenar_num.ordenar_enteros(a,b,c,opcion);;
        for (int x : array_ordenado) { System.out.println(x);}
    //Ejercicio 1.c
        Integer[] vector_x = {3,5,20,50,66};
        System.out.println("ingrese un numero:");
        int numero = opc.nextInt();
        numero = suma_numeros.resultado_suma(vector_x,numero);
        System.out.println("el resultado es: " + numero);
    //Ejercicio 2
        String texto = "hola que tal?";
        System.out.println("texto: "+ texto );
        texto = codificador.codificacion(texto);
        System.out.println("texto codificado: "+ texto );
        texto = codificador.decodificacion(texto);
        System.out.println("texto: "+ texto );

    }
}