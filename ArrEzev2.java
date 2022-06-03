//
public class ArrEzev2 {
    public static void main(String[] Args) {
        int n = 8;
        int m = 3;
        int arr[] = {0, 0 ,0, 1, 1, 1, 0, 2, 2, 2,0,3,4,5,0, 9};

        try {

            buscarSecuencia(arr, m, n);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void buscarSecuencia(int[] arr, int m, int n) {
        boolean posIni = false;
        int posIncial = 0;
        int posFinal = 0;
        int cantSec = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && !posIni) {
                posIncial = i;
                posIni = true;
            } else if (arr[i] != 0 && arr[i+1]==0 && posIni) {
                posFinal = i+1;
                posIni = false;
                if (posFinal - (posIncial) == m) {
                    cantSec++;
                    if (cantSec == n) {
                        System.out.println("cantidad de secuencia" + "" + cantSec);
                    }
                }


            }
        }
    }

}
