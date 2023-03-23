import java.util.Arrays;
import java.util.Collections;

public class ordenar_num {
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
}
