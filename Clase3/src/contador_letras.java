public class contador_letras {
    static int cant_letras (String palabra, char letra){
        int contador = 0;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                contador++;
            }
        }
        return contador;
    }
}
