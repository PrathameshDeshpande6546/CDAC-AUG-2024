public class mhs {

    public static void heapSort(int[] array) {
        int n = array.length;

       
        for (int i = n / 2 - 1; i >= 0; i--) {
            minheapify(array, n, i);
        }

        
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            minheapify(array, i, 0);
        }
    }

    private static void minheapify(int[] array, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] < array[smallest]) {
            smallest = left;
        }
        if (right < n && array[right] < array[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;

            minheapify(array, n, smallest);
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        heapSort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
