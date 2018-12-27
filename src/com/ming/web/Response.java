package com.ming.web;

import com.ming.tools.ReadJson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ming
 * 进行响应
 */
public class Response {
    // 输出流
    OutputStream out = null;

    // 发送请求的文件
    public void Send(String ref) throws IOException{
        byte[] bytes = new byte[2048];
        FileInputStream fis = null;
        try{
            // 新建文件，从父路径名字字符串和子路径名字字符串，创建新实例
            File file = new File(WebServer.WEBROOt + ref);
            System.out.println(ref);
            if(file.exists()){  // 如果文件存在
                // 构造输入文件流
                System.out.println("hello  ");
                fis = new FileInputStream(file);    // 构建出输入流
                // 从输入流中读取0 ～ 2048个字节，闭区间，返回读取到字节长度
                int ch = fis.read(bytes, 0, 2048);
                // 读取文件
                String sBody = new String(bytes);
                // 构造输出信息
                String sendMessage = "HTTP/1.1 200 OK\r\n"  +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: "+ch+"\r\n" +
                        "\r\n" +sBody;
                // 输出文件
                out.write(sendMessage.getBytes());
            }else{
                // 找不到文件
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                out.write(errorMessage.getBytes());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            if(fis != null){
                fis.close();
            }
        }
    }

    // 获取输出流
    public Response(OutputStream outputStream){
        this.out = outputStream;
    }
}
