package main.DataStructure.Recursive;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @Author: 小蔡
 * @Date: 2023/12/12 21:46
 * @description: 递归-冒泡排序
 *      将数组划分成两部分 [0 .. j] [j+1 .. a.length-1]
 *      左边 [0 .. j] 是未排序部分
 *      右边 [j+1 .. a.length-1] 是已排序部分
 *      未排序区间内, 相邻的两个元素比较, 如果前一个大于后一个, 则交换位置
 */
public class Recursive_BubbleSort {
    public static void sort(int[] a){
        bubble(a, a.length-1);
    }

    private static void bubble(int[] a, int j){
        if (j == 0){
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]){
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
        }
        bubble(a, x);
    }

    @Test
    @DisplayName("测试递归冒泡")
    public void test1() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] a1 = {5, 4, 3, 2, 1};
        sort(a1);
        assertArrayEquals(expected, a1);

        int[] a2 = {4, 5, 3, 2, 1};
        sort(a2);
        assertArrayEquals(expected, a2);

        int[] a4 = {3, 1, 4, 2, 5};
        sort(a4);
        assertArrayEquals(expected, a4);

        int[] a3 = {1, 2, 3, 4, 5};
        sort(a3);
        assertArrayEquals(expected, a3);
    }

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        System.out.println(Arrays.toString(a));
        bubble(a, a.length-1);
        System.out.println(Arrays.toString(a));
    }

}
