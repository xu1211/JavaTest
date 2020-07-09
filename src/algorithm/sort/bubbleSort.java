package algorithm.sort;

/**
 * 冒泡排序
 * 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
 * 平均时间复杂度 O（n²）
 */
public class bubbleSort {
    public static int[] bubbleSort(int[] arr) {
        // 总共要经过 arr.length - 1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            // 选出该轮排序的最大值往后移动，每轮会把目前最大的一个数沉在底
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
