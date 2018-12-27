package com.ming.web;


import java.io.*;
import java.net.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ming
 * 使用线程
 */
public class WebThread extends Thread{
    private Socket sk;  // 创建套接字
    public WebThread(Socket sk){
        this.sk = sk;
    }
    // 运行的线程
    @Override
    public void run(){
        // 输入流
        InputStream in = null;
        // 输出流
        OutputStream out = null;
        try{
            // 和套接字的输入流对接
            in = sk.getInputStream();
            // 和套接字的输出流对接
            out = sk.getOutputStream();
            // 等待请求
            Request rq = new Request(in);   // 此为请求类
            // 获取用户请求的URL
            String sUrl = rq.parse();
            //System.out.println("请求的URL" + sUrl);
            if(sUrl.equals("/")){
                sUrl = WebServer.defaulPane;    // 默认请求修改为index.hyml
                System.out.println(sUrl);
            }
            // 返回给客户端输出流
            Response rp = new Response(out);
            // 往输入流中，输入URL
            rp.Send(sUrl);
        }catch(IOException e){
            System.out.println(e.toString());
        }
        finally{
            // 请求完毕，开始释放资源
            try{
                if(in != null){
                    in.close();
                }
                if(out != null){
                    out.close();
                }
                if(sk != null){
                    sk.close();
                }
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
