public class suma_numeros {
    static int resultado_suma (Integer[] vector, int num) {
        int suma = 0;
        for (int x : vector) {
            if (x > num) { suma += x; }
        }
        return suma;
    }
}
