package Item_1;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:31
 * @description: 图书管理系统
 */
public class Main {
    public static User work(){
        System.out.println("请输入您的姓名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入身份: 1-> 管理员登录  0-> 用户登录");
        int choice = scanner.nextInt();
        if(choice==1){
            return new AdminUser(name);
        }
        return new NormalUser(name);
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = work();
        try {
            while (true) {
                int choice = user.menu();
                user.doWork(choice, bookList);
            }
        }catch (Exception e){
            System.out.println("抛出异常情况" + e);
        }
    }
}

