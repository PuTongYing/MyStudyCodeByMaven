package main.DataStructure.Recursive;

/**
 * @Author: 小蔡
 * @Date: 2023/12/13 19:26
 * @description: 递归-求和（ n + (n+1) + ··· + 1）
 */
public class Recursive_Sum {
//    // f(n) = f(n-1) + n
//    public static long sum(long n) {
//        if (n == 1) {
//            return 1;
//        }
//        return n + sum(n - 1);
//    }

    // Java不支持尾递归自动优化
//    public static void main(String[] args) {
//        System.out.println(sum(50));
//        // 15000爆栈
////        System.out.println(sum(15000));
//    }

    /*
    long sum(long n = 15000) {
        return 15000 + long sum(long n = 14999) {
            return 14999 + sum(14998) {
                ...
                return 2 + long sum(long n = 1) {
                    if (n == 1) {
                        return 1;
                    }
                }
            }
        };
    }
     */

    // 递归爆栈代码--->循环代码
    public static void main(String[] args) {
        long n = 100000;
        long sum = 0;
        for (long i = n; i >= 1; i--){
            sum += i;
        }
        System.out.println(sum);
    }

}
