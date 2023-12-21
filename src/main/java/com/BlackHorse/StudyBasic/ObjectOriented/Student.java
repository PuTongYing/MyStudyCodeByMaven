package StudyBasic.ObjectOriented;

/**
 * @Author: 小蔡
 * @Date: 2023/12/9 0:25
 * @description: 案例3
 */
public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static void main(String[] args) {
        /**
         * 定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号，姓名各不相同。学生的属性：学号，姓名，年龄。
         * 要求3：通过id删除学生信息：如果存在，则删除，如果不存在，则提示删除失败。
         * 要求4：删除完毕之后，遍历所有学生信息。
         * 要求5：查询数组id为“2”的学生，如果存在，则将他的年龄+1岁
        */
        
        //1.创建一个数组用来存储学生对象
        Student[] arr = new Student[3];
        //2.创建学生对象并添加到数组当中
        Student stu1 = new Student(1, "zhangsan", 23);
        Student stu2 = new Student(2, "lisi", 24);
        Student stu3 = new Student(3, "wangwu", 25);

        //3.把学生对象添加到数组当中
        arr[0] = stu1;
        arr[1] = stu2;
        arr[2] = stu3;

        /*要求3：通过id删除学生信息
        如果存在，则删除，如果不存在，则提示删除失败。*/

        //要找到id在数组中对应的索引
        int index = getIndex(arr, 2);
        if (index >= 0){
            //如果存在，则删除
            arr[index] = null;
            //遍历数组
            printArr(arr);
        }else{
            //如果不存在，则提示删除失败
            System.out.println("当前id不存在，删除失败");
        }
    }

    //1.我要干嘛？  找到id在数组中的索引
    //2.我需要什么？ 数组 id
    //3.调用处是否需要继续使用方法的结果？ 要
    public static int getIndex(Student[] arr , int id){
        for (int i = 0; i < arr.length; i++) {
            //依次得到每一个学生对象
            Student stu = arr[i];
            //对stu进行一个非空判断
            if(stu != null){
                int sid = stu.getId();
                if(sid == id){
                    return i;
                }
            }
        }
        //当循环结束之后，还没有找到就表示不存在
        return -1;
    }

    public static void printArr(Student[] arr){
        for (int i = 0; i < arr.length; i++) {
            Student stu = arr[i];
            if(stu != null){
                System.out.println(stu.getId() + ", " + stu.getName() + ", " + stu.getAge());
            }
        }
    }
}
