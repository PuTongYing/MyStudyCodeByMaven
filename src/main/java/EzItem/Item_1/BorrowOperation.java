package Item_1;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:25
 * @description: 借阅图书类：借阅图书，检查图书是否被借走
 */
public class BorrowOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("请输入你要借阅的书籍:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        // 输出的书名在BookList当中
        for (int i = 0; i < bookList.getUsedSize() - 1; i++) {
            Book book = bookList.getBook(i);
            if (name.equals(book.getName()) && !book.isBorrowed()) {
                book.setBorrowed(true);
                System.out.println("借阅成功!");
                return;
            }
            if (name.equals(book.getName()) && book.isBorrowed()) {
                System.out.println("该书籍已被借出");
                return;
            }
        }
        // 输入的书名没有找到
        System.out.println("找不到你要借阅的书籍!");
    }
}

