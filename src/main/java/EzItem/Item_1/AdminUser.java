package Item_1;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:03
 * @description: 管理员类：增删改查
 *      ExitOperation：退出
 *      FindOperation：查找
 *      AddOperation：增加
 *      DisplayOperation：打印输出
 *      DelOperation：删除
*/
public class AdminUser extends User{
    public AdminUser(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DisplayOperation(),
                new DelOperation()
        };
    }

    @Override
    public int menu(){
        System.out.println("===========管理员菜单============");
        System.out.println("您好, 管理员 "+this.name+":");
        System.out.println("欢迎来到图书馆!");
        System.out.println("1. 查找图书");
        System.out.println("2. 新增图书");
        System.out.println("3. 显示图书");
        System.out.println("4. 删除图书");
        System.out.println("0. 退出系统");
        System.out.println("=================================");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

