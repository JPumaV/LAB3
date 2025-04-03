public class MergeSort {

    public static void mergeSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            mergeSort(arr, izquierda, medio);

            mergeSort(arr, medio + 1, derecha);

            merge(arr, izquierda, medio, derecha);
        }
    }

    public static void merge(int[] arr, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] izq = new int[n1];
        int[] der = new int[n2];
        System.arraycopy(arr, izquierda, izq, 0, n1);
        System.arraycopy(arr, medio + 1, der, 0, n2);

        int i = 0, j = 0, k = izquierda;
        while (i < n1 && j < n2) {
            if (izq[i] <= der[j]) {
                arr[k] = izq[i];
                i++;
            } else {
                arr[k] = der[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = izq[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = der[j];
            j++;
            k++;
        }
    }

    public static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arreglo = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.println("Arreglo original:");
        imprimirArray(arreglo);

        mergeSort(arreglo, 0, arreglo.length - 1);

        System.out.println("Arreglo ordenado:");
        imprimirArray(arreglo);
    }
}