package algorithm.sort;

/**
 * 选择排序
 * 基本思想：在长度为N的无序数组中，遍历n-1个数，找到最小的数值与第一个元素交换；递归
 * 平均时间复杂度 O（n²）
 */
public class selctionSort {
    public static int[] selctionSort(int[] arr) {
        // 总共要经过 arr.length - 1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
