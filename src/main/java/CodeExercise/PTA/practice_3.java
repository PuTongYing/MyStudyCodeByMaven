package CodeExercise.PTA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 13:17
 * @description: 递增有序顺序表的插入
 *      实验目的：1、掌握线性表的基本知识
 *              2、深入理解、掌握并灵活运用线性表。
 *              3、熟练掌握线性表的存储结构及主要运算的实现已知顺序表L递增有序，将X插入到线性表的适当位置上，保证线性表有序。
 *      输入格式:
 *              输入n+1行，其中前n行是n本图书的信息（书号、书名、价格），每本图书信息占一行，书号、书名、价格用空格分隔，价格之后没有空格。
 *              最后第n+1行是输入结束标志：0 0 0（空格分隔的三个0）。其中书号和书名为字符串类型，价格为浮点数类型。
 *      输出格式：
 *              总计n+1行，第1行是所创建的图书表中的图书个数，后n行是n本图书的信息（书号、书名、价格），
 *              每本图书信息占一行，书号、书名、价格用空格分隔。其中价格输出保留两位小数。
 *      输入样例：
 *              9787302257646 Data-Structure 35.00
 *              9787302164340 Operating-System 50.00
 *              9787302219972 Software-Engineer 32.00
 *              9787302203513 Database-Principles 36.00
 *              9787810827430 Discrete-Mathematics 36.00
 *              9787302257800 Data-Structure 62.00
 *              9787811234923 Compiler-Principles 62.00
 *              9787822234110 The-C-Programming-Language 38.00
 *              0 0 0
 *      输出样例：
 *              8
 *              9787302257646 Data-Structure 35.00
 *              9787302164340 Operating-System 50.00
 *              9787302219972 Software-Engineer 32.00
 *              9787302203513 Database-Principles 36.00
 *              9787810827430 Discrete-Mathematics 36.00
 *              9787302257800 Data-Structure 62.00
 *              9787811234923 Compiler-Principles 62.00
 *              9787822234110 The-C-Programming-Language 38.00
 */
public class practice_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int num = scanner.nextInt();
        list.add(num);
        Collections.sort(list);
        for (Integer integer : list){
            System.out.print(integer + ",");
        }
    }
}
