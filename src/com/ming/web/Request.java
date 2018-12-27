package com.ming.web;

import java.io.*;
import java.net.*;

/**
 * @author ming
 * 请求类,用于获取客户的http请求，来分析客户所需要的文件
 */
public class Request {
    InputStream in = null;

    // 获取输入流
    public Request(InputStream input){
        this.in = input;
    }

    // 解析请求
    public String parse(){
        // 从Socket读取一组数据
        StringBuffer requestStr = new StringBuffer(2048);
        int i;
        // 定义8位字节，该字节数组长度为2048
        byte[] buffer = new byte[2048];
        try{
            // 将读到的放入buffer中
            i = in.read(buffer);
        }catch(IOException e){
            e.printStackTrace();
            i = -1;
        }
        // 将缓冲区保存的强制转为char型
        for(int j = 0; j < i; j++){
            requestStr.append((char)buffer[j]);
        }
        // 返回解析的请求
        System.out.println(getUrl(requestStr.toString()));
        return getUrl(requestStr.toString());
    }
    // 获取URL信息
    // 目的在于将url浏览器发送的套接字进行截取，目的在于获取第二个浏览器发送的套接字内容
    private String getUrl(String requestString){
        int index1, index2;
        index1 = requestString.indexOf(" ");
        if(index1 != -1){
            index2 = requestString.indexOf(" ", index1 + 1);
            if(index2 > index1){
                return requestString.substring(index1+2, index2);
            }
        }
        return null;
    }
}
