package com.amlzq.android.json;

/**
 * HTTP接口结果基类
 * 用于将请求结果(JSON数据)转换为实体类型
 *
 * @param <T>
 */
public class ObjectData<T> {

    /**
     * 结果码
     * 规范值:ret
     */
    public int code;
    public int ret;
    /**
     * 结果信息
     * 规范值:msg
     */
    public String message;
    public String msg;
    /**
     * 结果
     */
    public T data;

    // data 为 json object 的正常情况
    // {"code":0,"message":"success","data":{xxx}}
    // {"ret":0,"msg":"success","data":{xxx}}
    // data 为 json object 的异常情况
    // {"code":xxx,"message":"xxx","data":{}}
    // {"ret":xxx,"msg":"xxx","data":{}}

}
