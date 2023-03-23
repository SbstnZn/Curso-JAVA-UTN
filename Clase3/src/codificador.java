public class codificador {
    static String codificacion (String texto) {
        char [] texto_char = texto.toCharArray();
        for (int i=0;i<texto.length();i++) {
            int x =  (int) texto_char[i] + 2;
            texto_char[i] = (char) x;
        }

        return String.valueOf(texto_char);
    }

    static String decodificacion (String texto) {
        char [] texto_char = texto.toCharArray();
        for (int i=0;i<texto.length();i++) {
            int x =  (int) texto_char[i] - 2;
            texto_char[i] = (char) x;
        }

        return String.valueOf(texto_char);
    }
}
