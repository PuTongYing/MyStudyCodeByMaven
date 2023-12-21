package main.DataStructure.Recursive;

/**
 * @Author: 小蔡
 * @Date: 2023/12/11 22:40
 * @description: 递归-阶乘
 */
public class Recursive_Factorial {
    public static int f(int n){
        if (n == 1){
            return 1;
        } else {
            return n * f(n-1);
        }
    }

    public static void main(String[] args) {
        int f = f(5);
        System.out.println(f);
    }
}
