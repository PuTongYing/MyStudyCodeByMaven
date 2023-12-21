package Item_1;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:26
 * @description: 删除图书类：删除图书方法
 */
public class DelOperation implements IOperation{
    public void work(BookList bookList) {
        System.out.println("请输入要删除的书名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i,index=0;
        for(i=0;i<bookList.getUsedSize();i++){
            Book book = bookList.getBook(i);
            if(name.equals(book.getName())){
                index = i;
                break;
            }
        }
        if(i>=bookList.getUsedSize()) {
            System.out.println("找不到这本书");
            return;
        }
        for (int j = index;j< bookList.getUsedSize()-1;j++){
            Book book = bookList.getBook(j+1);
            bookList.setBook(j,book);
        }
        bookList.setBook(bookList.getUsedSize()-1, null);
        bookList.setUsedSize(bookList.getUsedSize()-1);
        System.out.println("删除成功!");
    }
}

