package main.DataStructure.MultiRecursive;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: 小蔡
 * @Date: 2023/12/15 21:29
 * @description: Memoization（记忆法，也称作备忘录法）
 *      时间复杂度->O(n)
 */
public class MultiRecursive_Fibonacci_op {
    public static int fibonacci(int n){
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);     // [-1,-1,-1,-1,-1,-1]
        cache[0] = 0;
        cache[1] = 1;                   // [0,1,-1,-1,-1,-1]
        return f(n, cache);
    }

    public static int f(int n, int[] cache){
        if (cache[n] != -1) {
            return cache[n];
        }
        int x = f(n-1, cache);
        int y = f(n-2, cache);
        cache[x] = x + y;
        return cache[n];
    }

    @Test
    public void test1() {
        assertEquals(1, fibonacci(2));
        assertEquals(2, fibonacci(3));
        assertEquals(3, fibonacci(4));
        assertEquals(5, fibonacci(5));
        assertEquals(8, fibonacci(6));
        assertEquals(13, fibonacci(7));
        assertEquals(21, fibonacci(8));
        assertEquals(34, fibonacci(9));
        assertEquals(55, fibonacci(10));
        assertEquals(89, fibonacci(11));
        assertEquals(144, fibonacci(12));
        assertEquals(233, fibonacci(13));
    }
}
