package com.ming.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// 此类封装了sha-2的加密算法，实现传入String类型，返回加密后的sha-2 的String类型
public class Encryption {
    public static String getSHA(String input){
        try{
            // 使用sha-2方法
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // 使用digets方法
            // 然后计算输入的信息摘要
            // 将会返回数组的byte类型
            byte[] messageDigets = md.digest(input.getBytes());
            // BigInteger 不可变的任意的精度的整数，用二进制的补码表示
            // 用来操作，大数，确保精确度
            // 其中 第一个参数表示保存的为正数，第二个参数为保存的数组
            BigInteger no = new BigInteger(1, messageDigets);
            // 将消息摘要转换成为16进制
            String hashText = no.toString(16);
            while(hashText.length() < 32){
                // 进行补0操作，保证位数相同
                hashText = "0" + hashText;
            }
            return hashText;
        }catch(NoSuchAlgorithmException e){
            System.out.println(e);
            return null;
        }
    }


    public static void main(String[] args){
        String s1 = "sdfsfsrgd";
        System.out.println(getSHA(s1));

    }

}
