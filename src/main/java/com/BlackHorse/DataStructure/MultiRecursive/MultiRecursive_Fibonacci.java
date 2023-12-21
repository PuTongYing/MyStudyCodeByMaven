package main.DataStructure.MultiRecursive;

/**
 * @Author: 小蔡
 * @Date: 2023/12/12 22:37
 * @description: 多路递归-斐波那契数列
 */
public class MultiRecursive_Fibonacci {
    // 递归次数（也是斐波那契数列）=》 2*f(n+1)-1;
    // 时间复杂度 O（0.618）ⁿ
    public static int f(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int x = f(n-1);
        int y = f(n-2);
        return x + y;
    }

    public static void main(String[] args) {
        int f = f(8);
        System.out.println(f);
    }
}
