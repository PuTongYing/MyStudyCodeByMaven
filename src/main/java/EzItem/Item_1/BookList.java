package Item_1;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 14:25
 * @description: 图书列表类：用于存放图书
 */
public class BookList {
    private Book[] books = new Book[10];

    private int usedSize;
    public BookList(){
        books[0] = new Book("非暴力沟通", 11.3, "小说", "皮拉尔·德拉托雷");
        books[1] = new Book("大雪将至", 14.7, "小说", "罗伯特·泽塔勒");
        books[2] = new Book("三体", 99.9, "小说", "刘慈欣");
        books[3] = new Book("卡拉马佐夫兄弟", 30.03, "小说", "陀思妥耶夫斯基");
        usedSize = 4;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getBook(int pos){
        return books[pos];
    }

    public void setBook(int pos,Book book) {
        books[pos] = book;
    }
}
