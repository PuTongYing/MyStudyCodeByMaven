package main.DataStructure.BinarySearch;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 小蔡
 * @Date: 2023/12/9 23:51
 * @description: 二分查找
 */
public class BinarySearch {
    // ----------线性查找----------
    public static int linearSearch(int[] a, int target){
        for (int i = 0; i < a.length; i++) {
            if(a[i] == target){
                return i;
            }
        }
        return -1;  // 返回-1表示不存在目标值
    }

    // ----------二分查找基础版----------
    /**
     * i, j, m 指针都可能是查找目标
     * 因为 1. i > j 时表示区域内没有要找的了
     * 每次改变 i, j 边界时, m 已经比较过不是目标, 因此分别 m+1 m-1
     * 向左查找, 比较次数少, 向右查找, 比较次数多
     */
    public static int binarySearchBasic(int[] a, int target){
        int i = 0, j = a.length - 1;    // 设置指针和初始值
        // L 次  元素在最左边 L 次,元素在最右边 2*L 次
        while (i <= j){
            int m = (i+j)/2;
            if(target < a[m]){          // 目标在左边
                j = m-1;
            }else if(target > a[m]){    // 目标在右边
                i = m+1;
            }else{                      // 找到了
                return m;               // 返回目标值所在位置
            }
        }
        return -1;
    }

    @Test
    @DisplayName("测试binarySearchBasic")
    public void testBinarySearchBasic(){
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBasic(a, 7));
        assertEquals(1, binarySearchBasic(a, 13));
        assertEquals(2, binarySearchBasic(a, 21));
        assertEquals(3, binarySearchBasic(a, 30));
        assertEquals(4, binarySearchBasic(a, 38));
        assertEquals(5, binarySearchBasic(a, 44));
        assertEquals(6, binarySearchBasic(a, 52));
        assertEquals(7, binarySearchBasic(a, 53));

        assertEquals(-1, binarySearchBasic(a, 0));
        assertEquals(-1, binarySearchBasic(a, 15));
        assertEquals(-1, binarySearchBasic(a, 60));
    }
    // ----------二分查找基础版结束----------

    // ----------测试右移运算----------
    @Test
    @DisplayName("测试右移运算")
    public void testRightShift(){
        int i = 0;
        int j = Integer.MAX_VALUE - 1;
        // 模拟第一次求中间索引
        int m = (i+j) / 2;
        // 模拟第二次求中间索引， target在右侧
        i = m + 1;
        assertEquals(1073741824, i);
        assertEquals(2147483646, j);
        assertEquals(-1073741826, i + j);
        m = (i + j) / 2;    // 有问题的情况
        assertEquals(-536870913, m);
        m = (i + j) >>> 1;  // 改正后的情况
        assertEquals(1610612735, m);
        /*
        结论：同一个二进制
        1011_1111_1111_1111_1111_1111_1111_1110
        不把最高位视为符号位，代表 3221225470
        把最高位视为符号位,代表 -1073741826
         */
    }

    /**
     * 问题1: 为什么是 i<=j 意味着区间内有未比较的元素, 而不是 i<j ?
     *      i==j 意味着 i,j 它们指向的元素也会参与比较
     *      i<j 只意味着 m 指向的元素参与比较
     * 问题2: (i + j) / 2 有没有问题?
     * 问题3: 都写成小于号有啥好处?
     */

    // ----------二分查找改动版----------

    /**
     * i, m 指针可能是查找目标
     * j 指针不可能是查找目标
     * 因为 1. 2. i >= j 时表示区域内没有要找的了
     * 改变 i 边界时, m 已经比较过不是目标, 因此需要 i=m+1
     * 改变 j 边界时, m 已经比较过不是目标, 同时因为 2. 所以 j=m
     */
    public static int binarySearchAlternative(int[] a, int target){
        int i = 0, j = a.length;
        while (i < j){          // 此处不能添加=号，当i=j时，出现不存在的元素时会陷入死循环
            int m = (i+j) >>> 1;
            if(target < a[m]){
                j = m;          // j作为边界
            }else if(target > a[m]){
                i = m+1;
            }else{
                return m;  // 返回目标值所在位置
            }
        }
        return -1;
    }

    @Test
    @DisplayName("测试binarySearchAlternative")
    public void testBinarySearchAlternative(){
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchAlternative(a, 7));
        assertEquals(1, binarySearchAlternative(a, 13));
        assertEquals(2, binarySearchAlternative(a, 21));
        assertEquals(3, binarySearchAlternative(a, 30));
        assertEquals(4, binarySearchAlternative(a, 38));
        assertEquals(5, binarySearchAlternative(a, 44));
        assertEquals(6, binarySearchAlternative(a, 52));
        assertEquals(7, binarySearchAlternative(a, 53));

        assertEquals(-1, binarySearchAlternative(a, 0));
        assertEquals(-1, binarySearchAlternative(a, 15));
        assertEquals(-1, binarySearchAlternative(a, 60));
    }
    // ----------二分查找改动版结束----------

    // ----------二分查找平衡版----------

    /**
     * 不奢望循环内通过 m 找出目标, 缩小区间直至剩 1 个, 剩下的这个可能就是要找的(通过 i)
     * i 指针可能是查找目标
     * j 指针不可能是查找目标
     * 因为 1. 2. 3. 当区域内还剩一个元素时, 表示为 j - i == 1
     * 改变 i 边界时, m 可能就是目标, 同时因为 2. 所以有 i=m
     * 改变 j 边界时, m 已经比较过不是目标, 同时因为 3. 所以有 j=m
     * 三分支改为二分支, 循环内比较次数减少
     */
    public static int binarySearchBalance(int[] a, int target){
        int i = 0, j = a.length;
        while (j - i > 1){              // 范围内待查找的元素个数 > 1时
            int m = (i + j) >>> 1;
            if(target < a[m]){          // 目标在左边
                j = m;
            }else{                      // 目标在m或者右边
                i = m;
            }
        }
        if(a[i] == target){
            return i;
        }else{
            return -1;
        }
//        return a[i] == target ? i : -1;  // 三元运算符
    }

    @Test
    @DisplayName("测试binarySearchBalance")
    public void testBinarySearchBalance(){
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBalance(a, 7));
        assertEquals(1, binarySearchBalance(a, 13));
        assertEquals(2, binarySearchBalance(a, 21));
        assertEquals(3, binarySearchBalance(a, 30));
        assertEquals(4, binarySearchBalance(a, 38));
        assertEquals(5, binarySearchBalance(a, 44));
        assertEquals(6, binarySearchBalance(a, 52));
        assertEquals(7, binarySearchBalance(a, 53));

        assertEquals(-1, binarySearchBalance(a, 0));
        assertEquals(-1, binarySearchBalance(a, 15));
        assertEquals(-1, binarySearchBalance(a, 60));
    }
    // ----------二分查找平衡版结束----------

    // ----------二分查找Java版----------
    public static int binarySearch_Java(int[] a, int fromIndex, int toIndex, int key){
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high){
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            if(midVal < key){
                low = mid + 1;
            }else if(midVal > key){
                high = mid - 1;
            }else{
                return mid;     // 找到了
            }
        }
        return -(low + 1);      // 返回-1表示不存在目标值
    }

    @Test
    @DisplayName("二分查找Java测试")
    public void testBinarySearch_Java(){
        int[] a = {2, 5, 8};
        int target =4;
        int i = Arrays.binarySearch(a, target);
        assertTrue(i < 0);
        int inserIndex = Math.abs(i + 1);
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, inserIndex);
        b[inserIndex] = target;
        System.arraycopy(a, inserIndex, b, inserIndex + 1, a.length - inserIndex);
        assertArrayEquals(new int[]{2, 4, 5, 8}, b);
    }
    // ----------二分查找Java版结束----------

    // ----------二分查找 Leftmost(返回-1)----------
    public static int binarySearchLeftmost_1(int[] a, int target){
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j){
            int m = (i+j) >>> 1;
            if(target < a[m]){
                j = m - 1;
            }else if(target > a[m]){
                i = m + 1;
            }else{
                // 记录候选位置
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    @Test
    @DisplayName("测试binarySearchLeftmost_1")
    public void testBinarySearchLeftmost_1(){
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchLeftmost_1(a, 1));
        assertEquals(1, binarySearchLeftmost_1(a, 2));
        assertEquals(2, binarySearchLeftmost_1(a, 4));
        assertEquals(5, binarySearchLeftmost_1(a, 5));
        assertEquals(6, binarySearchLeftmost_1(a, 6));
        assertEquals(7, binarySearchLeftmost_1(a, 7));

        assertEquals(-1, binarySearchLeftmost_1(a, 0));
        assertEquals(-1, binarySearchLeftmost_1(a, 3));
        assertEquals(-1, binarySearchLeftmost_1(a, 8));
    }
    // ----------二分查找Leftmost结束----------

    // ----------二分查找Leftmost(返回i)----------
    public static int binarySearchLeftmost_2(int[] a, int target){
        int i = 0, j = a.length - 1;
        while (i <= j){
            int m = (i+j) >>> 1;
            if(target < a[m]){
                j = m - 1;
            }else{
                i = m + 1;
            }
        }
        return i - 1;
    }

    @Test
    @DisplayName("测试binarySearchLeftmost_2")
    public void testBinarySearchLeftmost_2(){
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchLeftmost_2(a, 1));
        assertEquals(1, binarySearchLeftmost_2(a, 2));
        assertEquals(4, binarySearchLeftmost_2(a, 4));
        assertEquals(5, binarySearchLeftmost_2(a, 5));
        assertEquals(6, binarySearchLeftmost_2(a, 6));
        assertEquals(7, binarySearchLeftmost_2(a, 7));

        assertEquals(-1, binarySearchLeftmost_2(a, 0));
        assertEquals(1, binarySearchLeftmost_2(a, 3));
        assertEquals(7, binarySearchLeftmost_2(a, 8));
    }

    // ----------二分查找Leftmost结束----------

    // ----------二分查找Rightmost(返回-1)----------
    public static int binarySearchRightmost_1(int[] a, int target){
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j){
            int m = (i+j) >>> 1;
            if(target < a[m]){
                j = m - 1;
            }else if(target > a[m]){
                i = m + 1;
            }else{
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    @Test
    @DisplayName("测试binarySearchRightmost_1")
    public void testBinarySearchRightmost_1(){
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchRightmost_1(a, 1));
        assertEquals(1, binarySearchRightmost_1(a, 2));
        assertEquals(4, binarySearchRightmost_1(a, 4));
        assertEquals(5, binarySearchRightmost_1(a, 5));
        assertEquals(6, binarySearchRightmost_1(a, 6));
        assertEquals(7, binarySearchRightmost_1(a, 7));

        assertEquals(-1, binarySearchRightmost_1(a, 0));
        assertEquals(-1, binarySearchRightmost_1(a, 3));
        assertEquals(-1, binarySearchRightmost_1(a, 8));
    }
    // ----------二分查找Rightmost结束----------

    // ----------二分查找Rightmost(返回i-1)----------
    public static int binarySearchRightmost_2(int[] a, int target){
        int i = 0, j = a.length - 1;
        while (i <= j){
            int m = (i+j) >>> 1;
            if(target < a[m]){
                j = m - 1;
            }else{
                i = m + 1;
            }
        }
        return i - 1;
    }
}
