import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.CollationElementIterator;
import java.util.*;

public class Funciones {
    static void cod_decod (String opc, int desplazo, String arch_1){
        List<String> texto = new ArrayList<>();
        try {
            texto = Files.readAllLines(Paths.get(arch_1));
            for (String z : texto) {
                System.out.println(z);
            }
        } catch (IOException e){
            System.out.println("error al leer el archivo.");
            e.printStackTrace();
            return;
        }
        String mensaje="";
        if (opc.equalsIgnoreCase("c")){
            for (String x : texto){
                mensaje = mensaje + codificador(x,desplazo);
            }
            try {
                File nuevo_archi = new File(System.getProperty("user.dir") + "\\texto_cod.txt");
                FileWriter escribe = new FileWriter(System.getProperty("user.dir") + "\\texto_cod.txt");
                escribe.write(mensaje);
                System.out.println("se termino la funcion correctamente.");
                escribe.close();

            } catch (IOException e){
                System.out.println("error al escribir");
                e.printStackTrace();
            }
        } else if (opc.equalsIgnoreCase("d")) {
            for (String z : texto){
                mensaje=mensaje + decodificador(z,desplazo);
            }
            try {
                File nuevo_archi = new File(System.getProperty("user.dir") + "\\texto_decod.txt");
                FileWriter escribe = new FileWriter(System.getProperty("user.dir") + "\\texto_decod.txt");
                escribe.write(mensaje);
                System.out.println("se termino la funcion correctamente");
                escribe.close();

            } catch (IOException e){
                System.out.println("error al escribir");
                e.printStackTrace();
            }
        }
    }
    static String codificador (String texto) {
        char [] texto_char = texto.toCharArray();
        for (int i=0;i<texto.length();i++) {
            int x =  (int) texto_char[i] + 2;
            texto_char[i] = (char) x;
        }

        return String.valueOf(texto_char);
    }
    static String decodificador (String texto) {
        char [] texto_char = texto.toCharArray();
        for (int i=0;i<texto.length();i++) {
            int x =  (int) texto_char[i] - 2;
            texto_char[i] = (char) x;
        }

        return String.valueOf(texto_char);
    }
    static String codificador (String texto, int desplazo) {
        char [] texto_char = texto.toCharArray();
        for (int i=0;i<texto.length();i++) {
            int x =  (int) texto_char[i] + desplazo;
            texto_char[i] = (char) x;
        }

        return String.valueOf(texto_char);
    }
    static String decodificador (String texto, int desplazo) {
        char [] texto_char = texto.toCharArray();
        for (int i=0;i<texto.length();i++) {
            int x =  (int) texto_char[i] - desplazo;
            texto_char[i] = (char) x;
        }

        return String.valueOf(texto_char);
    }
    static int contador_letras (String palabra, char letra){
        int contador = 0;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                contador++;
            }
        }
        return contador;
    }
    static Integer[] ordenar_enteros(int a, int b, int c,String opcion){
        Integer[] array_int = {a,b,c};
        if ( opcion.equalsIgnoreCase("a")) {
            Arrays.sort(array_int);
            return array_int;
        } else {
            Arrays.sort(array_int, Collections.reverseOrder());
            return array_int;
        }
    }
    static Integer[] ordenar_enteros(){
        int a, b, c;
        String d;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese 3 numeros enteros:");
        a = entrada.nextInt();
        b = entrada.nextInt();
        c = entrada.nextInt();
        System.out.println("Ingrese una opcion ascendente (a) - descendente (d): ");
        d = entrada.next();

        Integer[] array_int = {a,b,c};
        if ( d.equalsIgnoreCase("a")) {
            Arrays.sort(array_int);
            return array_int;
        } else {
            Arrays.sort(array_int, Collections.reverseOrder());
            return array_int;
        }
    }
    static int suma_enteros(String ruta_archivo){
        List<Integer> lista_enteros = new ArrayList<Integer>();

        try {
            for (String x : Files.readAllLines(Paths.get(ruta_archivo))) {
                System.out.println(x);
                lista_enteros.add(Integer.parseInt(x));
            }
        }catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }

        int sum=0;
        for (int x : lista_enteros) {
            sum = sum + x;
        }
        return sum;
}
    static int suma_mult_enteros(String ruta_archivo, String a){
        List<Integer> lista_enteros = new ArrayList<Integer>();

        try {
            for (String x : Files.readAllLines(Paths.get(ruta_archivo))) {
                System.out.println(x);
                lista_enteros.add(Integer.parseInt(x));
            }
        }catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }


        if ( a.equalsIgnoreCase("s")) {
            int sum=0;
            for (int x : lista_enteros) {
                sum = sum + x;
            }
            return sum;
        } else if(a.equalsIgnoreCase("m")){
            int mult=1;
            for(int x : lista_enteros){
                mult = mult * x;
            }
            return mult;
        }
        System.out.println("parametro incorrecto");
        return 0;
    }

    static int resultado_suma (Integer[] vector, int num) {
        int suma = 0;
        for (int x : vector) {
            if (x > num) { suma += x; }
        }
        return suma;
    }
}
