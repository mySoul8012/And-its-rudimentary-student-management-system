package com.ming.web;

import java.io.*;
import java.net.*;

/**
 * @author ming
 */
public class WebServer {
    // 默认目录
    public static String WEBROOt = "";
    // 默认主页
    public static String defaulPane = "index.html";
    // 服务器启动
    public WebServer() throws IOException{
        // 使用8080端口提供服务
        ServerSocket server = new ServerSocket(8080);
        while(true){
            // 进行阻塞
            // accept用于监听套接字
            Socket sk = server.accept();
            // 如果有请求，此时，启动服务器线程
            new WebThread (sk).start();
        }
    }

}
