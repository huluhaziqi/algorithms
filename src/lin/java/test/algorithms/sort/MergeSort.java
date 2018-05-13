package lin.java.test.algorithms.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 7, 2, 1, 67, 8, 3, 4, 5, 0};
        new MergeSort().mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void merge(int[] array, int start, int mid, int end) {
        int[] tem = new int[end - start + 1];
        int j = mid + 1;
        int i = start;
        int p = 0;
        while (i <= mid && j <= end) {
            tem[p++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            tem[p++] = array[i++];
        }
        while (j <= end) {
            tem[p++] = array[j++];
        }
        for(int k = 0; k < tem.length; k++){
            array[k + start] = tem[k];
        }
    }

    public void mergeSort(int[] array, int start, int end) {
        if (array == null || array.length <= 1 || end <= start) {
            return;
        }
            int mid = (end + start) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
    }
}
