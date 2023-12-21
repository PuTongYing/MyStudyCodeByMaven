package Item_1;

/**
 * @Author: 小蔡
 * @Date: 2023/12/6 15:31
 * @description: 退出系统类：实现退出系统功能
 */
public class ExitOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("退出系统!");
        System.exit(0);
    }
}

