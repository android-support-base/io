package com.amlzq.asb.domain;

/**
 * 用户实体
 * UserInfo
 */
public abstract class User {

    // 基本属性
    public String id; // 用户ID，惟一性
    public String openId; // 用户公开ID，惟一性
    public String nickname; // 昵称，惟一性
    public String gender; // 性别[1男,0女,2边缘群体]
    public int age; // 年龄[0-120]
    public String address; // 地址/住址
    public String idCard; // 身份证
    public String realname; // 实名，姓，名
    public String mobilePhoneNum; // 手机号
    public String email; // 邮箱地址
    public String status; // 心情，生活状态[文字，表情]
    public String personalizedSignature; // 个性签名

    // 拓展字段
    public String wechat; // 微信号
    public String weibo; // 微博
    public String qq; // 腾讯QQ

}
