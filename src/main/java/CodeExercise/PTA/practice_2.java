package CodeExercise.PTA;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/11/30 18:18
 * @description: 最长连续递增子序列
 *      给定一个顺序存储的线性表，请设计一个算法查找该线性表中最长的连续递增子序列。例如，(1,9,2,5,7,3,4,6,8,0)中最长的递增子序列为(3,4,6,8)。
 * 输入格式：
 *      输入第1行给出正整数n（≤10⁵);第2行给出n个整数，其间以空格分隔。
 * 输出格式：
 *      在一行中输出第一次出现的最长连续递增子序列，数字之间用空格分隔，序列结尾不能有多余空格。
 * 输入样例：
 *      15
 *      1 9 2 5 7 3 4 6 8 0 11 15 17 17 10
 * 输出样例：
 *      3 4 6 8
 */
public class practice_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j, n, max = 1, num = 1;
        n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b[0] = a[0];
        for (i = 0; i < n - 1; i++) {
            if (a[i + 1] > a[i]) {
                num++;
                if (num > max) {
                    max = num;
                    for (j = 0; j < max; j++) {
                        b[j] = a[i - j + 1];
                    }
                }
            } else {
                num = 1;
            }
        }
        for (i = max - 1; i > 0; i--) {
            System.out.print(b[i] + " ");
        }
        System.out.print(b[0]);
    }
}
