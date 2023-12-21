package com.BlackHorse.EasyItem.ATMSystem;

/**
 * @Author: 小蔡
 * @Date: 2023/12/13 21:01
 * @description: ATM系统--基本数据
 */
public class Account {
    private String cardId;
    private String userName;
    private char sex;
    private String passWord;
    private double money;
    private double limit; // 限额

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName + ( sex  == '男' ? "先生" : "女士");
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
