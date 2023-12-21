package StudyBasic.ObjectOriented;

/**
 * @Author: 小蔡
 * @Date: 2023/12/9 0:21
 * @description: 案例2-数组对象4
 */
public class GirlFriend {
    private String name;//姓名
    private int age;//年龄
    private String gender;//性别
    private String hobby;//爱好


    public GirlFriend() {
    }

    public GirlFriend(String name, int age, String gender, String hobby) {
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
        //1.定义数组存入女朋友的对象
        GirlFriend[] arr = new GirlFriend[4];

        //2.创建女朋友对象
        GirlFriend gf1 = new GirlFriend("小诗诗",18,"萌妹子","吃零食");
        GirlFriend gf2 = new GirlFriend("小丹丹",19,"萌妹子","玩游戏");
        GirlFriend gf3 = new GirlFriend("小惠惠",20,"萌妹子","看书，学习");
        GirlFriend gf4 = new GirlFriend("小莉莉",21,"憨妹子","睡觉");

        //3.把对象添加到数组当中
        arr[0] = gf1;
        arr[1] = gf2;
        arr[2] = gf3;
        arr[3] = gf4;

        //4.求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //i 索引 arr[i] 元素（女朋友对象）
            GirlFriend gf = arr[i];
            //累加
            sum = sum + gf.getAge();
        }

        //5.平均值
        int avg = sum / arr.length;

        //6.统计年龄比平均值低的有几个，打印他们的信息
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            GirlFriend gf = arr[i];
            if(gf.getAge() < avg){
                count++;
                System.out.println(gf.getName() + ", " + gf.getAge() + ", " + gf.getGender() + ", " + gf.getHobby());
            }
        }

        System.out.println(count + "个");
    }
}
