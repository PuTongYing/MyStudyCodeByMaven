package Item_1;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 14:41
 * @description: 用户类：抽象。
 *      普通用户类，管理员类豆继承于用户类。
 */
public abstract class User {
    protected String name;
    protected IOperation[] iOperations;
    public abstract int menu();
    public void doWork(int choice, BookList bookList){
        iOperations[choice].work(bookList);
    }
    public User(String name) {
        this.name = name;
    }
}
