package com.huluhaziqi.algorithms.algorithms.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {1,2,54,2,232,65,7,8,23,4,70};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort2(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public void heapSort(int[] array) {
        //构建堆
        BuildMaxHeap(array);
        //
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            swap(array, 0, i);
            MaxHeapify(array, 0, i);
            System.out.println("sort " + array[i]);
        }
    }

    public void BuildMaxHeap(int[] array) {
        int len = array.length;
        for (int i = len / 2; i >= 0; i--) {
            MaxHeapify(array, i, array.length);
        }
    }

    public void MaxHeapify(int[] array, int x, int end) {
        int tem = x;
        while (tem < end) {
            int lChild = 2 * tem + 1;
            int rChild = 2 * tem + 2;

            int maxIndex = tem;
            if (lChild < end && array[lChild] > array[maxIndex]) {
                maxIndex = lChild;
            }
            if (rChild < end && array[rChild] > array[maxIndex]) {
                maxIndex = rChild;
            }
            if (maxIndex != tem) {
                swap(array, maxIndex, tem);
            } else {
                return;
            }
            tem = maxIndex;
        }
    }

    public void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    public void MinHeapify(int[] array, int x, int end) {
        int parent = x;
        while (parent < end) {
            int lchild = parent * 2 + 1;
            int rchild = parent * 2 + 2;
            int minIndex = parent;
            while (lchild < end && array[lchild] < array[minIndex]) {
                minIndex = lchild;
            }
            while (rchild < end && array[rchild] < array[minIndex]) {
                minIndex = rchild;
            }
            if (minIndex != parent) {
                swap(array, parent, minIndex);
                parent = minIndex;
            } else {
                return;
            }
        }
    }

    public void BuildMinHeap(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = len / 2; i >= 0; i--) {
            MinHeapify(array, i, len);
        }
    }

    public void heapSort2(int[] array) {
        //构建堆
        BuildMinHeap(array);
        int len = array.length;
        for(int i = len - 1; i >= 0; i--){
            swap(array,0,i);
            MinHeapify(array,0,i);
        }
    }

    void max_heapify(int[] array){
        if(array == null){

        }
    }

}
