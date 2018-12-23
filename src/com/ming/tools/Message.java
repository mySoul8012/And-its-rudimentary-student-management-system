package com.ming.tools;


import java.util.Random;
import java.lang.String;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

/**
 * @author ming
 * 短信发送
 */
public class Message {
    /*
    public static void main(String[] args){
        sedMessage("18537806592", "2324");
    }
    */
    // 短信发送方法
    public static boolean sedMessage(String phoneNumber, String rand){
        int appid = Integer.parseInt(ReadJson.getReadJson().getJSONObject("message").getString("appid"));
        String appkey = ReadJson.getReadJson().getJSONObject("message").getString("appkey");
        String[] phoneNumbers = {phoneNumber};
        int templateId = Integer.parseInt(ReadJson.getReadJson().getJSONObject("message").getString("templateId"));
        String smsSign = ReadJson.getReadJson().getJSONObject("message").getString("smsSign");
        try {
            String[] params = {rand, "15"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            if(result.result == 0 && result.errMsg == "OK"){
                return true;
            }
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return false;
    }
    // 生成随机数
    public static String rand(){
        int min = 100;
        int max = 900;
        Random random = new Random();
        return random.nextInt(max)%(max-min+1) + "";
    }
}
