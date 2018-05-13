package lin.java.test.algorithms.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 7, 2, 1, 67, 8, 3, 4, 5, 0};
        new BubbleSort().bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }
}
