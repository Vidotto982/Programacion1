import java.util.Arrays;

public class ArrEze3 {
    public static void main(String[] Args) {
        int n = 3;
        int arr[] = {1, 2, 3, 2 , 4, 8, 8, 9, 1, 2, 3, 5};

        try {
            buscarSecuen(arr, n);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void buscarSecuen(int[] arr, int n) {
        boolean posIni = false;
        int cantSec = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if ((arr[i] - arr[i - 1]) == 1 && !posIni) {
                posIni = true;
                arr[i] = 0;

            } else if (posIni){
                if ((arr[i] - arr[i - 1]) != 1){
                    posIni = false;
                    cantSec++;
                }
                arr[i] = 0;
                if (cantSec == n) {

                    return;

                }
            }
            if (posIni && i == 1) {
                arr[i - 1] = 0;
            }

        }
        mostrarArr(arr);
    }
    private static void mostrarArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

        }
        System.out.println(Arrays.toString(arr));
    }
}

