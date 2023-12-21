package StudyBasic.ObjectOriented;

/**
 * @Author: 小蔡
 * @Date: 2023/12/8 20:26
 * @description: 面向对象
 *  1-如何定义类
 *      public class 类名{
 *          1.成员变量（代表属性，一般是名词）
 *          2.成员方法（代表行为，一般是动词）
 *          3.构造器
 *          4.代码块
 *          5.内部块
 *      }
 *  2-封装
 *      对象代表什么，就得封装对应的数据，并提供数据对应的行为
 *      private关键字：1-权限修饰符
 *                    2-可以修饰成员（成员变量和成员方法）
 *                    3-被private修饰的对象只能在本类中才能访问
 *      针对于每一个私有化成员变量，都要提供get和set方法
 *          set方法：给成员变量赋值，用public修饰
 *          get方法：对外提供成员变量的值，用public修饰
 *  3-局部变量和成员变量
 *      成员变量: 1-在类方法外
 *               2-在堆内存中（成员变量属于方法，对象进堆内存）
 *               3-随着对象的创建而存在，随着对象的消失而消失
 *               4-有默认初始化值
 *               5-在整个类中有效
 *      局部变量: 1-在方法中或者方法的声明上
 *               2-在栈内存中（局部变量属于方法，方法进栈内存）
 *               3-随着方法的调用而存在，随着方法的调用完毕而消失
 *               4-没有默认的初始化值，必须定义，赋值，然后才能使用
 *               5-在当前方法有效
 *      tips：局部变量名称可以和成员变量名称一样，在方法使用的时候，采用就近原则
 *          eg: public class Main{
 *                  private int age;
 *                  public Student(int age){
 *                      int age = 10;
 *                      System.out.println(age);        // 10
 *                      System.out.println(this.age);   // 0
 *                  }
 *                  public static void main(String[] args) {
 *                      Student();
 *                  }
 *              }
 *  4-构造方法
 *      修饰名 类名（参数）{
 *          方法体;
 *      }
 *      特点：  1-方法名与类名相同，大小写也一致
 *             2-没有返回值类型，连void都没有
 *             3-没有具体的返回值（不能由return带回结构数据）
 *      执行时机： 1-创建对象的时候由虚拟机调用，不能手动调用构造方法
 *               2-每创建一次对象，就会调用一次构造方法
 *      无参构造方法：初始化对象时，成员变量的数据均采用默认值
 *      有参构造方法：初始化对象时，同时可以给对象进行赋值
 *  5-一个对象的内存图
 *      1-加载class文件
 *      2-申明局部变量
 *      3-在堆内存中开辟一个空间
 *      4-默认初始化
 *      5-显示初始化
 *      6-构造方法初始化
 *      7-把堆内存中的地址值赋给左边的局部变量
 */
public class oo {
    private String name;    // 姓名
    private int age;        // 年龄
    private String gender;  // 性别
    private String hobby;   // 爱好

    public oo(){}

    public oo(String name, int age, String gender, String hobby){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public static void main(String[] args) {
        //1.定义数组存入对象
        oo[] arr = new oo[1];
        //2.创建对象
        oo peo1 = new oo("小赖", 19, "小屁孩", "吃零食");
        //3.把对象添加到数组当中
        arr[0] = peo1;

        //4.求和
        int sum = 0;
        for (oo peo : arr) {
            //i 索引 arr[i] 元素（对象）
            //累加
            sum = sum + peo.getAge();
        }

        //5.平均值
        int avg = sum / arr.length;

        //6.统计年龄比平均值低的有几个，打印他们的信息
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            oo peo = arr[i];
            if (peo.getAge() < avg) {
                count++;
                System.out.println(peo.getName() + ", " + peo.getAge() + ", " + peo.getGender() + ", " + peo.getHobby());
            }
        }
        System.out.println(count + "个");
    }
}
