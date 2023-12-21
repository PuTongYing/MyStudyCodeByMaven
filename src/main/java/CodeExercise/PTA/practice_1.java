package CodeExercise.PTA;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/11/29 20:47
 * @description: 数组循环左移
 *      本题要求实现一个对数组进行循环左移的简单函数：一个数组a中存有 n(>0) 个函数，在不允许使用另外数组的前提下，将每个整数循环向左移 m(>0)个位置，即将a中的数据由(a0a1···a(n-1))变换为
 *      (am···a(n-1)a0a1···a(m-1))  （最前面的m个数循环移至最后面的m个位置）。如果还需要考虑程序移动的次数尽量少，要如何设计移动的方法？
 * 输入格式：
 *      输入第1行给出正整数n（<=100)和整数m(>=0);
 *      输入第2行给出n个整数，其间以空格分隔。
 * 输出格式：
 *      在一行中输出循环左移m位以后的整数序列，之间用空格分隔，序列结尾不能有多余空格。
 * 输入样例：
 *      8 3
 *      1 2 3 4 5 6 7 8
 * 输出样例：
 *      4 5 6 7 8 1 2 3
 */
public class practice_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            list.add(k);
        }
        int k = m % n;
        for (int i = k; i < n; i++) {
            if (i == k){
                System.out.print(list.get(i));
            }else {
                System.out.print(" " + list.get(i));
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(" " + list.get(i));
        }
    }
}
