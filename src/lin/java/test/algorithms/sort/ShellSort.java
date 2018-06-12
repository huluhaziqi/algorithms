package lin.java.test.algorithms.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 0};
        new ShellSort().shellSort4(array);
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

    public void shellSort3(int[] nums) {
        int len = nums.length;
        int h = len / 2;
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                int tem = nums[i];
                int j = i - h;
                for (; j >= 0; j -= h) {
                    if (nums[j] > tem) {
                        nums[j + h] = nums[j];
                    } else break;
                }
                nums[j + h] = tem;
            }
            h /= 2;
        }
    }

    public void shellSort4(int[] nums) {
        int len = nums.length;
        int h = len / 2;
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                int tem = nums[i];
                int j = i - h;
                for (; j >= 0; j -= h) {
                    if (nums[j] > tem) {
                        nums[j + h] = nums[j];
                    } else break;
                }
                nums[j + h] = tem;
            }
            h = h / 2;
        }
    }
}
