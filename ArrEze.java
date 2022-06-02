import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class ArrEze {

    //Encxontrar secuencias de nnumeros cosnecutivos Imprimir por secuencias
    // Reemplazar la primer sec por la ultima sec por el tam de la primera
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 0, 8, 9, 6, 7, 8, 9, 7,8};
        //          {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        try {
            mostrarArr(arr);
            buscarSecuencias(arr);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void buscarSecuencias(int[] arr) {
        int posInicial = 0;
        int posFinal;
        int cantSec = 0;
        int posInicialPrimerSecuencia = 0;
        int posFinalPrimerSecuencia = 0;
        int ultimaPosInicial = 0;
        int ultimaPosFinal = 0;
        boolean posIni = false;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] > 0 && !posIni) {
                posInicial = i;
                System.out.println("inicio" + " " + i);
                posIni = true;
            } else if (arr[i] - arr[i-1] == 1 && posIni) {
                if (i - posInicial + 1 >= 2) {
                    posFinal = i;
                    posIni = false;
                    cantSec++;
                    if (cantSec == 1) {
                        posInicialPrimerSecuencia = posInicial;
                        System.out.println("Inicio primer secuencia" + " " + posInicialPrimerSecuencia);
                        posFinalPrimerSecuencia = posFinal;
                        System.out.println("fin primer secuencia" + " " + posFinalPrimerSecuencia);
                    }

                    if (posFinal > ultimaPosFinal) {
                        ultimaPosInicial = posInicial;
                        ultimaPosFinal = posFinal;
                        System.out.println("fin ultima secuencia" + " " + ultimaPosFinal);
                    }

                }
            }
        }
        DesplazarSec(arr, ultimaPosInicial, ultimaPosFinal, posInicialPrimerSecuencia, posFinalPrimerSecuencia);
        System.out.println("Cantiddad de secuencias" + " " + cantSec);
    }

    private static void DesplazarSec(int[] arr, int ultimaPosInicial, int ultimaPosFinal, int posInicialPrimerSecuencia, int posFinalPrimerSecuencia) {
        for (int i = posInicialPrimerSecuencia; i <= posFinalPrimerSecuencia && i <= ultimaPosFinal; i++) {
            arr[i] = arr[i + ultimaPosInicial];
        }
        System.out.println("Arreglo terminado");
        mostrarArr(arr);

    }

    private static void mostrarArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

        }
        System.out.println(Arrays.toString(arr));
        ;
    }


}