package Item_1;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 14:18
 * @description: Book类：包含图书的名称，价格，类型，作者以及是否被借出
 */
public class Book {
    private String name;
    private double price;
    private String type;
    private String author;
    private boolean isBorrowed;

    public Book(String name, double price, String type, String author){
        this.name = name;
        this.price = price;
        this.type = type;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", isBorrowed=" + ((isBorrowed) ?"已借出":"未借出") +
                '}';
    }
}
