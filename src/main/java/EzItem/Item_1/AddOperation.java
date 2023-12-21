package Item_1;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:24
 * @description: 添加图书类：实现添加图书方法
 */
public class AddOperation implements IOperation{
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书名称:");
        String name = scanner.nextLine();
        System.out.println("请输入价格:");
        double price = scanner.nextDouble();
        System.out.println("请输入类型:");
        String type = scanner.next();
        System.out.println("请输入作者:");
        String author = scanner.next();
        Book book = new Book(name,price,type,author);
        int usedSize = bookList.getUsedSize();
        bookList.setBook(usedSize,book);
        bookList.setUsedSize(++usedSize);
        System.out.println("添加图书成功!");
    }
}

