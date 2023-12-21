package Item_1;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:24
 * @description: 普通用户类
 *      ExitOperation：退出
 *      DisplayOperation：打印输出
 *      FindOperation：查找
 *      BorrowOperation：查询图书是否被接出
 *      ReturnOperation：归还图书
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new ExitOperation(),
                new DisplayOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
        };
    }

    @Override
    public int menu(){
        System.out.println("===========普通用户菜单============");
        System.out.println("您好，用户 "+this.name+":");
        System.out.println("欢迎来到图书馆!");
        System.out.println("1. 显示图书");
        System.out.println("2. 查找图书");
        System.out.println("3. 借阅图书");
        System.out.println("4. 归还图书");
        System.out.println("0. 退出系统");
        System.out.println("=================================");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}

