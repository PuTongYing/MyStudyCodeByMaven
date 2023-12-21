package Item_1;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:25
 * @description: 归还图书类：实现图书的归还方法（功能）
 */
public class ReturnOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("请输入你要归还的书籍:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i=0;
        for(i=0;i<bookList.getUsedSize()-1;i++){
            Book book = bookList.getBook(i);
            if(name.equals(book.getName())&& book.isBorrowed()){
                book.setBorrowed(false);
                System.out.println("归还成功!");
                return;
            }
            if(name.equals(book.getName())&& !book.isBorrowed()){
                System.out.println("此书处于未借出状态!");
                return;
            }
        }
        System.out.println("找不到你要归还的书籍!");
    }
}

