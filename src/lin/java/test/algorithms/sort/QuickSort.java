package lin.java.test.algorithms.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {4,1,1,2};
        new QuickSort().quickSort2(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void quickSort(int[] array, int start, int end) {
        if (array == null || array.length <= 1) {
            return;
        }
        int tag = partion(array, start, end);
        if (tag == -1) {
            return;
        }
        quickSort(array, start, tag - 1);
        quickSort(array, tag, end);

    }

    public int partion(int[] array, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int tem = array[mid];
        int left = start;
        int right = end;
        while (left <= right) {
            while (right >= left && array[right] > tem) {
                right--;
            }
            while (left <= right && array[left] < tem) {
                left++;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }


    public void quickSort2(int[] array, int start, int end) {
        if (array == null || array.length == 0 || start >= end) {
            return;
        }
        int tag = partion2(array, start, end);
        quickSort(array, 0, tag - 1);
        quickSort(array, tag, end);

    }

    public int partion2(int[] array, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int left = start + 1;
        int right = end;
        int tem = array[start];
        while (left <= right) {
            while (right >= left && array[right] > tem) {
                right--;
            }
            while (left <= right && array[left] < tem) {
                left++;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void quickSort4(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partion3(array, start, end);
        if(index != -1) {
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    public int partion3(int[] array, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int l = start + 1;
        int r = end;
        while (l <= r) {
            while (l <= r && array[r] >= array[start]) {
                r--;
            }
            while (l <= r && array[l] <= array[start]) {
                l++;
            }
            if (l < r) {
                swap(array, r, l);
                l++;
                r--;
            }
        }
        swap(array, start, r);
        return r;
    }

}
