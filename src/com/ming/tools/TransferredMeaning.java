package com.ming.tools;
import com.sun.media.jfxmedia.logging.Logger;

import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.*;

/**
 * @author ming
 * 转义，用于防止sql注入
 */
public class TransferredMeaning {
    private static final String REGEX = "[';\"]";
    private static final String REPLACE = "";
    public static String getTransferredMeaning(String transferredMeaningGetTransferredMeaningIput){
        String input;
        input = transferredMeaningGetTransferredMeaningIput;
        // 创建模式匹配
        Pattern p = null;
        p = compile(REGEX);
        // 进行匹配,将会返回一个匹配器
        Matcher m = p.matcher(input);
        // 调用匹配器的replaceAll进行完全替换
        return m.replaceAll(REPLACE);
    }
    /*
    public static void main(String[] args){
        System.out.println(getTransferredMeaning("\'sdferf"));
    }
    */
}
