package StudyBasic.ObjectOriented;

/**
 * @Author: 小蔡
 * @Date: 2023/12/9 0:20
 * @description: 案例2-数组对象3
 */
public class Phone {
    private String brand;//品牌
    private int price;//价格
    private String color;//颜色

    public Phone() {
    }

    public Phone(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        //1.创建一个数组
        Phone[] arr = new Phone[3];

        //2.创建手机的对象
        Phone p1 = new Phone("小米",1999,"白色");
        Phone p2 = new Phone("华为",4999,"蓝色");
        Phone p3 = new Phone("魅族",3999,"红色");

        //3.把手机对象添加到数组当中
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;

        //4.获取三部手机的平均价格
        int sum = 0;
        for (Phone phone : arr) {
            //i 索引  arr[i] 元素（手机对象）
            sum = sum + phone.getPrice();
        }

        //5.求平均值
        //数据能不写死，尽量不写死
        //int avg = sum / arr.length;
        double avg2 = sum * 1.0 / arr.length;
        System.out.println(avg2);   // 3665.6666666666665
    }
}
