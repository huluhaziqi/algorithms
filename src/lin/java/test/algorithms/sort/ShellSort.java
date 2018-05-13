package lin.java.test.algorithms.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {3,4,1,0};
        new ShellSort().shellSort2(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void shellSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int gap = len / 2;
        while (gap >= 1) {
            for (int i = gap; i < len; i++) {
                int tem = array[i];
                int j = i - gap;
                for (; j >= 0; j = j - gap) {
                    if (array[j] > tem) {
                        array[j + gap] = array[j];
                    } else break;
                }
                array[j + gap] = tem;
            }
            gap /= 2;
        }
    }

    public void shellSort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int gap = len / 2;
        while (gap >= 1) {
            for (int i = gap; i < len; i++) {
                int tem = array[i];
                int j;
                for (j = i - gap; j >= 0 && array[j] > tem; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = tem;
            }
            gap /= 2;
        }
    }
}
