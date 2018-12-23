package com.ming.tools;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
/**
 * @author ming
 * 读取json配置文件
 */
public class ReadJson {
    /*
    public static void main(String [] args){
        System.out.println(getReadJson().getJSONObject("message").getString("appid"));
    }
    */
    public static JSONObject getReadJson(){
        File file=new File("src/com/ming/Configuration.json");
        try{
            String content= FileUtils.readFileToString(file,"UTF-8");
            JSONObject jsonObject=new JSONObject(content);
            return jsonObject;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
