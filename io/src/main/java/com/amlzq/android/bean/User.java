package com.amlzq.android.bean;

/**
 * 用户实体
 * 普遍性
 * UserInfo
 */
public abstract class User {

    // 基本属性
    public String id; // 用户ID，惟一性
    public String openId; // 用户公开ID，惟一性
    public String nickname; // 昵称，惟一性
    public String gender; // 性别[1男,0女,2边缘群体]
    public int age; // 年龄[0-120]
    public String location; // 地址
    public String idCard; // 身份证
    public String realname; // 实名，姓，名
    public String mobilePhone; // 手机号
    public String email; // 邮箱地址

    // 拓展字段
    public String wechat; // 微信号
    public String weibo; // 微博
    public String qq; // 腾讯QQ

}
