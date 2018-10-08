package lin.java.test.algorithms.algorithm.jianzhioffer;

public class IsContinues {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {9,4,3,2,5,1};
        solution.isContinuous(numbers);
    }

    public static class Solution {
        public boolean isContinuous(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return false;
            }
            int len = numbers.length;
            quickSort(numbers, 0, numbers.length - 1);
            int count0 = 0;
            int gap = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) {
                    count0++;
                }
                if (i >= 1) {
                    if (numbers[i] - numbers[i - 1] > 1) {
                        gap += numbers[i] - numbers[i - 1] - 1;
                    }
                }
            }
            return (count0 >= gap) ? true : false;
        }

        public void quickSort(int[] numbers, int start, int end) {
            if (start >= end) {
                return;
            }
            int index = partition(numbers, start,end);
            if (index != -1) {
                quickSort(numbers, start, index - 1);
                quickSort(numbers, index + 1, end);
            }
        }

        public int partition(int[] numbers, int start, int end) {
            if (start >= end) {
                return -1;
            }
            int l = start + 1;
            int r = end;
            while (l < r) {
                while (l <= r && numbers[r] >= numbers[start]) {
                    r--;
                }
                while (l <= r && numbers[l] < numbers[start]) {
                    l++;
                }
                if (l >= r) {
                    break;
                } else {
                    swap(numbers, l, r);
                    l++;
                    r--;
                }
            }
            swap(numbers, r, start);
            return r;
        }

        public void swap(int[] array, int i, int j) {
            int tem = array[i];
            array[i] = array[j];
            array[j] = tem;
        }
    }
}
