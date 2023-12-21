package main.DataStructure.Recursive;

/**
 * @Author: 小蔡
 * @Date: 2023/12/11 22:48
 * @description: 递归-反向打印字符串
 */
public class Recursive_ReversePrintString {
    public static void f(int n, String str){
        if (n == str.length()){
            return;
        }
        f(n+1, str);
        System.out.print(str.charAt(n));
    }

    public static void main(String[] args) {
        f(0, "abcd");
    }
}
