package com.BlackHorse.EasyItem.StudentSystem_op;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: 小蔡
 * @Date: 2023/12/14 22:43
 * @description: 学生管理系统-优化
 */
public class APP {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1登录 2注册 3忘记密码");
            String choose = sc.next();
            switch (choose) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("谢谢使用，再见");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    private static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            String username = sc.next();
            //判断用户名是否存在
            boolean flag = contains(list, username);
            if (!flag) {
                System.out.println("用户名" + username + "未注册，请先注册再登录");
                return;
            }
            System.out.println("请输入密码");
            String password = sc.next();
            while (true) {
                String rightCode = getCode();
                System.out.println("当前正确的验证码为：" + rightCode);
                System.out.println("请输入验证码");
                String code = sc.next();
                if (code.equalsIgnoreCase(rightCode)) {
                    System.out.println("验证码正确");
                    break;
                } else {
                    System.out.println("验证码错误");
                    continue;
                }
            }

            //验证用户名和密码是否正确
            //集合中是否包含用户名和密码
            //定义一个方法验证用户名和密码是否正确
            //封装思想的应用：
            //我们可以把一些零散的数据，封装成一个对象
            //以后传递参数的时候，只要传递一个整体就可以了，不需要管这些零散的数据。
            User useInfo = new User(username, password, null, null);
            boolean result = checkUserInfo(list, useInfo);
            if (result) {
                System.out.println("登录成功，可以开始使用学生管理系统了");
                //创建对象调用方法，启动学生管理系统
                StudentSystem ss = new StudentSystem();
                ss.startStudentSystem();
                break;
            } else {
                System.out.println("登录失败，用户名或密码错误");
                if (i == 2) {
                    System.out.println("当前账号" + username + "被锁定，请联系黑马程序员客服：XXX-XXXXX");
                    //当前账号锁定之后，直接结束方法即可
                    return;
                } else {
                    System.out.println("用户名或密码错误，还剩下" + (2 - i) + "次机会");
                }
            }
        }
    }

    private static boolean checkUserInfo(ArrayList<User> list, User useInfo) {
        //遍历集合，判断用户是否存在，如果存在登录成功，如果不存在登录失败
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(useInfo.getUsername()) && user.getPassword().equals(useInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }

    private static void forgetPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        boolean flag = contains(list, username);
        if (!flag) {
            System.out.println("当前用户" + username + "未注册，请先注册");
            return;
        }

        //键盘录入身份证号码和手机号码
        System.out.println("请输入身份证号码");
        String personID = sc.next();
        System.out.println("请输入手机号码");
        String phoneNumber = sc.next();

        //需要把用户对象通过索引先获取出来。
        int index = findIndex(list, username);
        User user = list.get(index);
        //比较用户对象中的手机号码和身份证号码是否相同
        if (!(user.getPersonID().equalsIgnoreCase(personID) && user.getPhoneNumber().equals(phoneNumber))) {
            System.out.println("身份证号码或手机号码输入有误，不能修改密码");
            return;
        }

        //当代码执行到这里，表示所有的数据全部验证成功，直接修改即可
        String password;
        while (true) {
            System.out.println("请输入新的密码");
            password = sc.next();
            System.out.println("请再次输入新的密码");
            String againPassword = sc.next();
            if (password.equals(againPassword)) {
                System.out.println("两次密码输入一致");
                break;
            } else {
                System.out.println("两次密码输入不一致，请重新输入");
                continue;
            }
        }

        //直接修改即可
        user.setPassword(password);
        System.out.println("密码修改成功");
    }

    private static int findIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if(user.getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }

    private static void register(ArrayList<User> list) {
        //1.键盘录入用户名
        Scanner sc = new Scanner(System.in);
        String username;
        while (true) {
            System.out.println("请输入用户名");
            username = sc.next();
            //开发细节：先验证格式是否正确，再验证是否唯一
            //         因为在以后所有的数据，都是存在数据库中，如果我们要校验，需要使用到网络资源。
            boolean flag1 = checkUsername(username);
            if (!flag1) {
                System.out.println("用户名格式不满足条件，需要重新输入");
                continue;
            }

            //校验用户名唯一
            //username到集合中判断是否有存在
            boolean flag2 = contains(list, username);
            if (flag2) {
                //用户名已存在，那么当前用户名无法注册，需要重新输入
                System.out.println("用户名" + username + "已存在，请重新输入");
            } else {
                //不存在，表示当前用户名可用，可以继续录入下面的其他数据
                System.out.println("用户名" + username + "可用");
                break;
            }
        }
        //2.键盘录入密码
        //密码键盘输入两次，两次一致才可以进行注册。
        String password;
        while (true) {
            System.out.println("请输入要注册的密码");
            password = sc.next();
            System.out.println("请再次输入要注册的密码");
            String againPassword = sc.next();
            if (!password.equals(againPassword)) {
                System.out.println("两次密码输入不一致，请重新输入");
                continue;
            } else {
                System.out.println("两次密码一致，继续录入其他数据");
                break;
            }
        }
        //3.键盘录入身份证号码
        String personID;
        while (true) {
            System.out.println("请输入身份证号码");
            personID = sc.next();
            boolean flag = checkPersonID(personID);
            if (flag) {
                System.out.println("身份证号码满足要求");
                break;
            } else {
                System.out.println("身份证号码格式有误，请重新输入");
                continue;
            }
        }
        //4.键盘录入手机号码
        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号码");
            phoneNumber = sc.next();
            boolean flag = checkPhoneNumber(phoneNumber);
            if (flag) {
                System.out.println("手机号码格式正确");
                break;
            } else {
                System.out.println("手机号码格式有误，请重新输入");
                continue;
            }
        }
        //用户名，密码，身份证号码，手机号码放到用户对象中
        User u = new User(username, password, personID, phoneNumber);
        //把用户对象添加到集合中
        list.add(u);
        System.out.println("注册成功");
        //遍历集合
        printList(list);
    }

    private static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            //i 索引
            User user = list.get(i);
            System.out.println(user.getUsername() + ", " + user.getPassword() + ", "
                    + user.getPersonID() + ", " + user.getPhoneNumber());
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        //长度为11位
        if (phoneNumber.length() != 11) {
            return false;
        }
        //不能以0为开头
        if (phoneNumber.startsWith("0")) {
            return false;
        }
        //必须都是数字
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        //当循环结束之后，表示每一个字符都在0-9之间
        return true;
    }

    private static boolean checkPersonID(String personID) {
        //长度为18位
        if (personID.length() != 18) {
            return false;
        }
        //不能以0为开头
        if (personID.startsWith("0")) {
            //如果以0开头，那么返回false
            return false;
        }
        //前17位，必须都是数字
        for (int i = 0; i < personID.length() - 1; i++) {
            char c = personID.charAt(i);
            //如果有一个字符不在0-9之间，那么直接返回false
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        //最为一位可以是数字，也可以是大写X或小写x
        char endChar = personID.charAt(personID.length() - 1);
        if ((endChar >= '0' && endChar <= '9') || (endChar == 'x') || (endChar == 'X')) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean contains(ArrayList<User> list, String username) {
        //循环遍历集合得到每一个用户对象
        //拿着用户对象中的用户名进行比较
        for (int i = 0; i < list.size(); i++) {
            //i 索引
            User user = list.get(i);
            String rightUsername = user.getUsername();
            if (rightUsername.equals(username)) {
                return true;
            }
        }
        //当循环结束了，表示集合里面所有的用户都比较完毕了，还没有一样的，则返回false
        return false;
    }

    private static boolean checkUsername(String username) {
        //用户名长度必须在3~15位之间
        int len = username.length();
        if (len < 3 || len > 15) {
            return false;
        }
        //当代码执行到这里，表示用户名的长度是符合要求的。
        //继续校验：只能是字母加数字的组合
        //循环得到username里面的每一个字符，如果有一个字符不是字母或者数字，那么就返回false
        for (int i = 0; i < username.length(); i++) {
            //i 索引
            char c = username.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }
        //当代码执行到这里,表示什么？
        //用户名满足两个要求：1长度满足 2内容也满足（字母+数字）
        //但是不能是纯数字
        //统计在用户名中，有多少字母就可以了。
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            //i 索引
            char c = username.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                break;
            }
        }
        return count > 0;
    }

    private static String getCode() {
        //1.创建一个集合添加所有的大写和小写字母
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }

        StringBuilder sb = new StringBuilder();
        //2.要随机抽取4个字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            //获取随机索引
            int index = r.nextInt(list.size());
            //利用随机索引获取字符
            char c = list.get(index);
            //把随机字符添加到sb当中
            sb.append(c);
        }

        //3.把一个随机数字添加到末尾
        int number = r.nextInt(10);
        sb.append(number);

        //4.如果我们要修改字符串中的内容
        //先把字符串变成字符数组，在数组中修改，然后再创建一个新的字符串
        char[] arr = sb.toString().toCharArray();
        //拿着最后一个索引，跟随机索引进行交换
        int randomIndex = r.nextInt(arr.length);
        //最大索引指向的元素 跟随机索引指向的元素交换
        char temp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        return new String(arr);
    }
}
