package main.DataStructure.Recursive;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: 小蔡
 * @Date: 2023/12/11 23:05
 * @description: 递归-二分查找
 */
public class Recursive_BinarySearch {
    public static int search(int[] a, int target){
        return f(a, target, 0, a.length-1);
    }

    // a-数组， target-待查找值， i-起始索引（包含）, j-结束索引（包含）
    private static int f(int[] a, int target, int i, int j){
        if (i > j){
            return -1;
        }
        int m = (i + j) >>> 1;
        if (target < a[m]){
            return f(a, target, i, m-1);
        } else if (a[m] < target) {
            return f(a, target, m+1, j);
        } else {
            return m;
        }
    }

    @Test
    @DisplayName("测试递归-二分查找")
    public void test(){
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, search(a, 7));
        assertEquals(1, search(a, 13));
        assertEquals(2, search(a, 21));
        assertEquals(3, search(a, 30));
        assertEquals(4, search(a, 38));
        assertEquals(5, search(a, 44));
        assertEquals(6, search(a, 52));
        assertEquals(7, search(a, 53));

        assertEquals(-1, search(a, 0));
        assertEquals(-1, search(a, 15));
        assertEquals(-1, search(a, 60));
    }
}
