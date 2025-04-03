public class MergeSortOptimizado {

    public static void mergeSort(int[] arr, int[] aux, int izquierda, int derecha) {
        if (izquierda >= derecha)
            return;

        int medio = izquierda + (derecha - izquierda) / 2;

        mergeSort(arr, aux, izquierda, medio);
        mergeSort(arr, aux, medio + 1, derecha);
        merge(arr, aux, izquierda, medio, derecha);
    }

    public static void merge(int[] arr, int[] aux, int izquierda, int medio, int derecha) {
        System.arraycopy(arr, izquierda, aux, izquierda, derecha - izquierda + 1);

        int i = izquierda, j = medio + 1, k = izquierda;
        while (i <= medio && j <= derecha) {
            if (aux[i] <= aux[j]) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            arr[k] = aux[i];
            i++;
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
        int[] aux = new int[arreglo.length];

        System.out.println("Arreglo original:");
        imprimirArray(arreglo);

        mergeSort(arreglo, aux, 0, arreglo.length - 1);

        System.out.println("Arreglo ordenado:");
        imprimirArray(arreglo);
    }
}