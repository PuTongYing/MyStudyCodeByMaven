package Item_1;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:31
 * @description: 创建打印图书方法：展示已有图书
 */
public class DisplayOperation implements IOperation{
    public void work(BookList bookList){
        int usedSize = bookList.getUsedSize();
        for (int i=0;i<usedSize;i++){
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}

