package StudyBasic.ObjectOriented;

import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/9 0:18
 * @description: 案例2-对象数组2
 */
public class Car {
    private String brand;//品牌
    private int price;//价格
    private String color;//颜色


    public Car() {
    }

    public Car(String brand, int price, String color) {
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
        //1.创建一个数组用来存3个汽车对象
        Car[] arr = new Car[3];

        //2.创建汽车对象，数据来自键盘录入
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            //创建汽车的对象
            Car c = new Car();
            //录入品牌
            System.out.println("请输入汽车的品牌");
            String brand = sc.next();
            c.setBrand(brand);
            //录入价格
            System.out.println("请输入汽车的价格");
            int price = sc.nextInt();
            c.setPrice(price);
            //录入颜色
            System.out.println("请输入汽车的颜色");
            String color = sc.next();
            c.setColor(color);

            //把汽车对象添加到数组当中
            arr[i] = c;
        }

        //3.遍历数组
        for (Car car : arr) {
            System.out.println(car.getBrand() + ", " + car.getPrice() + ", " + car.getColor());
        }
    }
}
