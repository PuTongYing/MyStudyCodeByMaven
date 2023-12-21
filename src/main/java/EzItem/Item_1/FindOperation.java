package Item_1;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:25
 * @description: 查找图书类：实现查找图书方法
 */
public class FindOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("请输入书名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for(int i=0;i<bookList.getUsedSize();i++){
            Book book = bookList.getBook(i);
            if(name.equals(book.getName())){
                System.out.println(book);
                return;
            }
        }
        System.out.println("找不到 《"+name+"》 这本书");
    }
}

