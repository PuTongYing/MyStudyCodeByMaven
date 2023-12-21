package StudyBasic.ObjectOriented;

import java.util.Random;

/**
 * @Author: 小蔡
 * @Date: 2023/12/8 21:42
 * @description: 案例1-文字版格斗游戏
 */
public class Role {
    private String name;
    private int blood;
    private char gender;
    private String face; // 长相是随机的
    String[] boyfaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};

    //attack 攻击描述：
    String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    //injured 受伤描述：
    String[] injureds_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    public Role(){}

    public Role(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        setFace(gender);
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    /**
     * 定义一个方法用于攻击别人
     * 思考：谁攻击谁
     * Role r1 = new Role();
     * Role r2 = new Role();
     */
    public void attack(Role role){
        // 计算造成的伤害 1~20
        Random random = new Random();
        int index = random.nextInt(attacks_desc.length);
        String KungFu = attacks_desc[index];
        //输出一个攻击的效果
        System.out.printf(KungFu, this.getName(), role.getName());
        System.out.println();
        int hurt = random.nextInt(20) + 1;
        // 剩余血量
        int remainBoold = role.getBlood()-hurt;
        remainBoold = Math.max(remainBoold, 0);
        // 修改一下挨揍的人的血量
        role.setBlood(remainBoold);
        /*
          受伤的描述
          血量> 90 0索引的描述
          80 ~  90  1索引的描述
          70 ~  80  2索引的描述
          60 ~  70  3索引的描述
          40 ~  60  4索引的描述
          20 ~  40  5索引的描述
          10 ~  20  6索引的描述
          小于10的   7索引的描述
         */
        if (remainBoold > 90) {
            System.out.printf(injureds_desc[0], role.getName());
        }else if(remainBoold > 80){
            System.out.printf(injureds_desc[1], role.getName());
        }else if(remainBoold > 70){
            System.out.printf(injureds_desc[2], role.getName());
        }else if(remainBoold > 60){
            System.out.printf(injureds_desc[3], role.getName());
        }else if(remainBoold > 40){
            System.out.printf(injureds_desc[4], role.getName());
        }else if(remainBoold > 20){
            System.out.printf(injureds_desc[5], role.getName());
        }else if(remainBoold > 10){
            System.out.printf(injureds_desc[6], role.getName());
        }else{
            System.out.printf(injureds_desc[7], role.getName());
        }
        System.out.println();
    }

    public void setFace(char gender) {
        Random r = new Random();
        //长相是随机的
        if (gender == '男') {
            //从boyfaces里面随机长相
            int index = r.nextInt(boyfaces.length);
            this.face = boyfaces[index];
        } else if (gender == '女') {
            //从girlfaces里面随机长相
            int index = r.nextInt(girlfaces.length);
            this.face = girlfaces[index];
        } else {
            this.face = "面目狰狞";
        }
    }

    public void showRoleInfo() {
        System.out.println("姓名为：" + getName());
        System.out.println("血量为：" + getBlood());
        System.out.println("性别为：" + getGender());
        System.out.println("长相为：" + getFace());
    }

    public static void main(String[] args) {
        // 1-创建第一个角色
        Role r1 = new Role("乔峰", 100, '男');
        // 2-创建第二个角色
        Role r2 = new Role("小赖", 100, '男');
        // 3-开始格斗 回合制游戏
        while (true){
            // r1开始攻击r2
            r1.attack(r2);
            // 判断r2的剩余血量
            if(r2.getBlood() == 0){
                System.out.println(r1.getName() + "K.O" + r2.getName());
                break;
            }
            // r2开始攻击r2
            r2.attack(r1);
            // 判断r1的剩余血量
            if(r1.getBlood() == 0){
                System.out.println(r2.getName() + "K.O" + r1.getName());
                break;
            }
        }
    }
}
